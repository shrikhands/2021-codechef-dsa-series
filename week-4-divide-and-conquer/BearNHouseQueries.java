package week4divideNconquer;

import java.util.Scanner;

public class BearNHouseQueries {
	static Scanner input = new Scanner(System.in);
	
	private static boolean checkBound(int x, int y) {
		System.out.println("? " + x + " " + y);
		System.out.flush();
		
		String resp = input.nextLine();
		if (resp.equals("YES"))
			return true;
		else
			return false;
	}
	
	private static int binarySearchX(int start, int end, int y) {
		int ans = 0;
		
		while (start <= end) {
			int mid = (end + start) / 2;
			if (checkBound(mid, y)) {
				start = mid + 1;
				ans = mid;
			} else
				end = mid - 1;
		}
		
		return ans;
	}
	
	private static int binarySearchY(int start, int end) {
		int ans = 0;
		
		while (start <= end) {
			int mid = (end + start) / 2;
			if (checkBound(0, mid)) {
				start = mid + 1;
				ans = mid;
			} else
				end = mid - 1;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int area = 0, sqr_s = 0, tri_b = 0, tri_h = 0;
		
		int s = binarySearchX(0, 1000, 0);
		sqr_s = 2*s;
		
		tri_b = binarySearchX(s+1, 1000, sqr_s);
		
		tri_h = binarySearchY(sqr_s+1, 1000);
			
		area = sqr_s * sqr_s + (tri_b * (tri_h - sqr_s));
		System.out.println("! " + area);
		System.out.flush();
		
	} // main
}