
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.InputStreamReader;


public class Solution {

    static String nestingDepth(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                continue;
            } else {
                sb.insert(i, "(");
                i += 2;
                while (i < sb.length() && sb.charAt(i) == '1' ) {
                    i++;
                }
                sb.insert(i, ')');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int round = scanner.nextInt();
        for (int i = 0; i < round; i++) {
            String s = scanner.next();
            System.out.printf("Case #%d: %s\n", i + 1, nestingDepth(s));
        }
    }
}
