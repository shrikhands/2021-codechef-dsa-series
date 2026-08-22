package week6optimizationTechniques;

import java.util.Scanner;

public class KConcatenation {
	
	private static long maxSubArraySum(long[] arr) {
		long curMax = arr[0], maxSoFar = arr[0];
		for (int i = 1; i < arr.length; i++) {
			curMax = Math.max(arr[i], arr[i]+curMax);
			maxSoFar = Math.max(maxSoFar, curMax);
		}
		
		return maxSoFar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			int N = input.nextInt(), K = input.nextInt();
			long[] arr = new long[N];
			long[] newArr = new long[N+N];
			long sum = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = input.nextLong();
				newArr[i] = arr[i];
				newArr[i+N] = arr[i];
				sum += arr[i];
			}
			
			if (sum < 0) {
				System.out.println(maxSubArraySum(newArr));
				continue;
			} else if (K == 1) {
				System.out.println(maxSubArraySum(arr));
				continue;
			}
			
			System.out.println(maxSubArraySum(newArr) + (K-2)*sum);
		}
		
	} // main
}