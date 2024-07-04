import java.util.*;
import java.io.*;
import java.lang.Math;
import java.util.HashMap;

public class Solution{

  public static int checkRow(int[][] temp,int n,int sum,int product){
    int counter = 0;
    for(int i=0;i<n;++i){
      int checksum = 0;
      int checkproduct = 1;
      for(int j=0;j<n;++j){
        int a = temp[i][j];
        checksum += a;
        checkproduct *= a;
      }
      if(checksum !=sum || checkproduct != product)counter++;
    }
    return counter;
  }

  public static int checkColumn(int[][] temp,int n,int sum,int product){
    int counter = 0;
    for(int i=0;i<n;++i){
      int checksum = 0;
      int checkproduct = 1;
      for(int j=0;j<n;++j){
        int a = temp[j][i];
        checksum += a;
        checkproduct *= a;
      }
      if(checksum !=sum || checkproduct != product)counter++;
    }
    return counter;
  }

  public static void solvef(int[][] temp, int trace,int n,int v){
    int sum = 0;
    int product = 1;
    for(int i=1;i<=n;++i){
      sum += i;
      product *= i;
    }
    int rowc = checkRow(temp,n,sum,product);
    int colc = checkColumn(temp,n,sum,product);

      System.out.println("Case #" + v+ ": " + trace + " " + rowc + " " + colc);

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
