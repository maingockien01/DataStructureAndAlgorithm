package problems;

import java.lang.reflect.Array;
import java.util.Random;

import src.MatrixGraph;
import src.Vertex;

/**
 * Problem: Bandwidth Reduction
 *
 * Input description: A graph G=(V, E) represent n x n matrix of zero and non-zero elements
 *
 * Problem Description: Which permutation p of the vertices minimizes the length when the vertices are ordered on a line 
 *
 * Problem 7-7 (13-2) - the Algorithm Design Manual
 */

/**
 * Discussion: Anealing model 
 * - What we need to do:
 *   + Evaluate the longest length of between 2 vertices in a permutation
 *   + Compare and pick the smallest among longest length
 * - 
*/

public class BandwidthReduction<E> {

	public final float LOSS_ACCEPT_DELTA = 0.01f;
	public final int NUMBER_RANDOM_INDEX = 2;
	public final int TRIAL_NUMBER = 1000;
	
	Vertex<E>[] getArrangement (MatrixGraph<E> graph) {
		Vertex<E>[] solution = initSolution(graph);
		
		int sum = evaluateSumLength(solution, graph);
		
		for (int i = 0; i < TRIAL_NUMBER; i ++) {
			int[] swapIndexes = randomize2Index(0, solution.length);
			
			int delta = transitionDelta(solution, graph, swapIndexes[0], swapIndexes[1]);
			
			int merit = sum + delta;
			int flip = (int) (Math.random() * solution.length);
			
			if (delta < 0 || merit > flip) {
				swap(solution, swapIndexes[0], swapIndexes[1]);
				sum += delta;
			}
		}
		
		return solution;
	}

	private Vertex<E>[] initSolution(MatrixGraph<E> graph) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int[] randomize2Index (int smallest, int largest) {
		int[] indexes = new int[NUMBER_RANDOM_INDEX];
		Random random = new Random ();
		boolean isGenerated = false;
		while (!isGenerated) {
			int firstIndex = random.nextInt(largest-smallest) + smallest;
			int secondIndex = random.nextInt(largest-smallest) + smallest;
			if (firstIndex != secondIndex) {
				indexes[0] = firstIndex;
				indexes[1] = secondIndex;
				isGenerated = true;
			}
		}
		
		return indexes;
	}
	
	private int evaluateSumLength (Vertex<E>[] solution, MatrixGraph<E> graph) {
		int sum = 0;
		for(int i = 0; i < solution.length; i ++) {
			for (int j = i + 1; j < solution.length; j ++) {
				if (graph.isEdge(i, j)) {
					sum += (j-i);
				}
			}
		}
		
		return sum;
	}
	
	private int transitionDelta (Vertex<E>[] solution, MatrixGraph<E> graph, int vertex1, int vertex2) {
		int delta = 0;
		
		for (int i = 0; i < solution.length; i ++) {
			if (graph.isEdge(vertex1, i) && i != vertex2) {
				delta += Math.abs(vertex2 - i) - Math.abs(vertex1 - i);
			}
		}
		
		for (int i = 0; i < solution.length; i ++) {
			if (graph.isEdge(vertex2, i) && i != vertex1) {
				delta += Math.abs(vertex1 - i) - Math.abs(vertex2 - i);
			}
		}
		
		return delta;
	}
	
	private void swap (Vertex<E>[] solution, int vertex1, int vertex2) {
		Vertex<E> temp;
		temp = solution[vertex1];
		solution[vertex1] = solution[vertex2];
		solution[vertex2] = temp;
	}
	
}