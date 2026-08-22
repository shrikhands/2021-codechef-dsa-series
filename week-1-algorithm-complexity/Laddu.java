package week1complexity;

import java.util.*;

class Laddu
{
    private static int getLaddus(String activity) {
		int pointsMade = 0;
		String[] acts = activity.split(" ");
		int rank = acts.length == 2 ? Integer.parseInt(acts[1]) : 0;
		
		switch (acts[0]) {
			case "CONTEST_WON":
				pointsMade = 300;
				if (Integer.parseInt(acts[1]) <= 20)
					pointsMade += 20 - Integer.parseInt(acts[1]);
				break;
				
			case "TOP_CONTRIBUTOR":
				pointsMade = 300;
				break;
			
			case "BUG_FOUND":
				pointsMade = Integer.parseInt(acts[1]);
				break;
			
			case "CONTEST_HOSTED":
				pointsMade = 50;
				break;
		}
		
		return pointsMade;
	}
	
	private static int getMonths(int laddus, int points) {
		return laddus/points;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.nextLine());
		
		while (testCases-- > 0) {
			String values[] = input.nextLine().split(" ");
			int noOfActivities = Integer.parseInt(values[0]);
			String origin = values[1];
			
			int laddus = 0;
			while (noOfActivities-- > 0) {
				String activity = input.nextLine(); 
				laddus += getLaddus(activity);
			}
			
			System.out.println(origin.equalsIgnoreCase("INDIAN") ? getMonths(laddus, 200) : getMonths(laddus, 400));
		}
	}
}