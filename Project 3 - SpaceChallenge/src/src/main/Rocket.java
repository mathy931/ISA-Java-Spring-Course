package src.main;

public class Rocket implements SpaceShip{

    public int cargoCarried;
    public int weight ;
    public int cost;

    public int cargoLimit;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (getCargoCarried() + item.getWeight()) <= cargoLimit;
    }

    @Override
    public void carry(Item item) {
        cargoCarried += item.getWeight();
        setCargoCarried(cargoCarried);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCargoCarried() {
        return this.cargoCarried;
    }

    public void setCargoCarried(int cargoCarried) {
        this.cargoCarried = cargoCarried;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }

    public void setCargoLimit(int cargoLimit) {
        this.cargoLimit = cargoLimit;
    }
}
