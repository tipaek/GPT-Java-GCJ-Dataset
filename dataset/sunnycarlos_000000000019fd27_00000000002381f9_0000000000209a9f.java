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
            StringBuilder temp=new StringBuilder();
            char[] c=sc.next().toCharArray();
            int curr=0;
            for(int i=0;i<c.length;i++){
                if(c[i]=='0'){
                    for(int j=1;j<=curr;j++){
                        temp.append(")");
                    }
                    curr=0;
                    temp.append(0);
                }
                else{
                    if(c[i]-'0'>curr){
                        curr++;

                        for(int j=curr;j<=c[i]-'0';j++){
                            temp.append("(");
                        }
                        curr=c[i]-'0';
                        temp.append(curr);
                    }
                    else if(c[i]-'0'==curr)temp.append(curr);
                    else{
                        curr--;
                        for(int j=curr;j>=c[i]-'0';j--){
                            temp.append(")");
                        }
                        curr=c[i]-'0';
                        temp.append(curr);
                    }
                }
            }
            for(int i=1;i<=curr;i++)temp.append(")");
            sb.append("Case #"+(z++)+": "+temp.toString()+"\n");
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