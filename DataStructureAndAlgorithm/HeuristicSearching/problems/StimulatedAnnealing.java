

public abstract class StimulatedAnnealing {
    public static final double INIT_TEMPERATURE = 1.0f;
    public static final double DECAY_RATE = 0.7;
    public static final double TEMPERATURE_MIN = 0.001;
    public static final int NUMBER_ITERATION = 1000;
    public static final int COOLING_STEP = 100;

    public static final double AVOGADRO = 6.0221367e23;
    public static final double BOLTZMANN_K = 1.380658e-23 * 1000 * AVOGADRO * 1e20 * 1e-24;

    public static final int ITEM_1 = 0;
    public static final int ITEM_2 = 1;


    public void anneal () {
        double temperature = INIT_TEMPERATURE;

        int[] currentSolution = initSolution();
        int currentValue = evaluateCost(currentSolution);

        for (int i = 0; i < COOLING_STEP; i ++) {
            temperature = temperature * DECAY_RATE;

            int startValue = currentValue;


            for (int j = 0; j < NUMBER_ITERATION; j ++) {

                int[] swapIndexes = randomizeIndexes ();

                double flip = Math.random();

                int delta = transit (solution, swapIndexes[ITEM_1], swapIndexes[ITEM_2]);

            }
        }
    }


    public abstract int[] initSolution ();
    public abstract int evaluateCost (int[] solution);
    public abstract int transit (int[] solution, int item1, int item2);
    public abstract int[] randomizeIndexes ();

    

}
