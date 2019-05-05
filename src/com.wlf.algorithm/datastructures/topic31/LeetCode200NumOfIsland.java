package com.wlf.algorithm.datastructures.topic31;


public class LeetCode200NumOfIsland {
    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfsMark(grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsMark(char[][] grid, int row, int col) {
        if (col< 0 || row < 0 || row >= n || col >= m || grid[row][col] == '0')
            return;
        //smart
        grid[row][col] = '0';
        dfsMark(grid, row, col + 1);
        dfsMark(grid, row, col - 1);
        dfsMark(grid, row - 1, col);
        dfsMark(grid, row + 1, col);
    }

    public static void main(String[] str){
        char[][] graph = {
                             {'1','1','1','1','0'},
                             {'1','1','0','1','0'},
                             {'1','1','0','0','0'},
                             {'0','0','0','0','0'}
                          };
        //System.out.println(new LeetCode200NumOfIsland().numIslands(graph));
        System.out.println(2/3);
    }
}
