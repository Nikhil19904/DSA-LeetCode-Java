class Solution {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void solve(char[][] board) {
        int n = board[0].length;
        int m = board.length;
        int visited[][] = new int[m][n];

        // i would like to start dfs traversal from boundry if getting O and mark
        // visited, with this tech be visited all vertex of graph which can not be crossed(X).

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && board[i][j] == 'O' && visited[i][j] == 0) {
                    DFS(board, i, j, visited);
                }
                if (i == m - 1 && board[i][j] == 'O' && visited[i][j] == 0) {
                    DFS(board, i, j, visited);
                }
                if (j == 0 && board[i][j] == 'O' && visited[i][j] == 0) {
                    DFS(board, i, j, visited);
                }
                if (j == n - 1 && board[i][j] == 'O' && visited[i][j] == 0) {
                    DFS(board, i, j, visited);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void DFS(char board[][], int i, int j, int visited[][]) {
        int n = board[0].length;
        int m = board.length;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(i, j));
        while (!st.isEmpty()) {
            Pair node = st.pop();
            int first = node.first;
            int second = node.second;

            visited[first][second] = 1;

            if (second < n - 1 && board[first][second + 1] == 'O' && visited[first][second + 1] == 0) {
                st.push(new Pair(first, second + 1));
                visited[first][second + 1] = 1;
            }

            // Left
            if (second > 0 && board[first][second - 1] == 'O' && visited[first][second - 1] == 0) {
                st.push(new Pair(first, second - 1));
                visited[first][second - 1] = 1;
            }

            // Down
            if (first < m - 1 && board[first + 1][second] == 'O' && visited[first + 1][second] == 0) {
                st.push(new Pair(first + 1, second));
                visited[first + 1][second] = 1;
            }

            // Up
            if (first > 0 && board[first - 1][second] == 'O' && visited[first - 1][second] == 0) {
                st.push(new Pair(first - 1, second));
                visited[first - 1][second] = 1;
            }
        }
    }
}