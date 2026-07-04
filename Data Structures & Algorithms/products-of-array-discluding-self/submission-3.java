class Solution {
    // public int[] productExceptSelf(int[] nums) {
        
    //     // brute force is o(n2)

    //     int productExceptZero = 1;

    //     Set<Integer> zeros = new HashSet<>();

    //     for(int i=0;i<nums.length; i++){

    //         if( nums[i] == 0){
    //             zeros.add(i);
    //         }else{
    //             productExceptZero= productExceptZero * nums[i];
    //         }
    //     }
        
    //     int[] output = new int[nums.length];
        
    //     for(int i=0;i<nums.length; i++){
            

    //         int expected = productExceptZero;
    //         if ( nums[i] != 0 ){
    //             expected = productExceptZero / nums[i];
    //         }

    //         if (zeros.contains(i) ){
    //             if ( zeros.size() > 1){
    //                 expected = 0;
    //             }
    //         }else if ( zeros.size() > 0){
    //             expected = 0;
                
    //         }

    //         output[i] = expected;

    //     }
    //     return output;

    // }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        // Step 1: Calculate prefix products and store them in the output array
        // output[i] will contain the product of all elements to the left of nums[i]
        output[0] = 1; 
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        
        // Step 2: Calculate suffix products on the fly and multiply with prefix products
        // rightProduct maintains the product of all elements to the right of nums[i]
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return output;
    }
}  
