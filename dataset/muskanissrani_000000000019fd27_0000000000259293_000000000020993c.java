import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n;i++){
          int m =s.nextInt(),tot1=0,tot2=0,tot3=0; 
          int[][] b= new int[m][m];
          for(int j=0;j<m;j++){
              for(int k=0;k<m;k++){
                  b[j][k]=s.nextInt();
                  if(j==k)
                  tot1=tot1+b[j][k];
              }
          }int q=b[0][0],f=0,f1=0;
          for(int j=0;j<m;j++)
          {
              for(int k=0;k<m-1;k++){
                  for(int l=k+1;l<m;l++)
                  {if(b[j][k]==b[j][l])
                  {f=1;break;}
                  }if(f==1)
                  {tot3++;break;}
              }
              for(int k=0;k<m-1;k++){
                  for(int l=k+1;l<m;l++)
                  {if(b[k][j]==b[l][j])
                  {f1=1;break;}
                  }if(f1==1)
                  {tot2++;break;}
              }
          }
          System.out.println("case #"+(i+1)+": "+tot1+" "+tot3+" "+tot2);
        }
  }
}