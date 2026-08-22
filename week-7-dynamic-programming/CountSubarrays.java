package week7dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CountSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			int n = input.nextInt(); //4
			long[] nums = new long[n]; //4: 0-3
			for (int i = 0; i < n; i++)
				nums[i] = input.nextLong();
			
			int[] dp = new int[n]; 
			Arrays.fill(dp, 1);
			for (int i = 1; i < n; i++) {
				if (nums[i-1] <= nums[i])
					dp[i] = dp[i-1] + 1;
			}
			
			int res = 0;
			for (int i : dp)
				res += i;
			
			System.out.println(res);
		}
		
	}
}