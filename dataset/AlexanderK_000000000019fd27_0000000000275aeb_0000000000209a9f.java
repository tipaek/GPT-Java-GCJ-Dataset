import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexk
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            process(r);
        }
    }
    
    private static class Input {
        String s;

        public Input(BufferedReader r) throws IOException {
            s = r.readLine();
        }
    }
    
    private static class Output {
        String s;

        public Output(String s) {
            this.s = s;
        }
        
        @Override
        public String toString() {
            return s;
        }
    }
    
    public static void process(BufferedReader r) throws IOException {
        int c = Integer.parseInt(r.readLine());
        for (int i = 0; i < c; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new Input(r)));
        }
    }
    
    static Output solve(Input in) {
        String s = in.s;
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()) {
            int d = c - '0';
            while (level < d) {
                level++;
                sb.append("(");
            }
            while (level > d) {
                level--;
                sb.append(")");
            }
            sb.append(c);
        }
        while (level > 0) {
            level--;
            sb.append(")");
        }
        return new Output(sb.toString());
    }
    
}
