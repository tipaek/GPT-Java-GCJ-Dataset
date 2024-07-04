/*package whatever //do not write package name here */

import java.util.*;

class Solution {
	public static void main (String[] args) {
// 		System.out.println("GfG!");
          Scanner s=new Scanner(System.in);
          int t=s.nextInt();
          int k=1;
          while(t-->0){
              int n=s.nextInt();
              int a[][]=new int[n][n];
              for(int i=0;i<n;i++)
                  for(int j=0;j<n;j++)
                     a[i][j]=s.nextInt();
              int r=0;
              for(int i=0;i<n;i++){
                  HashMap<Integer,Integer> h=new HashMap<>();
                  int d=0;
                  for(int j=0;j<n;j++){
                      if(h.containsKey(a[i][j]))
                      {
                          d=1;
                          break;
                      }
                      else
                      h.put(a[i][j],1);
                  }
                  if(d==1)
                  r++;
              }
              int c=0;
              for(int i=0;i<n;i++){
                  HashMap<Integer,Integer> h=new HashMap<>();
                  int d=0;
                  for(int j=0;j<n;j++){
                      if(h.containsKey(a[j][i]))
                      {
                          d=1;
                          break;
                      }
                      else
                      h.put(a[j][i],1);
                  }
                  if(d==1)
                  c++;
              }
              int tr=0;
              for(int i=0;i<n;i++)
              tr+=a[i][i];
              System.out.println("Case #"+k+": "+tr+" "+r+" "+c);
              k++;
          }
          
	}
}