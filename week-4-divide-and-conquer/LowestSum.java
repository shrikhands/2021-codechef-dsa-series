package week4divideNconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LowestSum {
	
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			int t = Integer.parseInt(input.nextLine());
				
			while (t-- > 0) {
				String[] nums = input.nextLine().split(" ");
				int k = Integer.parseInt(nums[0]), q = Integer.parseInt(nums[1]);
				long[] mo = new long[k], sa = new long[k];
			
				String[] m = input.nextLine().split(" ");
				for (int i = 0; i < k; i++)
					mo[i] = Long.parseLong(m[i]);
			
				String[] s = input.nextLine().split(" ");
				for (int i = 0; i < k; i++)
					sa[i] = Long.parseLong(s[i]);
		
				Arrays.sort(mo);
				Arrays.sort(sa);
			
				long max = mo[Math.min(k-1, 100)] + sa[Math.min(k-1, 100)];
				ArrayList<Long> l = new ArrayList<Long>();
				for (int i = 0; i < k; i++) {
					for (int j = 0; j < k; j++) {
						long sum = mo[i] + sa[j];
						if (sum > max)
							break;
						l.add(sum);
					}
				}
			
				Collections.sort(l);
				while (q-- > 0) {
					int qi = Integer.parseInt(input.nextLine());
					System.out.println(l.get(qi - 1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}