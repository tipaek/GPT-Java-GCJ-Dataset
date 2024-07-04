import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author daksh
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buff.readLine());
        int tnum = 1;
        while (t-- > 0) {
            String s = buff.readLine().trim();
            StringBuilder sb = new StringBuilder();

            int start = Integer.parseInt("" + s.charAt(0));
            int temp = start;
            while (start-- > 0) {
                sb.append("(");
            }
            sb.append(temp);
            for (int i = 1; i < s.length(); i++) {
                int previous = Integer.parseInt("" + s.charAt(i - 1));
                int current = Integer.parseInt("" + s.charAt(i));

                if (previous == current) {
                    sb.append(current);
                } else if (previous > current) {
                    int d = previous - current;
                    while (d-- > 0) {
                        sb.append(")");
                    }
                    sb.append(current);
                } else {
                    int d = current - previous;
                    while (d-- > 0) {
                        sb.append("(");
                    }
                    sb.append(current);
                }   
            }
            int last = Integer.parseInt("" + s.charAt(s.length()-1));
            while(last-- > 0){
                sb.append(")");
            }
            
            System.out.println("Case #" + tnum + ":" + " " + sb.toString());
            tnum++;
        }
    }
}
