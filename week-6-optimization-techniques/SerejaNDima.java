package week6optimizationTechniques;

import java.util.Scanner;

public class SerejaNDima {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = input.nextInt();
		
		int sCount = 0, dCount = 0;
		boolean sPlay = true;
		for (int i = 0, j = n-1; i <= j; ) {
			int n1 = arr[i], n2 = arr[j];
			
			if (sPlay) {
				if (n1 >= n2) {
					sCount += n1;
					i++;
				} else {
					sCount += n2;
					j--;
				}
				sPlay = false;
			} else {
				if (n1 >= n2) {
					dCount += n1;
					i++;
				} else {
					dCount += n2;
					j--;
				}
				sPlay = true;
			}
		}
		
		System.out.println(sCount + " " + dCount);
	} // main
}