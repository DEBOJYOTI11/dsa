class Solution {
    
    public boolean hasCycle(int i, List<List<Integer>> graph, int[] visited ){

        if(visited[i]==2){
            return false;
        }
        if(visited[i]==1){
            return true;
        }
        visited[i] = 1;

        for(Integer node : graph.get(i)){

            boolean cycle = hasCycle(node, graph, visited);

            if(cycle){return true;}
        }
        visited[i] = 2;
        return false;

    }
    public boolean canFinish(int n, int[][] p) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){

            graph.add(new ArrayList<>());
        }
        for(int[] edge : p){
            graph.get(edge[1]).add(edge[0]);
        }    


        int[] visited = new int[n];

        for(int i=0;i<n;i++){

            if(visited[i] ==0 && hasCycle(i, graph, visited)){
                return false;
            }
        }
        return true;


    }
}
