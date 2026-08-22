package week5mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SemiPrimes {
	static boolean[] primes = new boolean[1000];
	
	public static void sieve(int n) {
		primes[0] = primes[1] = false;

		for (int i = 2; i*i < n; i++) {
			if (primes[i])
				for (int j = i*i; j < n; j += i)
					primes[j] = false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T = Integer.parseInt(input.nextLine());
		
		Arrays.fill(primes, true);
		sieve(1000);

		while (T-- > 0) {
			int N = Integer.parseInt(input.nextLine());

			ArrayList<Integer> allPrimes = new ArrayList<Integer>();
			for (int i = 2; i < N; i++)
				if (primes[i])
					allPrimes.add(i);
			
			ArrayList<Integer> semiprimes = new ArrayList<Integer>();
			for (int i = 0; i < allPrimes.size(); i++) 
				for (int j = i + 1; j < allPrimes.size(); j++) 
					semiprimes.add(allPrimes.get(i) * allPrimes.get(j));
				
			Collections.sort(semiprimes);
			boolean res = false;
			for (int i = 0; i < semiprimes.size(); i++) {
				if (semiprimes.contains(N - semiprimes.get(i))) {
					res = true;
					break;
				}
			}
			
			if (res)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	} // main
}