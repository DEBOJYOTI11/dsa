class Solution {
public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    boolean[] inMST = new boolean[n];
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // {node, edge_cost}
    
    pq.offer(new int[]{0, 0}); // Start with node 0, cost 0
    int totalCost = 0;
    int edgesUsed = 0;
    
    while (!pq.isEmpty() && edgesUsed < n) {
        int[] curr = pq.poll();
        int u = curr[0];
        int weight = curr[1];
        
        // If the node is already part of our tree, skip it
        if (inMST[u]) continue;
        
        // Add edge weight to our MST total
        inMST[u] = true;
        totalCost += weight;
        edgesUsed++;
        
        // Check connections to all other points
        for (int v = 0; v < n; v++) {
            if (!inMST[v]) {
                int dist = Math.abs(points[u][0] - points[v][0]) + 
                           Math.abs(points[u][1] - points[v][1]);
                pq.offer(new int[]{v, dist}); // Notice: we just pass 'dist', NOT 'weight + dist'
            }
        }
    }
    return totalCost;
}
}
