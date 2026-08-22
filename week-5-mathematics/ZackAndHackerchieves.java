package week5mathematics;

import java.util.Scanner;

public class ZackAndHackerchieves {

	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		
		return gcd(b%a, a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		while (T-- > 0) {
			int L = input.nextInt(), B = input.nextInt();

			//get gcd
			System.out.println(gcd(L, B));
		}
	}
}