package week2linearDS;

import java.util.Scanner;
import java.util.Stack;

public class ChefsInQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner input = new Scanner(System.in);
				String[] input1 = input.nextLine().split(" ");
				int N = Integer.parseInt(input1[0]), K = Integer.parseInt(input1[1]);
				String[] chefs = input.nextLine().split(" ");
				
				Stack<Integer> indices = new Stack<Integer>();
				indices.push(0);
				long total = 1;
				for (int i = 1; i < N; i++) {
					while (!indices.isEmpty() && Integer.parseInt(chefs[i]) < Integer.parseInt(chefs[indices.peek()])) {
						// calculate fearfulness
						total *= (Math.abs(i - indices.pop()) + 1);
						total %= 1e9 + 7;
						
					}
					indices.push(i);
				}
				System.out.println(total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}