package week6optimizationTechniques;

public class MinNumberOfConsecutiveKBitFlips {
	
	private static void flip(int[]A,int K,int i){
        for(int j=i;j<i+K;j++){
            A[j]=1-A[j];
        }
    }
    
    public static int minKBitFlips(int[] A, int K) {
        if (A == null || A.length == 0)
            return -1;
        
        int cnt=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                if(i+K>A.length)return -1;
                flip(A,K,i);
                cnt++;
            }
        }
        return cnt;
        
    } // func

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[3];
		arr[0] = 0; arr[1] = 1; arr[2] = 0;
		int K = 1;
		System.out.println(minKBitFlips(arr, K));

	} // main
}