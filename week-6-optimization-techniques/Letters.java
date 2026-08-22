package week6optimizationTechniques;

import java.util.Scanner;

public class Letters {
	
	public static long binarySearch(int start, int end, long find, long[] prefixSum) {
		long ans = end;
		int mid = 0;
		
		while (start <= end) {
			mid = (start+end)/2;
			
			if (prefixSum[mid] >= find) {
				ans = Math.min((int)ans, mid);
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt(), m = input.nextInt();
		long[] dorms = new long[n], find = new long[m];
		
		for (int i = 0; i < n; i++)
			dorms[i] = input.nextLong();
		for (int i = 0; i < m; i++)
			find[i] = input.nextLong();
		
		long[] prefixSum = new long[(int)n];
		prefixSum[0] = dorms[0];
		for (int i = 1; i < n; i++)
			prefixSum[i] = prefixSum[i-1]+dorms[i];
		
		for (int i = 0; i < m; i++) {
			long dorm = 0, room = 0;
			
			dorm = binarySearch(0, n-1, find[i], prefixSum);
			
			if (dorm == 0)
				room = find[i];
			else
				room = find[i] - prefixSum[(int)dorm-1];
			
			System.out.println(dorm+1 + " " + room);
			
		}
	} // main
}