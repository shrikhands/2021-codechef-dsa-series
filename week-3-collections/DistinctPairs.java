package week3collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DistinctPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] input1 = br.readLine().trim().split(" ");
			int N = Integer.parseInt(input1[0]), M = Integer.parseInt(input1[1]);
			String[] nS = br.readLine().trim().split(" ");
			String[] mS = br.readLine().trim().split(" ");
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			int minIndex = -1, maxIndex = -1;
			
			int i = 0;
			while (i < N) {
				int val = Integer.parseInt(nS[i]);
				if (val < min) {
					min = val;
					minIndex = i;
				}
				i++;
			}
			i = 0;
			while (i < M) {
				int val = Integer.parseInt(mS[i]);
				if (val > max) {
					max = val;
					maxIndex = i;
				}
				i++;
			}
			
			i=0;
		    while (i < M) {
		    	System.out.println(minIndex + " " + i);
		    	i++;
		    }
		    i=0;
		    while (i < N) {
		    	if(i != minIndex)
		    		System.out.println(i + " " + maxIndex);
		    	i++;
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}