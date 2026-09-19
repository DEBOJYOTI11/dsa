class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        
        boolean match = false;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){

                int j= i+1;
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                while(j<n){
                    if(nums[j]< min && nums[j]>nums[i]){
                        min = nums[j];
                        minIndex = j;
                    }
                    j++;
                }
                
    
                swap(nums, i, minIndex);
     
                reverse(nums, i+1, n-1);
                match = true;
                break;
            }
        
        }

        if(!match) reverse(nums, 0, n-1);
    }

    public void swap(int[] nums, int i, int j){
        int t  = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void reverse(int[] nums, int i, int j){
        
        while(i<j){
            swap(nums, i,j);
            i++;
            j--;
        }
    }


}