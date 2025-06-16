class Solution {
    static void dfs(int u, boolean[] visited, int[][] graph, List<Integer> path, List<List<Integer>> ans){
        //jo aaya usko visited mark kiya
        visited[u]=true;
        //path mein starting ko toh add karo
        path.add(u);

        //agar destination node tak pahuch gaye ho toh phir add path and return
        if(u==graph.length-1) {ans.add(new ArrayList<>(path));}

        //exploring its neighbours
        for(int v: graph[u]){
            if(!visited[v]){
                dfs(v, visited, graph, path, ans);
            }
        }

        //since we need to run through all the possible paths 
        visited[u]=false;
        //clear only the last element so that we can explore for the durther neighbours
        path.remove(path.size()-1);
        
        //***for clarity dry run the example 2***
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans= new ArrayList<> ();

        List<Integer> path= new ArrayList<>();

        boolean[] visited= new boolean[n];

        dfs(0, visited, graph, path, ans);

        return ans;
    }
}