package week2linearDS;

import java.util.Scanner;

public class PenaltyShootII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
		
		while (testCases-- > 0) {
			long N = Long.parseLong(input.nextLine());
			String S = input.nextLine();
			int aScore = 0, bScore = 0, i = 0, aKick = 0, bKick = 0;
			
			for (i = 0; i < N*2; i++) {
				if ((aScore - bScore > N - bKick) || (bScore - aScore > N - aKick)) {
					break;
				} else if (i%2 == 0) {	//A's turn
					aKick++;
					if (S.charAt(i) == '1') aScore++;
				} else {	// B's turn
					bKick++;
					if (S.charAt(i) == '1') bScore++;
				}
			}
			
			System.out.println(i);
		}

	} // main
}