package week4divideNconquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stacks {
	
	public static int binarySearch(List<Integer> stacks, int cur) {
		int index = -1, lo = 0, hi = stacks.size() - 1;
		
		while (lo <= hi) {
			int mid = (lo+hi)/2;
			if (stacks.get(mid) > cur) {
				index = mid;
				hi = mid - 1;
			} else
				lo = mid + 1;
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
				
		while (testCases-- > 0) {
			int N = Integer.parseInt(input.nextLine());
			String[] nums = input.nextLine().split(" ");
			List<Integer> stacks = new ArrayList<Integer>();
			
			// add first element
			stacks.add(Integer.parseInt(nums[0]));
			
			for (int i = 1; i < N; i++) {
				int cur = Integer.parseInt(nums[i]);
				// get min of all stacks top
				int j = binarySearch(stacks, cur);
				
				if (j >= 0) { // element found, set
					stacks.set(j, cur);
					
				} else 	//bigger than cur in present stacks not found, hence create new stack
					stacks.add(cur);		 
			}
			
			// result format
			System.out.print(stacks.size() + " ");
			for (Integer s : stacks)
				System.out.print(s + " ");
			System.out.println();
		}
		
	} // main
}