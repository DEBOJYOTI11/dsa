class Solution {
    public int leastInterval(char[] tasks, int n) {
        



        // Count frequency of tasks
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        // {remainingCount, availableTime}
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            time++;

            // Execute highest frequency task
            if (!maxHeap.isEmpty()) {

                int count = maxHeap.poll();
                count--;

                // Put into cooldown if still remaining
                if (count > 0) {
                    cooldown.offer(new int[]{count, time + n});
                }
            }

            // Reinsert task whose cooldown is finished
            if (!cooldown.isEmpty()
                    && cooldown.peek()[1] == time) {

                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;

    }
}
