package week5mathematics;

import java.util.Scanner;

public class EasyFibonacci {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		int[] fibs = new int[60];
		fibs[0] = 0; fibs[1] = 1;
		for (int i = 2; i < 60; i++) {
			fibs[i] = (fibs[i-1] + fibs[i-2])%10;
		}
		
		while (T-- > 0) {
			long N = Long.parseLong(input.nextLine());
			long i = 1;
			
			while (i*2 <= N) {
				i *= 2;
			}

			int index = (int)((i-1)%60);
			System.out.println(fibs[index]);
		}
		
	} // main
}