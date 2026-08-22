package week7dynamicProgramming;

import java.util.Scanner;

public class WashingWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		while (T-- > 0) {
			String[] str = input.nextLine().split(" ");
			int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
			
			int[][] windows = new int[n][m];
			for (int i = 0; i < n; i++) {
				str = input.nextLine().split(" ");
				for (int j = 0; j < m; j++)
					windows[i][j] = Integer.parseInt(str[j]);
			}
			
			for (int j = 0; j < m; j++)
				System.out.print("1");
			System.out.println();
			
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int max = windows[i-1][j];
					
					if (j-1 >= 0) //top left
						max = Math.max(max, windows[i-1][j-1]);
					if (j+1 < m) //top right
						max = Math.max(max, windows[i-1][j+1]);
					
					if (max > windows[i][j]) {
						windows[i][j] = max;
						System.out.print("0");
					} else
						System.out.print("1"); 
				}
				System.out.println();
			}
		}
		
	} // main
}