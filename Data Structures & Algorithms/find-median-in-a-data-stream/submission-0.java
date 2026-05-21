class MedianFinder {



    // Max heap for smaller half
    private PriorityQueue<Integer> small;

    // Min heap for larger half
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: add to max heap
        small.offer(num);

        // Step 2: maintain ordering
        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }

        // Step 3: balance heap sizes
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        // odd count
        if (small.size() > large.size()) {
            return small.peek();
        }

        // even count
        return (small.peek() + large.peek()) / 2.0;
    }

}
