package week4divideNconquer;

import java.util.Scanner;

public class Euron {
	
	private static long mergeCount(int[] nums, int l, int m, int r) {
		long count = 0;
		int leftLen = m - l + 1, rightLen = r - m;
		int[] left = new int[leftLen], right = new int[rightLen];
		
		for (int i = 0; i < leftLen; i++)
			left[i] = nums[i+l];
		for (int i = 0; i < rightLen; i++)
			right[i] = nums[m + 1 + i];
		
		int i = 0, j = 0, k = l;
		while (i < leftLen && j < rightLen) {
			if (left[i] <= right[j]) {
				nums[k] = left[i];
				i++;
			} else {
				nums[k] = right[j];
				j++;
				count += leftLen - i;
			}
			k++;
		}
		
		while (i < leftLen) {
			nums[k] = left[i];
			i++; k++;
		}
		
		while (j < rightLen) {
			nums[k] = right[j];
			j++; k++;
		}
		
		return count;
	}
	
	private static long mergeSort(int[] nums, int l, int r) {
		if (l >= r)
			return 0;
		
		long count = 0;
		int m = (l+r) / 2;
		
		count += mergeSort(nums, l, m);
		count += mergeSort(nums, m + 1, r);
					
		count += mergeCount(nums, l, m, r);
		
		return count;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.nextLine());
		String[] nums = input.nextLine().split(" ");
		int a[] = new int[N];
		
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(nums[i]);
		
		System.out.println(mergeSort(a, 0, N - 1));
				
	} //main
}