class Solution {
    private int time = 1;
    private int[] disc, low;
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer>[] graph;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Step 1: Build the graph
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (List<Integer> conn : connections) {
            int u = conn.get(0), v = conn.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // Step 2: Initialize discovery and low arrays
        disc = new int[n];
        low = new int[n];

        // Step 3: Run DFS from any node (e.g. node 0)
        dfs(0, -1);

        return result;
    }

    private void dfs(int node, int parent) {
        disc[node] = low[node] = time++;
        
    for (int i = 0; i < graph[node].size(); i++) {
    int neighbor = graph[node].get(i);
    if (neighbor == parent) continue;

    if (disc[neighbor] == 0) {
        dfs(neighbor, node);
        low[node] = Math.min(low[node], low[neighbor]);

        if (low[neighbor] > disc[node]) {
            result.add(Arrays.asList(node, neighbor));
        }
    } else {
        low[node] = Math.min(low[node], disc[neighbor]);
    }
}
       

    }
}
