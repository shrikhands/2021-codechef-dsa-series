package week3collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class YetAnotherPartitionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] nq = br.readLine().trim().split(" ");
			int N = Integer.parseInt(nq[0]), Q = Integer.parseInt(nq[1]);
			int[] values = new int[N+1];
			
			TreeSet<Integer> subarrays = new TreeSet<Integer>();
			for (int i = 1; i <= N; i++) {
				values[i] = Integer.parseInt(br.readLine());
				
				if (i == 1 || values[i] % values[i - 1] != 0)
					subarrays.add(i);
			}	
			
			while (Q-- > 0) {
				String[] query = br.readLine().split(" ");
				
				if (query[0].equals("1")) {
					int i = Integer.parseInt(query[1]);
					values[i] = Integer.parseInt(query[2]);
					
					if (i > 1) {	// scenario1: can check with p[rev elem
						if (values[i] % values[i-1] == 0) // belongs to same subarray
							subarrays.remove(i);
						else
							subarrays.add(i);	// belongs to different subarray
					}
					if (i < N) { // it is first element
						if (values[i+1] % values[i] == 0)
							subarrays.remove(i+1);
						else 
							subarrays.add(i+1);
					}
						
					
				} else {
					// get ith subarray
					System.out.println(subarrays.floor(Integer.parseInt(query[1])));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	} // main
}