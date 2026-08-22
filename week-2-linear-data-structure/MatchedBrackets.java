package week2linearDS;

import java.util.Scanner;
import java.util.Stack;

public class MatchedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			
			int N = Integer.parseInt(input.nextLine());
			String[] brackets = input.nextLine().split(" ");
			int open = 0, maxNestingDepth = Integer.MIN_VALUE, maxDepthIndex = 0, seq = 0, maxSeqLen = 0, maxSeqIndex = 0;
			Stack<String> stack = new Stack<String>();
				
			for (int i = 0; i < brackets.length; i++) {
				if (brackets[i].equals("1")) {
					open++;
					stack.push("1");
				} else {
					stack.pop();
					seq++;
					
					if (stack.isEmpty()) {	// all matches for a valid substring done
						seq *= 2;
						if (seq > maxSeqLen) {
							maxSeqLen = seq;
							maxSeqIndex = i - maxSeqLen + 2;
						}
						// reset seq to 0 for another sequence
						seq = 0;
					}
					
					if (open > maxNestingDepth) {
						maxNestingDepth = open;
						maxDepthIndex = i;
					}
					open--;
				}
			}
				
			System.out.println(maxNestingDepth + " " + maxDepthIndex + " " + maxSeqLen + " " + maxSeqIndex);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	} // main
}
