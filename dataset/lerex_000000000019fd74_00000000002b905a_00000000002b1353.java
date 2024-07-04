import java.util.*;
import java.io.*;
public class Solution {
    
  public static ArrayList<Integer> backt(int gra[][],int i,int j,int sum,boolean vis[][]){
      if(i<0||j<0||i>=gra.length||j>=gra[i].length||sum-gra[i][j]<0||vis[i][j]==true)return null;
      ArrayList<Integer> result = new ArrayList<Integer>();
      result.add(i+1);
      result.add(j+1);
      
      if(gra[i][j]-sum==0)return result;
      ArrayList<Integer> temp[] = new ArrayList[6];
      boolean vt[][] = vis.clone();
      vt[i][j]=true;
      int k = gra[i][j];
      temp[0] = backt(gra,i+1,j,sum-k,vt);
      temp[1] = backt(gra,i,j+1,sum-k,vt);
      temp[2] = backt(gra,i+1,j+1,sum-k,vt);
      temp[3] = backt(gra,i,j-1,sum-k,vt);
      temp[4] = backt(gra,i-1,j,sum-k,vt);
      temp[5] = backt(gra,i-1,j-1,sum-k,vt);
      ArrayList<Integer> re = null;
      for(int x =0;x<6;x++){
          if(re==null)re=temp[x];
          else if(temp[x]!=null&&re.size()>temp[x].size())re = temp[x];
      }
      if(re==null)
      return re;
      result.addAll(re);
      return result;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
        int res[][] = new int[n][];
        boolean vis[][] = new boolean[n][];
        for(int k = 0; k < n; k++)
        {
            res[k] = new int[k+1];
            vis[k] = new boolean[k+1];
            res[k][0] = res[k][k] = 1;
        }
        for(int k = 2; k < n; k++)
        {
            for(int j = 1; j < k; j++)
            {
                res[k][j] = res[k-1][j-1] + res[k-1][j];
            }
        }
        ArrayList<Integer> sol = backt(res,0,0,n,vis);
        System.out.println("Case #" + i + ":");
        for(int k =0;k<sol.size();k+=2){
            System.out.println(sol.get(k)+" "+sol.get(k+1));
        }
    }
  }
  
} 