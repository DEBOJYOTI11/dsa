class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];

        int n= nums.length;

        for(int i=n-1;i>=0;i--){

            int max = 1;
            for(int j=i+1; j<n;j++){
                if(nums[i]<nums[j]){
                    max = Math.max(max, lis[j] + 1);
                }
            }
            lis[i] = max;
        }
        return Arrays.stream(lis).max().getAsInt();
    }
}
