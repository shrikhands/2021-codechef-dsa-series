package week1complexity;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
		
		while (testCases-- > 0) {
			long N = Long.parseLong(input.nextLine());
			long zeroes = 0, fiveFactor = 5;
			
			while (fiveFactor <= N) {
				zeroes += N/fiveFactor;
				fiveFactor *= 5;
			}
			
			System.out.println("zeroes : " + zeroes);
		}
	}
}