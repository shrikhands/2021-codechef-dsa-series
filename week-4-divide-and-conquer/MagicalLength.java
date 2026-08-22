package week4divideNconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MagicalLength {
	private static class Coordinates {
		Double x;
		Double y;
		
		public Coordinates(Double x, Double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static double dist(Coordinates c1, Coordinates c2) {
		double x = c1.x - c2.x;
		double y = c1.y - c2.y;
		return Math.sqrt((x*x) + (y*y));
	}
	
	private static double distances(Coordinates c1, Coordinates c2, Coordinates c3) {
		return (dist(c1, c2) + dist(c2, c3) + dist(c1, c3));
	}
	
	private static double getMinDist(List<Coordinates> pts, Double minDist) {
		double dist = Double.MAX_VALUE;
		int n = pts.size();
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n && (Math.abs(pts.get(j).y - pts.get(i).y) < minDist); j++) {
				for (int k = j+1; k < n && (Math.abs(pts.get(k).y - pts.get(j).y) < minDist); k++) {
					Double d = distances(pts.get(i), pts.get(j), pts.get(k));
					if (Double.compare(d, dist) < 0)
						dist = d;
				}
			}
		}
			 	
		return dist;
	}
	
	private static double bruteForce(Coordinates[] points) {
		double dist = Double.MAX_VALUE;
		int n = points.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					Double d = distances(points[i], points[j], points[k]);
					if (Double.compare(d, dist) < 0)
						dist = d;
				}
			}
		}
		
		return dist;
	}
	
	private static double divideAndConquer(Coordinates[] points) {
		int n = points.length;
		
		if (n <= 3)
			return bruteForce(points);
		
		int m = n / 2;
		Coordinates midPt = points[m];
		Coordinates[] left = new Coordinates[m];
		Coordinates[] right = new Coordinates[n - m];
		
		for (int i = 0; i < left.length; i++)
			left[i] = points[i];
		for (int i = 0; i < right.length; i++)
			right[i] = points[m + i];
		
		double leftDist = divideAndConquer(left);
		double rightDist = divideAndConquer(right);
		
		List<Coordinates> newPts = new ArrayList<Coordinates>();
		double minDist = Math.min(leftDist, rightDist);
		for (Coordinates pts : points) 
			if (Math.abs(pts.x - midPt.x) < minDist)
				newPts.add(pts);
		
		Collections.sort(newPts, (n1, n2) -> Double.compare(n1.y, n2.y));
		
		return Math.min(getMinDist(newPts, minDist), minDist);
	}
	
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			int t = input.nextInt();
			
			for (int T = 1; T <= t; T++) {
				int n = input.nextInt();
				
				Coordinates[] coordinates = new Coordinates[n];
				for (int i = 0; i < n; i++)
					coordinates[i] = new Coordinates(input.nextDouble(), input.nextDouble());
				
				Arrays.sort(coordinates, (c1, c2) -> Double.compare(c1.x, c2.x));
				
				System.out.println("Case " + T + ": " + divideAndConquer(coordinates));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}