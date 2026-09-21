class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;

        if (nums.length == 1){return true;}

        int dest = nums.length - 1;

        for(int i=0; i < nums.length  ; i++){

            if ( max >= dest) {
                return true;
            }

            if(max < i ) {
                return false;
            }

            if(nums[i] + i > max){
                max = nums[i] + i ;
            }
     
        }
        return false;
    }
}
