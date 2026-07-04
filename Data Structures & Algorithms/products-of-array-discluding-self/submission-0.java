class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // brute force is o(n2)

        int productExceptZero = 1;

        Set<Integer> zeros = new HashSet<>();

        for(int i=0;i<nums.length; i++){

            if( nums[i] == 0){
                zeros.add(i);
            }else{
                productExceptZero= productExceptZero * nums[i];
            }
        }
        
        int[] output = new int[nums.length];
        
        for(int i=0;i<nums.length; i++){
            

            int expected = productExceptZero;
            if ( nums[i] != 0 ){
                expected = productExceptZero / nums[i];
            }

            if (zeros.contains(i)){
                if ( zeros.size() > 1){
                    expected = 0;
                }
            }else{
                 if ( zeros.size() > 0){
                    expected = 0;
                }
            }

            output[i] = expected;

        }
        return output;

    }
}  
