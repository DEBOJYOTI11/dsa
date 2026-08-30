class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        // prefix sum 0 has occurred once
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            // Check if there is an earlier prefix sum
            // such that currentPrefix - oldPrefix = k
            int needed = prefixSum - k;

            if (map.containsKey(needed)) {
                count += map.get(needed);
            }

            // Store current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}