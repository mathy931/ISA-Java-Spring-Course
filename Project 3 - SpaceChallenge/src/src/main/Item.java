package src.main;

public class Item {

    String name;
    int weight;

    public Item(String name, int weight) {
        this.name=name;
        this.weight=weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
