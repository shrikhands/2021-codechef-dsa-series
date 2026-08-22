package week2linearDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Point implements Comparable<Point> {
	int x;
	int y;
	
	public Point() {
		// TODO Auto-generated constructor stub
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getY(int x) {
		return this.y;
	}
	
	public int getX(int y) {
		return this.x;
	}
	
	@Override
	public int compareTo(Point point) {
		if (point.x == this.x)
			return point.y - this.y;
		return this.x - point.x;
	}
}

public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int N = Integer.parseInt(input.nextLine());
			
			// add (0,500), (1,500), ...., (10^5, 500), (10^5, 0) tp Points list
			List<Point> points = new ArrayList<Point>();
			for (int i = 1; i <= 10e4; i++)
				points.add(new Point(i, 500));
			points.add(new Point(0, 0));
			points.add(new Point((int)10e4, 0));
			
			while (N-- > 0) {
				String[] coordinates = input.nextLine().split(" ");
				points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
			}
			
			// sort points by x
			Collections.sort(points);
			
			// calculate all right_y & left_y
			int pointsCount = points.size();
			int[] right_x = new int[pointsCount];
			int[] left_x = new int[pointsCount];
			Stack<Integer> stack = new Stack<Integer>();
			
			for (int i = 0; i < pointsCount; i++){
                int x = points.get(i).x;
                int y = points.get(i).y;
                
                while (!stack.isEmpty()){
                    if (points.get(stack.peek()).y > y){
                        right_x[stack.peek()] = x;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(i);
            }

			for (int i = pointsCount - 1; i >=0; i--){
                int x = points.get(i).x;
                int y = points.get(i).y;
                
                while (!stack.isEmpty()){
                    if (points.get(stack.peek()).y > y){
                        left_x[stack.peek()] = x;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(i);
            }
			
			int maxArea = Integer.MIN_VALUE;
			// calculate max area
			for (int i = 0; i < pointsCount; i++) {
				if (right_x[i] == points.get(i).x || left_x[i] == points.get(i).x)
					continue;
				
				maxArea = Math.max(maxArea, (right_x[i] - left_x[i])*points.get(i).y);
			}
				
			System.out.println(maxArea);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}