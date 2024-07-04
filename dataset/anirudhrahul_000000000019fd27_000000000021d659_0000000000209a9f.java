/**
 * Created by user on 4/3/2020.
 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int cases = Integer.parseInt(br.readLine());
        for(int c=1;c<=cases;c++) {
            wr.write("Case #"+c+": ");
            String in = br.readLine();
            StringBuilder sb = new StringBuilder();
            int open=0;
            for(int i=0;i<in.length();i++){
                int val = in.charAt(i)-'0';
                while(open<val){
                    sb.append("(");
                    open++;
                }
                while(open>val){
                    sb.append(")");
                    open--;
                }
                sb.append(in.charAt(i));
            }
            while(open>0){
                sb.append(")");
                open--;
            }
            wr.write(sb.toString());
            wr.write("\n");
        }
        wr.close();

    }
}
