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
            int[][] mat = new int[size][2];
            for(int i = 0; i < size; i++) {
                for(int j = 0; j<2; j++){
                    mat[i][j] = sc.nextInt();
                }
            }
            parenting(mat, casenum);
        }
    }
    
    public static void parenting(int[][]mat, int casenum){
        boolean valid = true;
        Arrays.sort(mat, new Comparator<int[]> (){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        int C=0, J=0;
        for(int i = 0; i<mat.length; i++){
            if(mat[i][0]>=C){
                C = mat[i][1];
                sb.append('C');
            }
            else if(mat[i][0]>=J){
                J = mat[i][1];
                sb.append('J');
            }
            else{
                valid = false;
                break;
            }
        }
        String result;
        if(valid){
            result = "Case #"+ casenum+ ": " + sb.toString();
        }
        else{
            result = "Case #"+ casenum+ ": IMPOSSIBLE";
        }
        System.out.println(result);
    }
    
}    