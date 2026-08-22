package week4divideNconquer;

import java.util.Scanner;

public class CountSubstrings {
	private static long[] prefixSums;
	private static int[] arr;
	
	private static void prefixSum(String S, int N, int K) {
		prefixSums = new long[N+1];
		arr = new int[N+1];
		
		int[] count = new int[2];
		int l = 1;
		for (int r = 1; r <= N; r++) {
			count[S.charAt(r - 1) - '0']++;
			
			while (l <= r && (count[0] > K || count[1] > K)) {
				arr[l] = r - 1;
				prefixSums[l] = prefixSums[l-1] + r-l;
				count[S.charAt(l - 1) - '0']--;
				l++;
			}
		}
		
		while (l <= N) {
			arr[l] = N;
			prefixSums[l] = prefixSums[l - 1] + N - l + 1;
			l++;
		}
	}
	
	private static int smallestIndex(int l, int r) {
		int ans = -1;
		int li = l, ri = r;
		
		while (li <= ri) {
			int m = li + ((ri - li) >> 1);
			if (arr[m] > r)
				ri = m - 1;
			else {
				ans = m;
				li = m + 1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			int t = input.nextInt();
			
			while (t-- > 0) {
				int N = input.nextInt(), K = input.nextInt(), Q = input.nextInt();
				String S = input.next();
				
				prefixSum(S, N, K);
				
				while (Q-- > 0) {
					int l = input.nextInt(), r = input.nextInt();
					long ans = 0;
					
					int index = smallestIndex(l, r);
					if (index == -1)
						index = l - 1;
					else
						ans = prefixSums[index] - prefixSums[l - 1];
					
					int diff = r - index;
					ans += ((long)diff * (diff + 1)) >> 1;
					
					System.out.println(ans);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}