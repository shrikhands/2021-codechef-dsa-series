package week1complexity;

import java.util.*;

public class Carvans {
	public static int maxSpeedCount(int[] maxSpeeds) {
		int maxSpeedCarCount = 1, max = maxSpeeds[0];
		
		for (int i = 1; i < maxSpeeds.length; i++)
			if (maxSpeeds[i] <= max) {
			    maxSpeedCarCount++;
			    max = maxSpeeds[i];
			}
			
		return maxSpeedCarCount;
	}
	
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		
		while (testCases-- > 0) {
			int numberOfCars = input.nextInt();
			int[] maxSpeeds = new int[numberOfCars];
			
			// enter max speeds
			for (int i = 0; i < maxSpeeds.length; i++)
				maxSpeeds[i] = input.nextInt();
			
			// return cars running in max speed
			System.out.println(maxSpeedCount(maxSpeeds));
		}
	}
}