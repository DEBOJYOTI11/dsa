class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for(int i : nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a,b)->{return Integer.compare(a.getValue(), b.getValue());}

        );

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            heap.offer(entry);
            if(heap.size() >k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        int i=0;
        while(!heap.isEmpty()){
            ans[i++] = heap.poll().getKey();
        }

        // Arrays.reverse(ans);
        Collections.reverse(Arrays.asList(ans));
        return ans;




    }
}
