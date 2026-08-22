package week5mathematics;

import java.util.Scanner;

public class AppyNChef {

	public static long gcd(long a, long b) {
		if (a == 0)
			return b;
		
		return gcd(b%a, a);
	}
	
	public static long lcm(long a, long b) {
		return (a*b) / gcd(a, b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		while (T-- > 0) {
			long N = input.nextLong(), A = input.nextLong(), B = input.nextLong(), K = input.nextLong();
			
			long a = N/A, b = N/B, c = 2*(N/lcm(A,B));
			System.out.println(a+b-c >= K ? "Win" : "Loose");
		}
		
	} // main
}