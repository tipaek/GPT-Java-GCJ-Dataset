import java.util.*;
class Solution{
   public static void main(String args[]){
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        for(int i=0;i<t;i++){
           int n=kb.nextInt();
           int a[][]=new int[n][n];
           for(int j=0;j<n;j++)
             for(int k=0;k<n;k++)
                a[j][k]=kb.nextInt();
            int k=0;    
            for(int j=0;j<n;j++)
            k+=a[j][j];
            int r=0,c=0;
            for(int d=0;d<n;d++)
               for(int b=0;b<n-1;b++){
                  for(int e=b+1;e<n;e++){
                  if(a[d][b]==a[d][e]){
                      r++;
                      break;
                    } 
                    }
                }
             for(int d=0;d<n;d++)
             y:  for(int b=0;b<n-1;b++){
                  for(int e=b+1;e<n;e++)
                  if(a[b][d]==a[e][d]){
                      c++;
                      break y;
                   }  
                }
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);    
        }        
                  
   }
 }  