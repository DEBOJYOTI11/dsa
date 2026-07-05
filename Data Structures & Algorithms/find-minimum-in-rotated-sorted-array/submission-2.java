class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int left = 0;

        int right = n-1;
        
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.min(nums[0], nums[1]);
        }
        while(left<right){

            int mid = (left+right)/2;


            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
