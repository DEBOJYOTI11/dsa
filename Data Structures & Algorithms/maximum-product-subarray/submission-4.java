class Solution {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int x = nums[i];

            int newMax = Math.max(x, Math.max(x * max, x * min));
            int newMin = Math.min(x, Math.min(x * max, x * min));

            max = newMax;
            min = newMin;

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
