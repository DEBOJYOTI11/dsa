class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];

        if (nums.length == 1){return true;}
        int dest = nums.length - 1;

        for(int i=1; i < nums.length - 1  ; i++){

            if(max < i){
                return false;
            }
            if(nums[i] + i > max){
                max = nums[i] + i ;
            }
            if ( max >= dest) {
                return true;
            }
        }

          if ( max >= dest) {
                return true;
            }
        return false;
    }
}
