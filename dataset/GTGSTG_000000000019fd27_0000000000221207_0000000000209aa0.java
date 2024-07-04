/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    static class Sudoku {
    private int[][] sudokuTable;
    private int k,t;
    public Sudoku(int[][] sudokuTable,int k,int t){
        this.sudokuTable=sudokuTable;
        this.k=k;
        this.t=t;
    }
    public void solveProblem(){
        if(solve(0,0)){
            System.out.println("Case #"+t+": "+"POSSIBLE");
            showResults();
        }
        else{
            System.out.println("Case #"+t+": "+"IMPOSSIBLE");
        }
    }
    public void showResults(){
        for(int i=0;i<sudokuTable.length;i++){
            for(int j=0;j<sudokuTable.length;j++){
                System.out.print(sudokuTable[i][j]+" ");
            }
            System.out.println();
        }
    }
    boolean suceed(){
        int sum=0;
        for(int i=0;i<sudokuTable.length;i++){
            sum+=sudokuTable[i][i];
        }
        if(sum==k) return true;
        return false;
    }
    public boolean solve(int rowIndex,int columnIndex){
        if(rowIndex==sudokuTable.length && ++columnIndex==sudokuTable.length){
            return suceed();
        }
        if(rowIndex==sudokuTable.length){
            rowIndex=0;
        }
        if(sudokuTable[rowIndex][columnIndex]!=0){
            return solve(rowIndex+1,columnIndex);
        }
        for(int number=1;number<=sudokuTable.length;number++){
            if(valid(rowIndex,columnIndex,number)){
                sudokuTable[rowIndex][columnIndex]=number;
                if(solve(rowIndex+1,columnIndex)){
                    return true;
                }
                sudokuTable[rowIndex][columnIndex]=0;
            }
        }
        return false;
    }
    public boolean valid(int rowIndex,int columnIndex,int actualNumber){
        for(int i=0;i<sudokuTable.length;i++) {
            if (sudokuTable[i][columnIndex] == actualNumber) {
                return false;
            }
        }
        for(int i=0;i<sudokuTable.length;i++){
            if(sudokuTable[rowIndex][i]==actualNumber){
                return false;
            }
        }
        // int boxRowOffset=(rowIndex/3)*3;
        // int boxColOffset=(columnIndex/3)*3;
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<3;j++){
        //         if(actualNumber==sudokuTable[boxRowOffset+i][boxColOffset+j]){
        //             return false;
        //         }
        //     }
        // }
        return true;
    }
}
	public static void main (String[] args) throws java.lang.Exception
	{
// 		int sudokuTable[][]={{3,0,6,5,0,8,4,0,0},
//                              {5,2,0,0,0,0,0,0,0},
//                              {0,8,7,0,0,0,0,3,1},
//                              {0,0,3,0,1,0,0,8,0},
//                              {9,0,0,8,6,3,0,0,5},
//                              {0,5,0,0,9,0,6,0,0},
//                              {1,3,0,0,0,0,2,5,0},
//                              {0,0,0,0,0,0,0,7,4},
//                              {0,0,5,2,0,6,3,0,0}};
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        for(int tt=1;tt<=t;tt++){
            String[] s=br.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            int sudokuTable[][]=new int[n][n];
            Sudoku sudoku=new Sudoku(sudokuTable,k,tt);
            sudoku.solveProblem();
        }
	}
}

