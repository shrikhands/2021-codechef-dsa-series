package week3collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ChefOfTheYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] input1 = br.readLine().trim().split(" ");
			int chefsCount = Integer.parseInt(input1[0]), emailsCount = Integer.parseInt(input1[1]);
			
			// store all chef values
			Map<String, String> chefs = new HashMap<String, String>();
			for (int i = 0; i < chefsCount; i++) {
				String[] info = br.readLine().trim().split(" ");
				chefs.put(info[0], info[1]);
			}
			
			// fetch emails and calculate counts
			TreeMap<String, Integer> chefsVotes = new TreeMap<String, Integer>();
			TreeMap<String, Integer> countryVotes = new TreeMap<String, Integer>();
			while (emailsCount-- > 0) {
				String votedChef = br.readLine();
				
				if (!chefsVotes.containsKey(votedChef)) {
					chefsVotes.put(votedChef, 1);
				} else {
					chefsVotes.put(votedChef, chefsVotes.get(votedChef)+1);
					
				}
				
				String country = chefs.get(votedChef);
				if (!countryVotes.containsKey(country)) {
					countryVotes.put(country, 1);
				} else {
					countryVotes.put(country, countryVotes.get(country)+1);
				}
			}
			
			int maxChef = Integer.MIN_VALUE; String starChef = ""; 
			for (Entry<String, Integer> set : chefsVotes.entrySet()) {
				int x = set.getValue();	
				if (x > maxChef) {
					maxChef = x; 
					starChef = set.getKey();
				}
			}
			
			int maxCountry = Integer.MIN_VALUE; String starCountry = ""; 
			for (Entry<String, Integer> set : countryVotes.entrySet()) {
				int x = set.getValue();	
				if (x > maxCountry) {
					maxCountry = x; 
					starCountry = set.getKey();
				}
			}
			
			System.out.println(starCountry+"\n"+starChef);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
}