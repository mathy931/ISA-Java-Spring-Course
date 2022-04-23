package src.main;

public class U2 extends Rocket{


    U2() {
        setCost(120);
        setWeight(18000);
        setCargoCarried(0);
        setCargoLimit(29000);
    }

    @Override
    public boolean launch() {
        double randNumber = Math.random() * 100;
        double chanceOfExploding = (0.04 * (this.cargoCarried/this.cargoLimit)) * 100;

        return chanceOfExploding <= randNumber;

    }

    @Override
    public boolean land() {
        double randNumber = Math.random() * 100;
        double chanceOfExploding = (0.08 * (this.cargoCarried/this.cargoLimit)) * 100;

        return chanceOfExploding <= randNumber;
    }
}
