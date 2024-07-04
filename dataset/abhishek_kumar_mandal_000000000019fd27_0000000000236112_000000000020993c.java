import java.util.*;

public class Solution{
    
public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    for(int t1=1;t1<=t;t1++){
        int n=Integer.parseInt(sc.next());
       
       
        int [][]mat = new int[n][n];
        
        
       int ans = 0;
       int ans1 = 0;
       int ans2 = 0;
       int r = 0;
       int c = 0;
       
       for(int i=0;i<n;i++){
           c=0;
           TreeSet<Integer> tr1 = new TreeSet();
           for(int j=0;j<n;j++){
               int in = sc.nextInt();
               mat[i][j] = in;
               if(i==j)
               ans = ans+mat[i][j];
               tr1.add(mat[i][j]);
           }
           c=n-tr1.size();
           ans2 = Math.max(c,ans2);
       }
       
       
       for(int i=0;i<n;i++){
           c=0;
           TreeSet<Integer> tr1 = new TreeSet();
           for(int j=0;j<n;j++){
               int in = mat[j][i];
               tr1.add(in);
           }
           c=n-tr1.size();
           ans1 = Math.max(c,ans1);
       }
        
        if(ans1!=0)
        ans1++;
        if(ans2!=0)
        ans2++;
        
        System.out.println("Case #"+t1+": "+ans+" "+ans2+" "+ans1);
        }
    }

}