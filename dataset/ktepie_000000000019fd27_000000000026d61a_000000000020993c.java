import java.util.*;
import java.io.*;
import java.lang.Math;
import java.util.HashMap;

public class Solution{

  public static boolean findMax(int[] arr){
    int result = 0;
    for(int i=0;i<arr.length;++i){
      if(arr[i]!=1) return true;
    }
    return false;
  }

  public static String check(int[][] arr,int n){
    int colc=0;
    int rowc=0;
    for(int i=0;i<n;++i){
      colc = 0;
      rowc = 0;
      int[] temp = new int[n];
      int[] tempcol = new int[n];
      for(int j=0;j<n;++j){
        int a = arr[i][j]-1;
        temp[a] += 1;
        int b = arr[j][i]-1;
        tempcol[b] += 1;
      }
      if(findMax(tempcol)) colc++;
      if(findMax(temp)) rowc++;
      
    }
    return rowc + " " + colc;
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
      String s = check(temp,n);
      System.out.println("Case #" + i + ": " + trace + " " + s);

    }
      in.close();
  }


}
