package week6optimizationTechniques;

import java.util.Scanner;

public class LittleChefNSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			int N = input.nextInt();
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++)
				arr[i] = input.nextInt();

			int minSoFar = Integer.MAX_VALUE, minIndex = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < minSoFar) {
					minSoFar = arr[i];
					minIndex = i;
				}
			}
			
			System.out.println(minIndex+1);
		}
		
	} // main
}