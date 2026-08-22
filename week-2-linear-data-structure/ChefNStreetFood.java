package week2linearDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChefNStreetFood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
		
		while (testCases-- > 0) {
			int N = Integer.parseInt(input.nextLine());
			List<Integer> profits = new ArrayList<Integer>();
			
			while(N-- > 0) {
				String[] values = input.nextLine().split(" ");
				int stores = Integer.parseInt(values[0]), people = Integer.parseInt(values[1]), price = Integer.parseInt(values[2]);
				
				profits.add(people/++stores * price);
			}
			System.out.println(Collections.max(profits));
		}

	}	// main

}
