class Solution {
    public void rotate(int[] nums, int k) {


        int[] op = new int[nums.length];

        for(int i=0;i<nums.length;i++){

            int desiredpos = (i+k)%nums.length;

            // 8
            // 7 + 4 = 11%8 = 3
            op[desiredpos] = nums[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[i] = op[i];
        }


    }
}