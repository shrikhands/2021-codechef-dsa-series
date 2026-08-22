package week5mathematics;

import java.util.Scanner;

public class ChefNAdventures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		while (T-- > 0) {
			String[] nums = input.nextLine().split(" ");
			int N = Integer.parseInt(nums[0]), M = Integer.parseInt(nums[1]),
				X = Integer.parseInt(nums[2]), Y = Integer.parseInt(nums[3]);
			
			if (N == 1 && M == 1) {
				System.out.println("Chefirnemo");
			} else if (N == 1 && M != 1) {
				if ((M-1)%Y == 0)
					System.out.println("Chefirnemo");
				else
					System.out.println("Pofik");
			} else if (M == 1 && N != 1) {
				if ((N-1)%X == 0)
					System.out.println("Chefirnemo");
				else
					System.out.println("Pofik");
			} else if ((N-1)%X == 0 && (M-1)%Y == 0) {
				System.out.println("Chefirnemo");
			} else if ((N-2)%X == 0 && (M-2)%Y == 0) { // use sharechat and then try using X,Y
				System.out.println("Chefirnemo");
			} else {
				System.out.println("Pofik");
			}
		}
		
	} // main
}