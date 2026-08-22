package week3collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SaveKonoha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner input = new Scanner(System.in);
			int testCases = Integer.parseInt(input.nextLine());
		
			while (testCases-- > 0) {
				String[] input1 = input.nextLine().split(" ");
				int N = Integer.parseInt(input1[0]), Z = Integer.parseInt(input1[1]);
				String[] powers = input.nextLine().split(" ");
				
				// max-heap
				PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
				for (int i = 0; i < N; i++) 
					pq.offer(Integer.parseInt(powers[i]));
				
				int hits = 0, pow = 0;
				while (Z > 0 && !pq.isEmpty()) {
					pow = pq.poll();
					Z -= pow;
					
					if (pow/2 != 0)
						pq.offer(pow/2);
					
					hits++;
				}
				
				if (Z > 0)
					System.out.print("Evacuate");
				else
					System.out.println(hits);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	} // main
}