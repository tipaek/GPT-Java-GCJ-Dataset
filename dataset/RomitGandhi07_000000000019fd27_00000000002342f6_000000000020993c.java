import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
       for(int x=1;x<=t;++x){
            int n=sc.nextInt();
            int[][] a= new int[n][n];
            boolean[] b=new boolean[n+1];
            int count=0,r=0,c=0;
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    a[i][j]=sc.nextInt();
                    if(b[a[i][j]]){++count;}
                    else{b[a[i][j]]=true;}
                }
                if(count>0){++r;}
                Arrays.fill(b,false);count=0;
            }
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    if(b[a[j][i]]){++count;}
                    else{b[a[j][i]]=true;}
                }
                if(count>0){++c;}
                Arrays.fill(b,false);count=0;
            }
            int k=0;
            for(int i=0;i<n;++i){
                k+=a[i][i];
            }
            System.out.println("Case #"+(x)+":"+ k+" "+r+" "+c);
        }
    }
}