package week6optimizationTechniques;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// {1, 2, 3, 1, 4, 5, 2, 3, 6}
		int[] arr = new int[9];
		arr[0] = 1; arr[1] = 2; arr[2] = 3; arr[3] = 1; arr[4] = 4; 
		arr[5] = 5; arr[6] = 2; arr[7] = 3; arr[8] = 6; 
		int K = 3, i = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (i = 0; i < K; i++)
			pq.add(arr[i]);
		
		System.out.print(pq.peek() + " ");
		pq.remove(arr[0]);
		
		for (; i < arr.length; i++) {
			pq.add(arr[i]);
			System.out.print(pq.peek() + " ");
			pq.remove(i-K+1);
		}
		
	} // main
}