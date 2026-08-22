package week4divideNconquer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class DTP {
	long dis, type, people;
	
	public DTP(long d, long t, long p) {
		this.dis = d;
		this.type = t;
		this.people = p;
	}
}

public class SavingGiftOfLove {
	static ArrayList<DTP> locs = new ArrayList<DTP>();
	static long INF = (long) (2 * Math.pow(10, 18));
	
	private static long query(long x) {
		int locsLen = locs.size(), i;
		
		for (i = 0; i < locsLen; i++) {
			DTP dtp = locs.get(i);
			
			if (dtp.type == (-100))
				return x;
			else if (dtp.type == (-50))
				x -= dtp.people;
			else if (x >= dtp.type)
				x += dtp.people;
		}
		return x;
	}
	
	private static long binSearch(long min, long l, long h) {
		long ans = 0, m = 0;
		
		while (l <= h) {
			m = l + (h - l) / 2;
			long res = query(m);
			
			if (res >= min) {
				ans = m;
				h = m - 1;
			} else
				l = m + 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);
			int t = input.nextInt();
			
			while (t-- > 0) {
				locs.clear();
				long dist = input.nextLong();
				long noOfDishes = input.nextLong();
				for (int i = 0; i < noOfDishes; i++)
					locs.add(new DTP(input.nextLong(), -50, input.nextLong()));	// -50 for dishes
				long noOfClans = input.nextLong();
				for (int i = 0; i < noOfClans; i++)
					locs.add(new DTP(input.nextLong(), input.nextLong(), input.nextLong()));
				locs.add(new DTP(dist, -100, -100));	// -100 denotes end of list
				
				locs.sort(new Comparator<DTP>() {
					public int compare(DTP dtp1, DTP dtp2) {
						return Long.valueOf(dtp1.dis).compareTo(dtp2.dis);
					}
				});
			
				System.out.println(binSearch(1, 1, INF));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}