class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {  
            return Integer.compare(a[2], b[2]);
            });

        for(int i=0;i < points.length; i++){

                int d =
                    
                    points[i][0] * points[i][0]
                    
                    + 
                    points[i][1] * points[i][1];

                
                pq.offer(new int[]{ points[i][0] ,points[i][1] , d });

                // if(pq.size() > k){
                //     pq.poll();
                // }
        }

        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            int[] x = pq.poll();
            ans[i] = new int[]{ x[0] , x[1]};
        }
        return ans;

    }
}
