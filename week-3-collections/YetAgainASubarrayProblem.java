package week3collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class YetAgainASubarrayProblem {

	static class FastReader {
		BufferedReader br; StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		} 
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader fs = new FastReader();
		int testCases = fs.nextInt();
		
		while (testCases-- > 0) {
			int N = fs.nextInt(), K = fs.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = fs.nextInt();
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				ArrayList<Integer> list = new ArrayList<Integer>();
				
				for (int j = i; j < N; j++) {
					map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
					int val = Collections.binarySearch(list, arr[j]);
					
					if (val < 0) val = ~val;
					
					list.add(val, arr[j]);
					int m = (int) Math.ceil((double) K / (j - i + 1));
					if (map.containsKey(map.get(list.get((K - 1) / m))))
							result++;
				}
			}
			System.out.println(result);
		}
		
	} // main
}