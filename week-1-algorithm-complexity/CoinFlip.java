package week1complexity;

import java.util.Scanner;

public class CoinFlip {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
		
		while (testCases-- > 0) {
			int G = Integer.parseInt(input.nextLine());
			
			while (G-- > 0) {
				String[] values = input.nextLine().split(" ");
				int initialState = Integer.parseInt(values[0]), n = Integer.parseInt(values[1]), finalState = Integer.parseInt(values[2]);
				int ans = n / 2;
				
				
				if (initialState == 1 && finalState == 2) {
					ans = n - ans;
				} else if (initialState == 2 && finalState == 1) {
							ans = n - ans;
				}
				 
				System.out.println(ans);
			}
		}
		
	}	// main
}