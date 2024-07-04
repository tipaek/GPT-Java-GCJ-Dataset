import java.util.*;
import java.io.*;
import java.lang.Math;
import java.util.HashMap;

public class Solution{

  public static int findMax(int[] arr){
    int result = 0;
    for(int i=0;i<arr.length;++i){
      int cur = arr[i];
      if(result<cur && cur!= 1) result = cur;
    }
    return result;
  }

  public static String check(int[][] arr,int n){
    int max = 0;
    int mcol = 0;
    for(int i=0;i<n;++i){
      int[] temp = new int[n];
      int[] tempcol = new int[n];//
      for(int j=0;j<n;++j){
        int a = arr[i][j]-1;
        temp[a] += 1;
        int b = arr[j][i]-1;//
        tempcol[b] += 1;//
      }
      int cur = findMax(temp);
      int curcol = findMax(tempcol);//
      if(mcol<curcol && curcol !=1) mcol=curcol;//
      if(max<cur && cur!=1) max = cur;
    }
    return max + " " + mcol;
  }


  public static void solvef(int[][] temp, int trace,int n,int v){
    int sum = 0;
    int product = 1;
    for(int i=1;i<=n;++i){
      sum += i;
      product *= i;
    }
    String s = check(temp,n);

      // System.out.println("Case #" + v+ ": " + trace + " " + rowc + " " + colc);
      System.out.println("Case #" + v+ ": " + trace + " " + s);

  }

  public static void main(String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for(int i=1;i<=t;++i){
    int trace = 0;
      int n = in.nextInt();
      int[][] temp = new int[n][n];
      for(int j=0;j<n;++j){
        for(int k=0;k<n;++k){
          temp[j][k]=in.nextInt();
          if(j==k)trace+=temp[j][k];
        }
      }
      solvef(temp,trace,n,i);

    }
      in.close();
  }


}
