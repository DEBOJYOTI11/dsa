class Solution {

    public void track(int[] nums, int i, List<List<Integer>> fans, List<Integer> ans, int total, int target){

        if(total == target){
            fans.add(new ArrayList<>(ans));
            return;
        }
        if(i>=nums.length || total>target){
            return;
        }

        ans.add(nums[i]);
        track(nums, i, fans , ans , total + nums[i], target);

        ans.removeLast();
        track(nums, i+1, fans, ans, total, target);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> fans = new ArrayList<>();

        track(nums, 0, fans, new ArrayList<>(), 0, target);
        return fans;

    }
}
