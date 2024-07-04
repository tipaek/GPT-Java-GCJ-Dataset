import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cnt=0;
        while(t-->0){
            ++cnt;
            int n=sc.nextInt();
            int m[][]=new int[n+1][n+1];
            Set<Integer>st=new HashSet<>();
            int k=0; int r=0; int c=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    m[i][j]=sc.nextInt();
                    st.add(m[i][j]);
                    if(i==j) k+=m[i][j];
                    if(j==n){
                        if(st.size()<n) ++r;
                        st.clear();
                    }
                }
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    st.add(m[j][i]);
                    if(j==n){
                        if(st.size()<n) ++c;
                        st.clear();
                    }
                }
            }
            System.out.print("Case #"+cnt+": "+k+" "+r+" "+c);
            System.out.println();
        }
    }
}