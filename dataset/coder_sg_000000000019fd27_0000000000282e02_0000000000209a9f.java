import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

        public static void main( String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int tC = 1; tC <= t; tC++) {
                String s = br.readLine();
                StringBuilder result = new StringBuilder();
                
                int depth = 0;

                for(char c : s.toCharArray()) {
                    int digit = c-'0';

                    if(depth == digit) 
                        result.append(c);
                    else if(depth < digit) {
                        int diff = digit - depth;
                        while(diff-- > 0) {
                            result.append('(');
                            depth++;
                        }
                        result.append(c);
                    }
                    else {
                        int diff = depth - digit;
                        while(diff-- > 0) {
                            result.append(')');
                            depth--;
                        }
                        result.append(c);
                    }
                }

                while(depth-- > 0)
                    result.append(')');
                    
                sb.append("Case #"+tC+": "+result+"\n");
            }
            System.out.println(sb);
    } 
}