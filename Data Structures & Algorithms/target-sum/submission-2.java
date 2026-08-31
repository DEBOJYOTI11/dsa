class Solution {

     HashMap<String, Integer> memo = new HashMap<>();
    public int rec(int[] nums, int n,  int i, int target, int sum){

        // if( sum > target){
        //     return 0;
        // }
        if( n==i && sum==target){
            return 1;
        } else if(n==i && target != sum){
            return 0;
        }

        String key = i + "," + sum;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int temp1 = sum + nums[i];
        int temp2 = sum - nums[i];
        
    int add = rec(nums, n, i + 1, target, sum + nums[i]);
        int subtract = rec(nums, n, i + 1, target, sum - nums[i]);

        int result = add + subtract;

        memo.put(key, result);

        return result;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums, nums.length, 0, target, 0);
    }
}
