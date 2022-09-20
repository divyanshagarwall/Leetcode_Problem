class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if( k <= 1){
            return 0;
        }// nums[0] = [1] , k =1
        int count = 0, left = 0, prod = 1;
        for(int r=0; r< nums.length; r++){
            prod *= nums[r];
            while( prod >= k)
                prod /= nums[left++];
            count += r - left + 1; 
        }
        return count;  
    }
}