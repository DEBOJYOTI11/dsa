class Solution {
    public void moveZeroes(int[] nums) {
        
        int left = 0;
        int right = 0;

        while(left < nums.length && nums[left] != 0){
            left++;
            right++;
        }

        while(right < nums.length && left < nums.length){

            while(right < nums.length && nums[right] == 0 ){
                right++;
            }

            if(right < nums.length){
                int t = nums[right];
                nums[right] = nums[left];
                nums[left] = t;

                left++;
            }
        }
    }
}