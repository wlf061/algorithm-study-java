package com.wlf.algorithm.datastructures.topic39;

/****
 * 回溯的处理思想，类似枚举搜索。
 * 八皇后问题：一个 8 * 8 的棋盘，往里面放8个棋子， 每个棋子所在的行，列，对角线都不能有另外一个
 * 棋子。 求最终的放法。
 *
 */
public class Queen8 {
    private int[] result = new int[8]; //下标为行，内容为列,result 的定义减少了计算量

    private boolean isOk(int row, int column){
        int leftUp = column - 1;
        int rightUp = column + 1;

        for(int i = row -1; i >=0; i--){
            if(result[i] == column) return false; // 所在列已经有该元素了
            if(leftUp >=0){
                if(result[i] == leftUp) return false;
            }
            if(rightUp < 8){
                if(result[i] == rightUp) return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    public void calc8Queens(int row){
        if (row >= 8){
            printQueens(result);
            return;
        }
        for(int column=0; column < 8; column++){
            if(isOk(row,column)){
                result[row] = column;
                calc8Queens(row+1);
            }
        }
    }
    private void printQueens(int[] result){
        for(int row=0; row < 8; ++row){
            for(int column = 0; column < 8; ++column){
                if(result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] str){
        new Queen8().calc8Queens(0);
    }
}
