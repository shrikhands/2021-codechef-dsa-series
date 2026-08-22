package week2linearDS;


import java.util.Scanner;
import java.util.TreeSet;

public class Wormholes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner input = new Scanner(System.in);
			String[] input1 = input.nextLine().split(" ");
			int N = Integer.parseInt(input1[0]), X = Integer.parseInt(input1[1]), Y = Integer.parseInt(input1[2]);

			int[][] contests = new int[N][2];
			for (int i = 0; i < N; i++) {
				String[] times = input.nextLine().split(" ");
				contests[i][0] = Integer.parseInt(times[0]);
				contests[i][1] = Integer.parseInt(times[1]);
			}
			
			TreeSet<Integer> V = new TreeSet<Integer>();
			String[] vTimes = input.nextLine().split(" ");
			for (int i = 0; i < X; i++)
				V.add(Integer.parseInt(vTimes[i]));
			
			TreeSet<Integer> W = new TreeSet<Integer>();
			String[] wTimes = input.nextLine().split(" ");
			for (int i = 0; i < Y; i++)
				W.add(Integer.parseInt(wTimes[i]));
			
			int minTime = Integer.MAX_VALUE, ans = 0;
			for (int i = 0; i < N; i++) {
				Integer enterTime = V.floor(contests[i][0]),
					exitTime = W.ceiling(contests[i][1]);
				
				if (exitTime != null && enterTime != null) {
					ans = exitTime - enterTime + 1;
					minTime = Math.min(minTime, ans);
				}
			}
			
			System.out.println(minTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	} // main
}