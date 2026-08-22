package week2linearDS;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	public static int precedence(char c) {
		if (c == '^')
			return 3;
		else if (c == '*' || c =='/')
			return 2;
		else if (c == '+' || c == '-')
			return 1;
		else
			return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int testCases = Integer.parseInt(input.nextLine());
		
			while (testCases-- > 0) {
				int infixLen = Integer.parseInt(input.nextLine());
				String infix = input.nextLine();
				
				Stack<Character> operators = new Stack<>();
				StringBuilder postfix = new StringBuilder();
				
				
				for (int i = 0; i < infixLen; i++) {
					char c = infix.charAt(i);
					
					// handle easiers cases first
					if (c == '(') {
						operators.push(c);
					} else if (c == '^' || c == '/' || c == '*' || c == '+' || c == '-') {
						// we have to push it, but before that precedence checks
						while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
							postfix.append(operators.pop());
						}
						operators.push(c);
					} else if (c == ')') {
						while (!operators.isEmpty() && operators.peek() != '(')
							postfix.append(operators.pop());
						operators.pop(); // remove '('
					} else {	// it is an operand
						postfix.append(c);
					}
				}
				
				// append any remaining operators
				while (!operators.isEmpty())
					postfix.append(operators.pop());
				
				System.out.println("postfix : " + postfix);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	} // main
}