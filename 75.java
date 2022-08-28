class Solution {
    public void sortColors(int[] nums) {
        int low =0, intmid =0;
        int  high=n-1;
        while (mid <= high){
            if (nums[mid]==0){
                swap(nums,low,mid);
        low++;
        mid++;
            }
        else if (nums[mid]==1){
        mid++;}
        else{
        swap(nums,mid,hight);
        high--;
        }
    }
}