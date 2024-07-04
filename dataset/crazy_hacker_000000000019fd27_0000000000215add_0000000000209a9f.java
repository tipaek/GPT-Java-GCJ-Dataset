
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder str = new StringBuilder("");
        for (int h = 1; h <= t; h++) {
            str.append("Case #" + h + ": ");
            String s = br.readLine();
            StringBuilder ans = new StringBuilder();
            int end = 0;
            for(int i=0;i<s.length();i++){
                int val = s.charAt(i)-'0';
                if(end == 0 && val >0){
                    end = val;
                    while(val-->0){
                        ans.append("(");
                    }
                    ans.append(s.charAt(i));
                }else if (end<val){
                    int k = val-end;
                    while(k-->0){
                        ans.append("(");
                        end++;
                    }
                    ans.append(s.charAt(i));
                } else if(end>=val){
                    int k = end-val;
                    while(k-->0){
                        ans.append(")");
                        end--;
                    }
                    ans.append(s.charAt(i));
                }
                if(i==s.length()-1) {
                    while (end-- > 0) {
                        ans.append(")");
                    }
                }
            }
            str.append(ans+"\n");
        }
        out.print(str);
        out.flush();
        br.close();
    }
}
