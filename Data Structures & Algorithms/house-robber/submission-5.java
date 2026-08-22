class Solution {

//    // recursive solution
//     public int robHouse(int[] nums, int i, int ans){

//             if(i>nums.length-1){
//                 return ans;
//             }

//             int l1 = robHouse(nums, i+2, ans + nums[i]);
//             int l2 = robHouse(nums, i+1, ans);

//             return Math.max(l1, l2);

//     }
//     public int rob(int[] nums) {
//        return robHouse(nums, 0, 0);
//     }

    public int rob(int[] nums) {
       int[] ans = new int[nums.length];
       if(nums.length == 1){
        return nums[0];
       }

       if(nums.length == 2){
        return Math.max(nums[0], nums[1]);
       }
       ans[0] = nums[0];
       ans[1] = Math.max(nums[0], nums[1]);
       int max = Integer.MIN_VALUE;
       for(int i=2;i<nums.length;i++){
            ans[i] = Math.max(nums[i] + ans[i-2], ans[i-1]);
            max = Math.max(max,  ans[i]);
       }
       return max;
    }
}
