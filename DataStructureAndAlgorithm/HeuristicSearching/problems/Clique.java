package problems;

/**
 * 
 * @author kevin
 *
 * Problem: 7-9 
 * Book: the Algorithm Design manual
 * 
 * Input: A graph G = (V, E)
 * 
 * Output: The largest S subset of V such that all x, y belong in S, (x, y) belongs in E.
 *
 */

/**
 * Solution: Anealing approache
 * 
 * Observation:
 * - It takes n^2 (worst case) to assess if a set is S
 * - It takes n to assess if a point would fit the set (expand the given S set)
 * - There can be many S set and even have no common vertices
 * - How would transit between 2 total no-joint set?
 * - All vertices in a clique must have the degree larger or equal the number of vertices in clique
 * - The degree of any vertices in a clique must be larger or equal the number of vertices in clique. 
 */

/**
 * A graph exists a clique size m when exits permutation m that (0-i->m-1) (i+1-j->m1) sum(1 - getAdjacent(i, j)) = 0
 * 
 */

import java.util.Random;

public class Clique {
    public static final float INIT_TEMPERATURE = 1.0f;
    public static final float DECAY_RATE = 0.7;
    public static final float TEMPERATURE_MIN = 0.001;
    public static final int NUMBER_ITERATION = 1000;

    public static final int CLIQUE_SIZE_MIN = 3;
    public static final double AVOGADRO = 6.0221367e23;
    public static double BOLTZMANN_K = 1.380658e-23 * 1000 * AVOGADRO * 1e20 * 1e-24;

    int maxSize = -1;
    int[] finalSolution;


	public Clique() {
		
	}
	
	private int[] initSolution (MatrixGraph<E> graph) {
		
		return new int[0];
	}

    private int cost (int[] solution, MatrixGraph<E> graph, int cliqueSize, int lastCost, int lastSize) {
        int adjacencySum = lastCost;
        for (int i = lastSize; i > cliqueSize; i ++) {
            for (int j = 0; j < i; j ++) {
                adjacencySum += (1 - graph.getAdjacency(solution[i], solution[j]));
            }
        }

        return adjacencySum;
    }

    private int transite (int[] solution, MatrixGraph<E> graph, int cliqueSize, int vertex1, int vertex2) {
        int relativeAdjacencyV1 = calRelativeAdjacency(solution, graph, cliqueSize, vertex1);
        swap(solution, vertex1, vertex2);
        int relativeAdjacencyV2 = calRelativeAdjacency(solution, graph, cliqueSize, vertex1);

        int delta = relativeAdjacencyV2 - relativeAdjacencyV1;

        return delta;
    }

    private int calRelativeAdjacency (int[] solution, MatrixGraph<E> graph, int cliqueSize, int vertexIndex) {
        int adjacency = 0;
        for (int i = 0; i < cliqueSize; i ++) {
            adjacency += (1 - graph.getAdjacency(solution[i], solution[vertexIndex]));
        }

        return adjacency;

    }

    private void swap (int[] array, int v1, int v2) {
        int temp = array[v1];
        array[v1] = array[v2];
        array[v2] = temp;
    }

    private int getLargestDegree (MatrixGraph<E> graph) {

    }


    public findMaxClique (MatrixGraph<E> graph) {
        int optimalSolution;

        double temperature = INIT_TEMPERATURE;

        int cliqueSize = 3;

        int maxCliqueSize = getLargestDegree(graph);

        int[] currentSolution = initSolution(graph);
        int currentAdjacency = cost(solution, graph, cliqueSize, 0, 0);

        Random random = new Random();
        
        while (temperature > TEMPERATURE_MIN) {
            temperature *= DECAY_RATE;

            int startAdjacency = currentAdjacency;

            for (int i = 0; i < NUMBER_ITERATION; i ++) {
                //Pick 2 vertices
                int index1 = random.nextInt(cliqueSize);
                int index2 = random.nextInt(solution.length-cliqueSize) + cliqueSize;

                double flip = Math.random();

                //Calculate delta
                delta = transit (solution, graph, cliqueSize, index1, index2);
                //Is accept?
                double exponent = (-delta/currentAdjacency)/(BOLTZMANN_K*temperature);
                double merit = Math.pow(Math.exp(), exponent);

                if (delta < 0)
                    currentAdjacency = currentAdjacency + delta;
                else if (merit > flip) 
                    currentAdjacency += delta;
                else 
                    transit (solution, graph, cliqueSize, index1, index2);
                //Is a clique -> increase size 
                if (currentAdjacency == 0) {
                    saveSolution(cliqueSize, solution);
                    cliqueSize ++;
                    currentAdjacency = cost(solution, graph, cliqueSize, currentAdjacency, cliqueSize-1); 
                }
            }

            if ((currentAdjacency - startAdjacency) <0.0) {
                temperature = temperature / DECAY_RATE;
            }
            
        }
    }

    private void saveSolution (int cliqueSize, int[] solution) {

    }
	
	
}
