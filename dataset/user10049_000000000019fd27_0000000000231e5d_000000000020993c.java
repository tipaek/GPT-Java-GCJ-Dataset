import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ts = sc.nextInt();
        for(int t=1;t<=ts;t++){
            int n = sc.nextInt();
            int[][] ma = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    ma[i][j]=sc.nextInt();}}
            Result out = new Solution().getResult(ma);
            System.out.println("Case #"+t+": "+out.trace+" "+out.rows+" "+out.cols);
        }
    }
    Result getResult(int[][] ma){
        //boundary
        //problem type scan O(N^2) hashmap
        int trace =0, rows = 0,cols = 0;
        for(int i=0;i<ma.length;i++){
             trace+=ma[i][i];
        }
        for(int i=0;i<ma.length;i++){
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j=0;j<ma[0].length;j++){

                if(set.contains(ma[i][j])) {
                    rows++; break;}
                set.add(ma[i][j]);}}
        for(int j=0;j<ma[0].length;j++){
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i=0;i<ma.length;i++){
                if(set.contains(ma[i][j])) {
                    cols++; break;}
                set.add(ma[i][j]);}}

        Result ret = new Result(trace,rows,cols);
        return ret;
    }

    class Result{int trace;int rows;int cols;public Result(int tr,int ro,int co){this.trace=tr;this.rows=ro;this.cols=co;}}
}
