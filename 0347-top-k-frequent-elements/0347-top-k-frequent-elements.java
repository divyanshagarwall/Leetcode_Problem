public class Solution {

    private Map<Integer, Integer> frequency;

    public int[] topKFrequent(int[] nums, int k) {

        fillMap_frequency(nums);
        int[] uniqueInt = new int[frequency.size()];

        int index = 0;
        for (int n : frequency.keySet()) {
            uniqueInt[index++] = n;
        }

        if (uniqueInt.length == k) {
            return uniqueInt;
        }

        return quickSelect(uniqueInt, k);
    }

    private int[] quickSelect(int[] uniqueInt, int k) {

        int left = 0;
        int right = uniqueInt.length - 1;
        int pivot = uniqueInt.length;

        while (pivot != k) {
            pivot = partition(uniqueInt, left, right);
            if (k > pivot) {
                left = pivot;
            } else {
                right = pivot - 1;
            }
        }
        return Arrays.copyOfRange(uniqueInt, 0, k);
    }

    private int partition(int[] uniqueInt, int left, int right) {

        int pivotIndex = left + (right - left) / 2;
        int pivotFrequency = frequency.get(uniqueInt[pivotIndex]);

        while (left < right) {
            if (frequency.get(uniqueInt[left]) <= pivotFrequency) {
                int temp = uniqueInt[left];
                uniqueInt[left] = uniqueInt[right];
                uniqueInt[right] = temp;
                right--;
            } else {
                left++;
            }
        }

        if (frequency.get(uniqueInt[left]) > pivotFrequency) {
            left++;
        }
        return left;
    }

    private void fillMap_frequency(int[] nums) {
        frequency = new HashMap<>();
        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }
    }
}