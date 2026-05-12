class Solution {

    public void track(int[] nums, int index, List<List<Integer>> finalans, List<Integer> ans){

        int l = nums.length;

        if(index>=l){
            finalans.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        track(nums, index+1, finalans, ans);
        
        ans.removeLast();
        track(nums, index+1, finalans, ans);
        
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> finalans = new ArrayList<>();
        track(nums, 0, finalans, new ArrayList<>());
        return finalans;
    }
}
