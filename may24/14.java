class Solution {
    public int getMaximumGold(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int visited[][]=new int[row][col];
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0) ans=Math.max(find_max(grid,visited,i,j),ans);
            }
        }
        return ans;
    }
    public static int find_max(int[][] arr,int[][] visited,int i,int j){
        if(i<0||j<0||i>=arr.length||j>=arr[0].length||visited[i][j]==1||arr[i][j]==0) return -1000000;

        visited[i][j]=1;
        int a=find_max(arr,visited,i+1,j);
        if(a<0) a=0;
        int b=find_max(arr,visited,i-1,j);
        if(b<0) b=0;
        int c=find_max(arr,visited,i,j+1);
        if(c<0) c=0;
        int d=find_max(arr,visited,i,j-1);
        if(d<0) d=0;
        visited[i][j]=0;
        int max=Math.max(Math.max(a,b),Math.max(c,d));
        return max+arr[i][j];
    }

}
