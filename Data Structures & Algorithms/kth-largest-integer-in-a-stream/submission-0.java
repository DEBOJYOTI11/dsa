class KthLargest {

 


    private List<Integer> stream = new ArrayList<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        stream.add(val); // full stream preserved

        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

