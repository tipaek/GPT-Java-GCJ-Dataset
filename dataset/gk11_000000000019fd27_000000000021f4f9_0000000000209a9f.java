import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t=1; t<=T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        String l = scanner.nextLine();
        int depth =0;
        StringBuilder s = new StringBuilder();
        for (char c : l.toCharArray()) {
            int v = c-'0';
            for (int i=depth;i<v;i++){
                s.append('(');
                depth++;
            }
            for (int i=depth;i>v;i--) {
                s.append(')');
                depth--;
            }
            s.append(c);
        }
        for (int i=depth; i>0; i--) {
            s.append(')');
        }
        System.out.println("Case #"+t+": "+s);
    }
}
