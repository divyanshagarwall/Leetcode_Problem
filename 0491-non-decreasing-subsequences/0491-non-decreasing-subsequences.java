class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        
        helper(nums, 0, new ArrayList<>(), ret);
        return ret;
    }
    
    private void helper(int[] nums, int pos, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() > 1) ret.add(new ArrayList<>(list));
        Set<Integer> set = new HashSet<>();
        for (int i = pos; i < nums.length; ++i) {
            if (!set.add(nums[i])) continue;
            if (list.isEmpty() || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                helper(nums, i+1, list, ret);
                list.remove(list.size()-1);
            }
        }
    }
}