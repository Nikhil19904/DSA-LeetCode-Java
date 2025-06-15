class Solution {

    public void dfs(int r,int c,int[][] visited,char[][] board,int row,int col){
        visited[r][c]=1;
        if(c+1<col && board[r][c+1]=='X'&&visited[r][c+1]==0){
            dfs(r,c+1,visited,board,row,col);
        }
        if(c>0 && board[r][c-1]=='X'&&visited[r][c-1]==0){
            dfs(r,c-1,visited,board,row,col);
        }
        if(r+1<row && board[r+1][c]=='X'&&visited[r+1][c]==0){
            dfs(r+1,c,visited,board,row,col);
        }
        if(r>0 && board[r-1][c]=='X'&&visited[r-1][c]==0){
            dfs(r-1,c,visited,board,row,col);
        }
    }

    public int countBattleships(char[][] board) {
        int r=board.length;
        int c=board[0].length;

        int visited[][]=new int[r][c];
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='X'&&visited[i][j]==0){
                    dfs(i,j,visited,board,r,c);
                    count++;
                }
            }
        }
        return count;

    }
}