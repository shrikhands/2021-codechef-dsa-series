package week5mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YetAnotherProbAboutSequences {
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
        	while(st == null || !st.hasMoreElements()) {
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() { 
        	return (Integer.parseInt(next()));
        }
        long nextLong(){
        	return (Long.parseLong(next()));
        }
    }
	
	static boolean primes[] = new boolean[(int)1e6+7];
    static ArrayList<Integer> P=new ArrayList<>();

    static void sieve(int n) {
        Arrays.fill(primes, true);
        
        primes[0] = false; primes[1] = false;

        for(int i = 2; i*i <= n; i++) {
            if(primes[i]) {
                for(int j = i*i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        for(int i = 0; i <= n; i++) {
            if(primes[i]) 
            	P.add(i);
        }
    }

    public static void main(String[] args) {
    	sieve(620000);

    	FastReader in =new FastReader();
        int T = in.nextInt();
        StringBuilder st=new StringBuilder();
        
        while(T > 0) {
           int n = in.nextInt(), i, j=1;
           
           for(i = 0; i < n-1; i++) {
                if(j == 1) {
                    st.append(P.get(i+3)*6+" ");
                } else if(j == 2) {
                    st.append(P.get(i+3)*10+" ");
                } else if(j == 3) {
                    st.append(P.get(i+3)*15+" ");
                }

                if(j == 3)
                    j = 1;
                else
                    j++;
            }
            st.append(P.get(i+2)*P.get(3)+"\n");
            T--;
        }
        System.out.println(st);
    
    } // main
}