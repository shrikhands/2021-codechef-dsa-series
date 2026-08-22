package week1complexity;

import java.util.Scanner;

public class LifeUniverse {
	public static void main (String[] args) throws java.lang.Exception
	{
	    try {
	        Scanner input = new Scanner(System.in);
	        int num = input.nextInt();
	        
	        while (num != 42) {
	            System.out.println(num);
	            num = input.nextInt();
	        }
	        input.close();
	    } catch(Exception e) {
	        System.out.println(e);
	    }
    }
}