package src.main;

public class U1 extends Rocket{




    U1() {
        setCost(100);
        setWeight(10000);
        setCargoCarried(0);
        setCargoLimit(18000);
    }

    @Override
    public boolean launch() {
        double randNumber = Math.random() * 100;
        double chanceOfExploding = (0.05 * ((double)this.cargoCarried/(double)this.cargoLimit)) * 100;

        return chanceOfExploding <= randNumber;

    }

    @Override
    public boolean land() {
        double randNumber = Math.random() * 100;
        double chanceOfExploding = (0.01 * ((double)this.cargoCarried/(double)this.cargoLimit)) * 100;

        return chanceOfExploding <= randNumber;
    }
}
