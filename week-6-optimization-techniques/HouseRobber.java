package week6optimizationTechniques;

import java.util.HashMap;

public class HouseRobber {
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public static int recurse(int index, int[] nums) {
        if (index >= nums.length)
            return 0;
        
        if (map.get(index) == null)
            map.put(index, Math.max(nums[index] + recurse(index+2, nums), recurse(index+1, nums)));
        
       return map.get(index);
    }
    
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int nLen = nums.length;
        int[] res = new int[nLen];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nLen; i++)
            res[i] = Math.max(res[i-1], res[i-2]+nums[i]);
        
        return res[nLen-1];
        
        //return recurse(0, nums);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//[1,2,3,1]
		int[] arr = new int[4];
		arr[0] = 1; arr[1] = 2; arr[2] = 3; arr[3] = 1;
		System.out.println(rob(arr));
		
	} // main
}