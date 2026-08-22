package week6optimizationTechniques;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[8];
		arr[0] = -2; arr[1] = -3; arr[2] = 4; arr[3] = -1;
		arr[4] = -2; arr[5] = 1; arr[6] = 5; arr[7] = -3;
		
		int currMax = arr[0], maxSoFar = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			currMax = Math.max(arr[i]+currMax, arr[i]);
			maxSoFar = Math.max(maxSoFar, currMax);
		}
		
		System.out.println(maxSoFar);
		
	} // main
}