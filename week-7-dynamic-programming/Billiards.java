package week7dynamicProgramming;

import java.util.Scanner;

public class Billiards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MOD = 1000000009;
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		int[] dp = new int[1000001];
		dp[0] = dp[1] = 0; dp[2] = dp[3] = 1;
		
		for (int i = 4; i <= 1000000; i++)
			dp[i] = (dp[i-2] + dp[i-3])%MOD;
		
		while (T-- > 0) {
			int X = input.nextInt();
			
			System.out.println(dp[X]);
		}
		 
	} // main
}