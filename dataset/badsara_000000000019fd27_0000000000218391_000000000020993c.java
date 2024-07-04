import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int t=1;t<=T;t++){
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            int r=0,c=0;
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                    if(i==j){
                        sum+=a[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++){
                Set<Integer> st=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(st.contains(a[i][j])){
                        r++;
                        break;
                    }
                    st.add(a[i][j]);
                }
            }
            for(int i=0;i<n;i++){
                Set<Integer> st=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(st.contains(a[j][i])){
                        c++;
                        break;
                    }
                    st.add(a[j][i]);
                }
            }
            sb.append("Case #").append(t).append(": ").append(sum).append(" ");
            sb.append(r).append(" ").append(c).append("\n");
        }
        out.println(sb);
        out.close();
    }
    public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
}