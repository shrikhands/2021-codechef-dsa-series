package week2linearDS;

import java.util.Scanner;
import java.util.Stack;

public class ComplierNParser {
	
	public static int isValidTags(String brackets) {
		int openMatch = 0, count = 0;
		
		if(brackets.charAt(0) == '>')
			return 0;
		
		for (int i = 0; i < brackets.length(); i++) {
			char c = brackets.charAt(i);
			
			if(c == '<')
				openMatch++;
			if (c == '>')
				openMatch--;
			if (openMatch == 0)
				count = i+1;
			if (openMatch < 0)
				break;
				
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int testCases = Integer.parseInt(input.nextLine());
		
			while (testCases-- > 0) {
				String brackets = input.nextLine();
				System.out.println(isValidTags(brackets));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}