import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Solution{
    static Scanner sc;
    static int final_int_level =0;
    static int round_int = 0;
    static int[][] mat;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            final_int_level = 0;
            int row = sc.nextInt();
            int col = sc.nextInt();
            createMatrix(row, col, sc);
            int old_count =0;
            int new_count = countCell(row,col);
            while(new_count != old_count){
                old_count = new_count;
                round_int = calculateInterest(row,col);
                final_int_level += round_int;
                eliminate(row,col);
                new_count = countCell(row,col);
            }
            System.out.println("Case #"+ casenum+": "+final_int_level);
        }
    }
    
    public static void createMatrix(int row, int col, Scanner sc){
        mat = new int[row][col];
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                mat[i][j] = sc.nextInt();
            }
        }
    }
    
    public static int calculateInterest(int row, int col){
        int value = 0;
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                value += mat[i][j];
            }
        }
        return value;
    }
    
    public static int countCell(int row, int col){
        int count = 0;
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j]>0) count++;
            }
        }
        return count;
    }
    
    public static float findNAverage(int row, int col, int maxr, int maxc){
        int r=row, c=col, sum =0, count =0;
        for(int i=row-1; i>=0;i--){
            if(mat[i][c]!=0){
                sum += mat[i][c];
                count++;
                break;
            }
        }
        for(int i=row+1; i<maxr; i++){
            if(mat[i][c]!=0){
                sum += mat[i][c];
                count++;
                break;
            }
        }
        for(int i=col-1; i>=0;i--){
            if(mat[r][i]!=0){
                sum += mat[r][i];
                count++;
                break;
            }
        }
        for(int i=col+1; i<maxc; i++){
            if(mat[r][i]!=0){
                sum += mat[r][i];
                count++;
                break;
            }
        }
        return (float) sum/count;
    }
    
    public static void eliminate(int row,int col){
        List<Integer> failed = new ArrayList<>();
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                float comp = findNAverage(i,j,row,col);
                if((mat[i][j]*1.0) < comp){
                    int row_col = i*col+j;
                    failed.add(row_col);
                }
            }
        }
        for(Integer val: failed){
            int r_val = val/col;
            int col_val = val%col;
            mat[r_val][col_val] = 0;
        }
        return;
    }
}