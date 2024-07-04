import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int[][] arr=new int[n][n];
          for(int r=0;r<n;r++){
                for(int c=0;c<n;c++){
                    arr[r][c]= in.nextInt();  
                }
            }
          ves(arr,i);
        }
        
        
    }
    public static void ves(int[][] grid, int tc){
        int nr=grid.length, nc=grid[0].length, rowcount=0,colcount=0,l=0;
        for(int i=0;i<nc;i++){
            int [] r=grid[i];
            int[] c=new int[nr];
            rowcount+=dup(r);
            for(int j=0;j<nr;j++){
               if(i==j) l+=grid[i][j]; 
               c[j]=grid[j][i];
            }
           colcount+=dup(c);
        }
        System.out.println("Case #" + tc + ": " + l + " " + rowcount+ " " + colcount);
        //System.out.println("rc"+" "+rowcount+" "+"cc"+" "+colcount+" "+"l"+" "+l);
        
    }
    public static int dup(int[] r){
        HashSet<Integer> set=new HashSet<>();
        for(int i:r){
            set.add(i);
        }
        if((set.size()-r.length)== 0) return 0;
        else return 1;
    }
}
