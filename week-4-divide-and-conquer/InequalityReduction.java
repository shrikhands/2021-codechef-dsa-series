package week4divideNconquer;

import java.util.Arrays;
import java.util.Scanner;

public class InequalityReduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int n = input.nextInt(), r = input.nextInt();
			
			long[] coins = new long[n];
			for (int i = 0; i < n; i++)
				coins[i] = input.nextLong();
			
			Arrays.sort(coins);
			
			long temp = 0, ans = coins[n-1];
			for (int i = 0; i < n; i++) {
				temp += coins[i];
				ans = Math.min(ans, (temp/(i+1)) + (r*(n-i-1)));
			}
			
			System.out.println(ans);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
}