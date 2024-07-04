import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static void addParens(StringBuilder result, int diff) {
        if (diff == 0) return;
        char parenChar = '(';
        if (diff < 0) {
            parenChar = ')';
            diff *= -1;
        }
        for (int i = 0; i < diff; i++) {
            result.append(parenChar);
        }        
    }

    private static String makeNestString(String nestCase) {
        int n = nestCase.length();
        StringBuilder result = new StringBuilder();

        int[] diffs = new int[n+1];
        diffs[0] = nestCase.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            diffs[i] = nestCase.charAt(i) - nestCase.charAt(i-1);    
        }
        diffs[n] = '0' - nestCase.charAt(n-1);
        
        for (int i = 0; i < n; i++) {
            addParens(result,diffs[i]);
            result.append(nestCase.charAt(i));
        }
        addParens(result,diffs[n]);
        return result.toString();  
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            
            String nestCase = scanner.next();
            String result = makeNestString(nestCase);
            System.out.println("Case #" + (k+1) + ": " + result); 
        }
                
    }
        static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }

}
