class Solution {
        static class Node {
        int city, cost, stops;

        Node(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
   List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]});
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Node(src, 0, 0));

        // dist[city][stops]
        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            int city = curr.city;
            int cost = curr.cost;
            int stops = curr.stops;

            if (city == dst) {
                return cost;
            }

            if (stops == k + 1) {
                continue;
            }

            for (int[] nei : graph[city]) {

                int next = nei[0];
                int price = nei[1];

                int newCost = cost + price;

                if (newCost < dist[next][stops + 1]) {

                    dist[next][stops + 1] = newCost;

                    pq.offer(
                        new Node(next, newCost, stops + 1)
                    );
                }
            }
        }

        return -1;
    }
}
