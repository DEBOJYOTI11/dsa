class Solution {

    
    public int networkDelayTime(int[][] times, int n, int k) {
        

        int inf = 100000000;

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] time : times){

            adj.computeIfAbsent(time[0],  p -> new ArrayList<>())
                .add(new int[]{time[1], time[2]});
        }


    
        int[] dist = new int[n+1];
        Arrays.fill(dist, inf);
        dist[k] = 0;

        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a,b)-> { return a[1] - b[1]; } );

        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){

            int[] ele = pq.poll();

            int currElement = ele[0];
            int currWeight = ele[1];

            
            for(int[] edge :  adj.getOrDefault(currElement, new ArrayList<>())){
                
                int destElement = edge[0];
                int destWeight = edge[1];


                if(currWeight + destWeight < dist[destElement]){

                    dist[destElement] = currWeight + destWeight;

                    pq.offer(new int[]{destElement,dist[destElement]});
                }
            }
        }

        int max = 0;
        for(int i=1 ; i< dist.length;i++){
            if(dist[i]==inf){
                return -1;
            }
            max  = Math.max(max, dist[i]);
        }
        return max;

    }
}
