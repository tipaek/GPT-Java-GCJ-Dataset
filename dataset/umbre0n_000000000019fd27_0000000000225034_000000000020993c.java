import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 
import java.util.*;
import java.lang.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class Solution implements Runnable {

  static BufferedReader in;
  static PrintWriter out;

  static int minInversionsNeeded;
  static boolean[][] isOpenCell;
  static int[][] ways;
 
  public static void main(String[] args) {
      new Thread(null, new Solution(), "whatever", 1<<29).start();
  }
 
  public void run() {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out, false);
 
    try
    {
      // in = new BufferedReader(new FileReader("class_treasurer.txt"));
      // out = new PrintWriter("output.txt");

      int t,x1,n,i,j;
      String str;
      String[] token;

      str=in.readLine().trim();
      token=str.split(" ");

      t=Integer.parseInt(token[0]);

      for(x1=0;x1<t;x1++) {

        str=in.readLine().trim();
        token=str.split(" ");

        n=Integer.parseInt(token[0]);

        int[][] grid=new int[n][n];

        int sum=0;

        for(i=0;i<n;i++) {
          str=in.readLine().trim();
          token=str.split(" ");

          for(j=0;j<n;j++) {
            grid[i][j]=Integer.parseInt(token[j]);
            if(i==j) {
              sum+=grid[i][j];
            }
          }
        }

        int rowWithDuplicates=0;
        int columnWithDuplicates=0;

        for(i=0;i<n;i++) {
          boolean[] visited=new boolean[n+1];
          for(j=0;j<n;j++) {
            if(visited[grid[i][j]]) {
              rowWithDuplicates++;
              break;
            }
            visited[grid[i][j]]=true;
          }
        }

        for(j=0;j<n;j++) {
          boolean[] visited=new boolean[n+1];
          for(i=0;i<n;i++) {
            if(visited[grid[i][j]]) {
              columnWithDuplicates++;
              break;
            }
            visited[grid[i][j]]=true;
          }
        }

        out.println(String.format("Case #%s: %s %s %s", x1+1, sum, rowWithDuplicates, columnWithDuplicates));
      }

      out.flush();
      out.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
