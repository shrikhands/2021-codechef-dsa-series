package week1complexity;

import java.util.Scanner;

public class MULTTHREE {
	
	public static void main (String[] args) throws java.lang.Exception {
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
		
		while (testCases-- > 0) {
			String values[] = input.nextLine().split(" ");
			long K = Long.parseLong(values[0]), d0 = Long.parseLong(values[1]), d1 = Long.parseLong(values[2]);
			long nextDigit = (d0 + d1) % 10;
			long sum = d0 + d1 + nextDigit;
			
			if (K == 2) {
				if ((d0+d1) % 3 == 0)
					System.out.println("YES");
				else
					System.out.println("NO");
				continue;
			}
			
			K -= 3;
			while (K > 0) {
				if (nextDigit == 0) {
					K = 0;
					break;
				} else if (nextDigit == 6) {
					long blocks = K / 4;
					sum += 20 * blocks;
					K -= blocks * 4;
					
					if (K == 1) {
						sum += 2;
					} else if (K == 2) {
						sum += 6;
					} else if (K == 3) {
						sum += 14;
					}
					K = 0;
					break;
				} else {
					nextDigit = (nextDigit * 2) % 10;
					sum += nextDigit;
					K--;
				}
			}
			
			if (sum % 3 == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	} // main func
} // class