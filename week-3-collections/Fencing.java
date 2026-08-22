package week3collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Fencing {
	
	public static int addFence(Map<Integer, HashSet<Integer>> backyard, int i, int j) {
		int fence = 4;
		
		// P present, fence not required
		if (backyard.containsKey(i) && backyard.get(i).contains(j-1))	
			fence--;
		if (backyard.containsKey(i-1) && backyard.get(i-1).contains(j))
			fence--;
		if (backyard.containsKey(i) && backyard.get(i).contains(j+1))
			fence--;
		if (backyard.containsKey(i+1) && backyard.get(i+1).contains(j))
			fence--;
		
		return fence;
	}
			
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int tests = Integer.parseInt(br.readLine());
			while (tests-- > 0) {
				String[] nm = br.readLine().trim().split(" ");
				int N = Integer.parseInt(nm[0]), M = Integer.parseInt(nm[1]), K = Integer.parseInt(nm[2]), fence = 0;
				
				Map<Integer, HashSet<Integer>> backyard = new HashMap<>();
				while (K-- > 0) {
					String[] loc = br.readLine().trim().split(" ");
					int x = Integer.parseInt(loc[0]), y = Integer.parseInt(loc[1]);
					
					if (backyard.containsKey(x))
						backyard.get(x).add(y);
					else {
						backyard.put(x, new HashSet<Integer>());
						backyard.get(x).add(y);
					}
				}
				
				for (int key : backyard.keySet()) {
					for (int value : backyard.get(key)) {
						fence += addFence(backyard, key, value);
					}
				}
				
				System.out.println(fence);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}