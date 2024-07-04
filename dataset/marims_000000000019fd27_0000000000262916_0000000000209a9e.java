import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        int B = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            int bits[] = new int[B];

            int fluctuations = 0;
            while(true) {
                for (int i = 0; i < 10; i += 2) {
                    int index = fluctuations * 10 + i;

                    System.out.println(index + 1);
                    bits[i] = sc.nextInt();

                    System.out.println(B - index);
                    bits[B - index - 1] = sc.nextInt();
                }
                fluctuations++;
                if (fluctuations * 10 >= B) {
                    break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bits.length; i++) {
                sb.append(bits[i]);
            }

            System.out.println(sb.toString());
            String ans = sc.next();
            if (ans.equals("Y")) {
                continue;
            } else {
                break;
            }
        }
    }
}