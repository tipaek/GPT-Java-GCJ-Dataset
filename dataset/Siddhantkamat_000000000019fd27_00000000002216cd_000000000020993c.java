import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution{
  public static void main(String args[]){
  Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int t=sc.nextInt();
  int l=1;
  while(l<=t){
    int n=sc.nextInt();
    int tr=0,r=0,c=0;
    int[][] a=new int[n][n];
    for(int i=0;i<n;i++){
      int[] row=new int[n];
      for(int j=0;j<n;j++){
        a[i][j]=sc.nextInt();
        if(i==j)
            tr=tr+a[i][j];
        row[j]=a[i][j];
      }
      Arrays.sort(row);
      if(row[0]!=1 || row[n-1]!=n)
        r++;
    }
    for(int i=0;i<n;i++){
      int[] col=new int[n];
      for(int j=0;j<n;j++){
      col[j]=a[j][i];
    }
    Arrays.sort(col);
    if(col[0]!=1 || col[n-1]!=n)
      c++;
  }
  System.out.println("Case #"+l+": "+tr+" "+r+" "+c);

    l++;
  }

  }

}
