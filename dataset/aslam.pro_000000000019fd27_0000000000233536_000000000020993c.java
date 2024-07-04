import java.util.*;
import java.io.*;
    public class Solution {
    static  int row=0,col=0;
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= T; ++x) {
            int N=in.nextInt();
            int M[][]=new int[N][N];
            int trc=0;
             for(int i=0;i<N;i++)
                {
                    for(int j=0;j<N;j++)
                        {
                            M[i][j]=in.nextInt();
                              if(i==j)
                                 {
                                   trc=trc+M[i][j];
                                 }
                         }
                  
                 
                }
             check(N,M);
           
            
          
          System.out.println("Case #" + x + ": " + trc + " " + row +" "+ col);
           row=0;
           col=0;
        }
      }
   public static void check(int n,int mat[][])
      {
           int m[][]=new int[n][n];
            m=mat;
          
         for(int i=0;i<n;i++)
             {
                  boolean rowc=false,colc=false; 
                   for(int j=0;j<n;j++)
                      {
                          for(int k=j+1;k<n;k++)
                              {     
                                    if(rowc==false){
                                     if(m[i][j]==m[i][k])
                                        {
                                             row=row+1;
                                             rowc=true;
                                            break;
                                        }
                                     }
                                   if(colc==false){
                                     if(m[j][i]==m[k][i])
                                        {
                                            col=col+1;
                                            colc=true;
                                           break;
                                        }
                                    }
                               }
                          
                      }
               }














   
      }
    
    }
 

