package week1complexity;

import java.util.*;

class SmartPhone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner input = new Scanner(System.in);
		long T = 0;
		
			T = input.nextInt();
			long[] budgets = new long[(int)T];
			int i = 0;
			long buyersCount = T, profit = 0;		
			
			while (T-- > 0) {
				budgets[i] = input.nextInt();
				i++;			
			} // inner while for T inputs
			
			Arrays.sort(budgets);
			for (int j = 0; j < budgets.length; j++) {
				profit = Math.max(profit, budgets[j] * (buyersCount - j));
			}
			System.out.println(profit);
				
	}
}