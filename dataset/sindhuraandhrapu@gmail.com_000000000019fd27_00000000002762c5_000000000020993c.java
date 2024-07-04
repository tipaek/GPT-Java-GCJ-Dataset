import java.util.*;
 
public class Vestigium
{  
 public static void main(String args[])
 {
 Scanner sc = new Scanner(System.in);
 int i,j,r,c,n,t;
 int k=1;
 t = sc.nextInt();
 while(k<=t){
    int s=0;
    n = sc.nextInt();
    int[][] m = new int[n][n];
    r=c=n;
    for(i=0;i<r;i++)
    { 
      for(j=0;j<c;j++)
      { 
          m[i][j] = sc.nextInt();
          if(i==j)
            s = s + m[i][j];
      }
    }
    int l,rc=0,cc=0;
     for(i=0;i<r;i++)
    { 
      Set a = new HashSet<>();
      for(j=0;j<c;j++)
      { 
          if(a.contains(m[i][j])){
              rc++;
              break;
          }
          a.add(m[i][j]);
      }
    }
    for(i=0;i<c;i++)
    { 
      Set a = new HashSet<>();
      for(j=0;j<r;j++)
      { 
          if(a.contains(m[j][i])){
              cc++;
              break;
          }
          a.add(m[j][i]);
      }
    }
     System.out.println("Case #"+k+": "+s+" "+rc+" "+cc) ;
     k++;
 }
 } 
}