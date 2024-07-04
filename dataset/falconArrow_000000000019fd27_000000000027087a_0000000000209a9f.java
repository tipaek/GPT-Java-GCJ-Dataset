import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Collections;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author falconArrow
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NDepth solver = new NDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class NDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for(int i=0;i<t;i++){
                String str=in.next();
                int brackets=0;
                String res="";
                for(int j=0;j<str.length();j++){
                    int val=str.charAt(j)-48;
                    if(val==brackets){
                        res+=str.charAt(j);    
                    }else if(val>brackets){
                        int differ=val-brackets;
                        res+=addOpenBrackets(differ);
                        res+=str.charAt(j);
                        brackets+=differ;
                    }else{
                        int differ=brackets-val;
                        res+=addCloseBrackets(differ);
                        res+=str.charAt(j);
                        brackets-=differ;
                    }
                }
                if(brackets>0)res+=addCloseBrackets(brackets);
                out.println("Case #"+(i+1)+": "+res);
            }
        }

        String addOpenBrackets(int n){
            return String.join("", Collections.nCopies(n, "("));
        }
        String addCloseBrackets(int n){
            return String.join("", Collections.nCopies(n, ")"));
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}