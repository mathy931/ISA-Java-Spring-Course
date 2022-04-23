package src.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String inputFile) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<Item>();
        File file = new File(inputFile);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            try {
                String[] line = sc.nextLine().split("=");
                items.add(new Item(line[0], Integer.parseInt(line[1])));
            } catch (Exception e) {
                System.out.println("File not found or incorrect content.");
                break;
            }
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> u1ArrayList = new ArrayList<>();
        Rocket u1 = new U1();
        for (Item item : items) {
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                u1ArrayList.add(u1);
                u1 = new U1();
                u1.carry(item);
            }
        }
        if (items.size() != 0) {
            u1ArrayList.add(u1);
        }
        return u1ArrayList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> u2ArrayList = new ArrayList<>();
        Rocket u2 = new U1();
        for (Item item : items) {
            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                u2ArrayList.add(u2);
                u2 = new U1();
                u2.carry(item);
            }
        }
        if (items.size() != 0) {
            u2ArrayList.add(u2);
        }
        return u2ArrayList;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalBudget = 0;
        for (int i = 0; i < rockets.size(); i++)
            while ((rockets.get(i).launch() && rockets.get(i).land())) {
                totalBudget += rockets.get(i).getCost();
            }
        return totalBudget;
    }
}

