package week2linearDS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NotAllFlavours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Scanner input = new Scanner(System.in);
			int testCases = Integer.parseInt(input.nextLine());
		
			while (testCases-- > 0) {
				String[] input1 = input.nextLine().split(" ");
				int N = Integer.parseInt(input1[0]), K = Integer.parseInt(input1[1]);
				String[] flavours = input.nextLine().split(" ");
				
				HashMap<Integer, Integer> flavCounts = new HashMap<Integer, Integer>();
				int maxSegment = Integer.MIN_VALUE;
				for (int l = 0, r = 0; r < N; r++) {
					int flav = Integer.parseInt(flavours[r]);
					
					if (flavCounts.containsKey(flav))
						flavCounts.replace(flav, flavCounts.get(flav)+1);
					else
						flavCounts.put(flav, 1);
					
					while (flavCounts.size() == K) {
						int flavL = Integer.parseInt(flavours[l]);
						flavCounts.replace(flavL, flavCounts.get(flavL) - 1);
						if (flavCounts.get(flavL) == 0)
							flavCounts.remove(flavL);
						l++;
					}
					
					maxSegment = Math.max(maxSegment, r-l+1);
				}
				
				System.out.println(maxSegment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}