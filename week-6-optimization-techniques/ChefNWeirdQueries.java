package week6optimizationTechniques;

import java.util.Scanner;

public class ChefNWeirdQueries {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			long Y = input.nextLong();
			
			long bMaxRange = Y > 700 ? 700 : Y;
			
			int ans = 0;
			for (long i = 1; i <= bMaxRange; i++) {
				ans += (long) Math.sqrt(Y - i);
			}
			
			System.out.println(ans);
		}
		
	} // main
}