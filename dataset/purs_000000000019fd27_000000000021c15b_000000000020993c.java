import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Solution{
    static Scanner sc;
    
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];
            for(int i = 0; i < size; i++) {
                for(int j =0; j<size; j++){
                    mat[i][j] = sc.nextInt();
                }
            }
            vestigium(mat, casenum);
        }
    }
    
    public static void vestigium(int[][] mat, int casenum){
        int trace = 0;
        for(int i=0; i<mat.length; i++){
            trace +=mat[i][i];
        }
        HashSet<String> row_seen = new HashSet<>();
        HashSet<String> col_seen = new HashSet<>();
        HashSet<Integer> row_rpt = new HashSet<>();
        HashSet<Integer> col_rpt = new HashSet<>();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                String str1 = mat[i][j]+" at " + i;
                if(!row_seen.add(str1)){
                    row_rpt.add(i);
                }
                String str2 = mat[i][j]+" at " + j;
                if(!col_seen.add(str2)){
                    col_rpt.add(j);
                }
            }
        }
        String result = "Case #" +casenum +": " + trace + " " + row_rpt.size() + " "+ col_rpt.size();
        System.out.println(result);
    }
}