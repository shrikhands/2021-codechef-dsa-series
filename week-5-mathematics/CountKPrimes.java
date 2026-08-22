package week5mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class CountKPrimes {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		int[] sieve = new int[100001]; 
		Arrays.fill(sieve, 0);  
		
		for (int i = 2; i <= 100000; i++) {
			if (sieve[i] == 0) {
				sieve[i] = 1;
				for (int j = 2; j*i <= 100000; j++) {
					sieve[i*j]++;
				}
			}
		}
		
		int[][] prefix = new int[100001][6];
		
		for (int i = 1; i <= 5; i++)
			prefix[0][i] = 0;
		
		for (int k = 1; k <= 5; k++) {
			for (int i = 1; i <= 100000; i++) {
				prefix[i][k] = prefix[i-1][k] + (sieve[i] == k ? 1 : 0);
			}
		}
		
		while (T-- > 0) {
			String[] nums = input.nextLine().split(" ");
			int A = Integer.parseInt(nums[0]), B = Integer.parseInt(nums[1]), K = Integer.parseInt(nums[2]);
			
			int ans = prefix[B][K] - prefix[A-1][K];
			System.out.println(ans);
		}
		
	} // main
}