package week1complexity;

import java.util.*;

class Lapindromes
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner input = new Scanner(System.in);
		int T = 0;
		String S = "", firstHalf = "", secondHalf = "";
		int[] firstSide = new int[26];
		int[] secondSide = new int[26];
		boolean isLapi = true;
		
		while (input.hasNextInt()) {
			T = input.nextInt();
			
			while (T-- > 0) {
				S = input.next();
				
				// split the string in two parts as per the requirement
				if (S.length() % 2 == 0) {	// length is even
					firstHalf = S.substring(0, S.length()/2);
					secondHalf = S.substring(S.length()/2);
				} else {	// length is odd
					firstHalf = S.substring(0, S.length()/2);
					secondHalf = S.substring((S.length()/2) + 1);
				}
				
				// frequency count of each alphabet on both sides
				for (char c : firstHalf.toCharArray()) {
					firstSide[c - 'a']++;
				}
				
				for (char c : secondHalf.toCharArray()) {
					secondSide[c - 'a']++;
				}
				
				// check the number of each side
				for (int i = 0; i < 26; i++) {
					if (firstSide[i] != secondSide[i]) {
						isLapi = false;
					}
					firstSide[i] = 0;
					secondSide[i] = 0;
				}
				
				if (isLapi)
					System.out.println("YES");
				else
					System.out.println("NO");
				
				isLapi = true;
			}
		}
	}
}