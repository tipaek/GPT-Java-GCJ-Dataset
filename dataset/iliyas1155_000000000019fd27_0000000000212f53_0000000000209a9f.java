import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for(int testCase=1; testCase<=cases; testCase++) {
            String line = scanner.next();
            String res = calc(line);
            System.out.println("Case #" + testCase + ": " + res);
        }
    }

    static String calc(String base) {
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for(int i=0; i<base.length(); i++) {
            int num = Integer.parseInt(base.charAt(i)+"");
            while(opened > num) {
                sb.append(')');
                opened--;
            }
            while(opened < num) {
                sb.append('(');
                opened++;
            }
            sb.append(num);
        }
        while(opened > 0) {
            sb.append(')');
            opened--;
        }
        return sb.toString();
    }
}
