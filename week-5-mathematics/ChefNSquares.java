package week5mathematics;

import java.util.Scanner;

public class ChefNSquares {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(input.nextLine());
			long ans = -1;
			int sqrN = (int)Math.sqrt(N);
			
			for (int i = 1; i <= sqrN; i++) {
				if (N%i == 0 && i!=(N/i)) {
					long a = (N/i + i)/2, b = (N/i - i)/2;
					if (N+(b*b) == (a*a))
						ans = b*b;
				}
			}
			
			System.out.println(ans);
		}
		
	} // main
}