class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr = 1;
        for(int i = 0 ; i < nums.length -1 ; i++ ){
            if(nums[i] != nums[i + 1])
            {
                nums[ptr] = nums[i+1];
                ptr++;
            }
        }
        return ptr ;
    }
}