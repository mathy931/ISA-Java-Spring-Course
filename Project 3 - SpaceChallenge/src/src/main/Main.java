package src.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Simulation newSimulation = new Simulation();

        ArrayList<Item> phase1 = newSimulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = newSimulation.loadItems("phase-2.txt");

        ArrayList<Rocket> u1FleetPhase1 = newSimulation.loadU1(phase1);
        ArrayList<Rocket> u1FleetPhase2 = newSimulation.loadU1(phase2);

        ArrayList<Rocket> u2FleetPhase1 = newSimulation.loadU2(phase1);
        ArrayList<Rocket> u2FleetPhase2 = newSimulation.loadU2(phase2);

        int totalBudgetU1 =  newSimulation.runSimulation(u1FleetPhase1)+newSimulation.runSimulation(u1FleetPhase2);
        int totalBudgetU2 =  newSimulation.runSimulation(u2FleetPhase1)+newSimulation.runSimulation(u2FleetPhase2);

        System.out.println("Total budget for U1 rockets is " + totalBudgetU1 + ".");
        System.out.println("Total budget for U2 rockets is " + totalBudgetU2 + ".");


    }
}
