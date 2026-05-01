class Solution {
   public List<Integer> topoSort(int numCourses, int[][] prerequisites) {

        List<Integer> order = new ArrayList<>();

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);

        int[] state = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(i, adj, state, order))
                return new ArrayList<>();  // cycle → cannot complete
        }

        // order is in reverse topological order because we add post DFS
        Collections.reverse(order);

        return order;
    }

    private boolean hasCycle(int course, List<List<Integer>> adj,
                             int[] state, List<Integer> order) {

        if (state[course] == 1) return true;    // cycle
        if (state[course] == 2) return false;   // already processed

        state[course] = 1; // mark visiting

        for (int next : adj.get(course)) {
            if (hasCycle(next, adj, state, order)) return true;
        }

        state[course] = 2; // mark visited
        order.add(course); // add to topological order
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = topoSort(numCourses, prerequisites);
        return order.stream().mapToInt(i -> i).toArray();
    }
}
