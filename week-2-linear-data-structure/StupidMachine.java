package week2linearDS;

import java.util.Scanner;

public class StupidMachine {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int testCases = Integer.parseInt(input.nextLine());

			while (testCases-- > 0) {
				long N = Long.parseLong(input.nextLine());
				String[] capacity = input.nextLine().split(" ");
				long min = Long.MAX_VALUE, L = 0;
						
				for (int i = 0; i < N; i++) {
					min = Math.min(min, Long.parseLong(capacity[i]));
					L += min;
				}
				
				System.out.println(L);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}