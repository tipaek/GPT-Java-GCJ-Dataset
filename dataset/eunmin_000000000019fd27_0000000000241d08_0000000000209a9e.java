import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            String buffer = "";
            int n = 1;
            for (int j = 0; j < 150; ++j) {
                if (j % b == 0) {
                    System.out.println("1");
                    String response = in.next();
                } else {
                    System.out.println(n);
                    String response = in.next();
                    buffer += response;
                    n++;
                }
                if (buffer.length() == b) {
                    System.out.println(buffer);
                    String result = in.next();
                    if (result.equals("Y")) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
        System.exit(0);
    }
}