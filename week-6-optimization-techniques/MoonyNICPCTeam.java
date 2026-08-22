package week6optimizationTechniques;

import java.util.Scanner;

public class MoonyNICPCTeam {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			int N = input.nextInt();
			long[] ratings = new long[N];
			for (int i = 0; i < N; i++)
				ratings[i] = input.nextLong();
			
			long curMax = Long.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				long p1 = ratings[(i-1+N)%N], p2 = ratings[i], p3 = ratings[(i+1)%N];
				
				curMax = Math.max(curMax, (p1+p2+p3));
			}
			
			System.out.println(curMax);
		}
		
	} // main
}