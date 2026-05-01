class Solution {
public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
    
    for (int[] p : prerequisites) {
        adj.get(p[1]).add(p[0]);
    }
    
    int[] state = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
    
    for (int i = 0; i < numCourses; i++) {
        if (state[i] == 0 && hasCycle(i, adj, state))
            return false;
    }
    return true;
}

private boolean hasCycle(int course, List<List<Integer>> adj, int[] state) {
    if (state[course] == 1) return true;  // cycle
    if (state[course] == 2) return false; // already safe
    
    state[course] = 1; // mark visiting
    
    for (int next : adj.get(course)) {
        if (hasCycle(next, adj, state)) return true;
    }
    
    state[course] = 2; // mark completed
    return false;
}
}
