package week1complexity;

import java.util.Scanner;

public class ReverseTheNumber {
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		int T = 0, N = 0, revNum = 0;
		
		while (input.hasNextInt()) {
			T = input.nextInt();
			
			while (T-- > 0) {
				N = input.nextInt();
				revNum = 0;
				
				while (N > 0) {
					revNum = (int)(revNum * 10) + (N % 10);
					N /= 10;
				}
				System.out.println(revNum);
			}
		}
	}
}