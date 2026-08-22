package week6optimizationTechniques;

import java.util.Scanner;

public class RangeSumQueriesWOUpdate {

	public static void prefixSum(int[] arr) {
		for (int i = 1; i < arr.length; i++)
			arr[i] = arr[i] + arr[i-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[5];
		arr[0] = 1; arr[1] = 2; arr[2] = 3; arr[3] = 4; arr[4] = 5;
		int queries = 2;
		Scanner input = new Scanner(System.in);
		
		prefixSum(arr);
		
		while (queries-- > 0) {
			int i = Integer.parseInt(input.nextLine()), j = Integer.parseInt(input.nextLine());
		
			System.out.println(arr[j] - arr[i-1]);
		}
		
		
	} // main
}