class Solution {
    public int maxSubarraySumCircular(int[] nums) {
	var total = 0;
	var maxEndingHere = 0;
	var minEndingHere = 0;
	var maxSum = nums[0];
	var minSum = nums[0];

	for (var num : nums) {
		total += num;
		
		maxEndingHere = Math.max(num, num + maxEndingHere);
		maxSum = Math.max(maxSum, maxEndingHere);

		minEndingHere = Math.min(num, num + minEndingHere);
		minSum = Math.min(minSum, minEndingHere);
	}

	return maxSum <= 0 ? maxSum : Math.max(maxSum, total - minSum);
}
}