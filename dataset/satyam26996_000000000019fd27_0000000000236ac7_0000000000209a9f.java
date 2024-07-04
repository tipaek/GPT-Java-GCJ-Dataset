import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        int N;
        for (int i = 1; i <= T; i++) {
            String input = fr.nextLine();
            char []inputArray = input.toCharArray();
            solve(inputArray,i);
        }
    }
    public static void solve(char []input,int T){
        StringBuilder output=new StringBuilder();
        int leftBracket=0;
        int cur=0,prev=0;
        for (int i = 0; i < input.length; i++) {
            cur=Integer.parseInt(input[i]+"");
            if(i==0){
                prev=cur;
                addBracketLeft(output,cur);
                output.append(prev);
                leftBracket=prev;
            } /*else if(i==input.length-1){
                output.append(cur);
                addBracketRight(output,leftBracket);
            }*/ else{
                if(prev==cur){
                    output.append(prev);
                    prev=cur;
                } else if(prev>cur){
                    int diff = prev-cur;
                    addBracketRight(output,diff);
                    leftBracket-=diff;
                    output.append(cur);
                    prev=cur;
                } else{
                    int diff = cur-prev;
                    addBracketLeft(output,diff);
                    leftBracket+=diff;
                    output.append(cur);
                    prev=cur;
                }
            }
        }
        addBracketRight(output,leftBracket);
        System.out.println("Case #"+T+": "+output);
    }
    static void addBracketLeft(StringBuilder str,int n){
        for (int i = 0; i < n; i++) {
            str.append("(");
        }
    }
    static void addBracketRight(StringBuilder str,int n){
        for (int i = 0; i < n; i++) {
            str.append(")");
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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
}
