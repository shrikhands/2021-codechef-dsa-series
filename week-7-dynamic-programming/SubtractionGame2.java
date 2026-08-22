package week7dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubtractionGame2 {
	
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		
		return gcd(b%a, a);
	}
	
	static long[][] dp = new long[61][10001];
	
	public static long calculateSeqCount(List<Integer> arr, int pos, int gcdVal) {
		if (dp[pos][gcdVal] < 0) {
			if (arr.size() <= pos)
				dp[pos][gcdVal] = gcdVal == 1 ? 1L : 0;
			else
				dp[pos][gcdVal] = calculateSeqCount(arr, pos+1, gcdVal) + 
								  calculateSeqCount(arr, pos+1, gcd(gcdVal, arr.get(pos)));
		}
		
		return dp[pos][gcdVal];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		while (T-- > 0) {
			int n = input.nextInt();
			List<Integer> arr = new ArrayList<Integer>(); 
			
			for (int i = 0; i < n; i++)
				arr.add(input.nextInt());
			
			for (long[] dpRow : dp)
				Arrays.fill(dpRow, -1);
			
			System.out.println(calculateSeqCount(arr, 0, 0));
		}
		
	}
}