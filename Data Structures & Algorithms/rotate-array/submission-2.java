class Solution {
    public void rotate(int[] nums, int k) {


        int n = nums.length;
                k = k % n;
        for(int i=0;i< n/2; i++){

            int t = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = t;

        }

        for(int i=0; i< k/2;i++){
             int t = nums[i];
            nums[i] = nums[k - i - 1];
            nums[k - i - 1] = t;
        }
        
        int rem  = n - k;

        for(int i= 0 ; i< rem/2;i++){
            int leftidx = i+k;
            int rightIdx = n - 1 -i;

            int t = nums[leftidx];
            nums[leftidx] = nums[rightIdx];
            nums[rightIdx] = t;
        }


        // int[] op = new int[nums.length];

        // for(int i=0;i<nums.length;i++){

        //     int desiredpos = (i+k)%nums.length;
        //     // 8
        //     // 7 + 4 = 11%8 = 3
        //     op[desiredpos] = nums[i];
        // }

        // for(int i=0;i<nums.length;i++){
        //     nums[i] = op[i];
        // }

    }
}