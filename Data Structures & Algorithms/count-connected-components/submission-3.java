class Solution {
    public int countComponents(int n, int[][] edges) {

        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){
            
            adj.computeIfAbsent(edge[0],k->new ArrayList<>())
                .add(edge[1]);
            adj.computeIfAbsent(edge[1],k->new ArrayList<>())
                .add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        int count=0;
        for(int i=0;i<n;i++){
          
            if(!visited[i]){
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;

    }

    public void dfs(Integer i, HashMap<Integer,List<Integer>> adj, boolean[] visited){


        visited[i] = true;

        for(Integer e : adj.getOrDefault(i, new ArrayList<>())){

            if(!visited[e]){
                dfs(e, adj, visited);
            }
        }
    }
}
