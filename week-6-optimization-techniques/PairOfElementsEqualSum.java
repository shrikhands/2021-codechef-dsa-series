package week6optimizationTechniques;

import java.util.ArrayList;

public class PairOfElementsEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[8];
		arr[0] = 2; arr[1] = 3; arr[2] = 4; arr[3] = 15;
		arr[4] = 20; arr[5] = 146; arr[6] = 513; arr[7] = 3145;
		int target = 3149;
		
		int aLen = arr.length;
		for (int i = 0, j = aLen - 1; i < j; ) {
			int n1 = arr[i], n2 = arr[j];
			int sum = n1+n2;
			
			if (sum == target) {
				System.out.println(n1 + " " + n2);
				return;
			}
			
			if(sum < target)
				i++;
			else if (sum > target)
				j--;
		}
		
	} // main
}