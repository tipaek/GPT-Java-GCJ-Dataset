import java.io.*;
import java.util.*;
import java.awt.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        int z=1;
        while(t-->0){
            int n=sc.nextInt();
            int k=0,r=0,c=0;
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j)k+=arr[i][j];
                }
            }
            HashSet<Integer> hs;
            for(int i=0;i<n;i++){
                hs=new HashSet<>();
                for(int j=0;j<n;j++){
                    if(hs.contains(arr[i][j])){
                        r++;
                        break;
                    }
                    hs.add(arr[i][j]);
                }
            }
            for(int j=0;j<n;j++){
                hs=new HashSet<>();
                for(int i=0;i<n;i++){
                    if(hs.contains(arr[i][j])){
                        c++;
                        break;
                    }
                    hs.add(arr[i][j]);
                }
            }
            sb.append("Case #"+(z++)+": "+k+" "+r+" "+c+"\n");
        }
        System.out.println(sb);
    }
}
//Case #x: k r c
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}