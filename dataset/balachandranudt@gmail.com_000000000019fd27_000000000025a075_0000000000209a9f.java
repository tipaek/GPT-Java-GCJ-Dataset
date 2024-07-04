import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            char[] in = reader.readLine().toCharArray();
            final StringBuilder b = new StringBuilder();
            int last = in[0] - '0';
            for (int j = 0; j < last; j++)
                b.append('(');
            b.append(last);
            for (int j = 1; j < in.length; j++) {
                int num = in[j] - '0';
                if (num > last)
                    for (int k = 0; k < (num - last); k++)
                        b.append('(');
                else if (num < last)
                    for (int k = 0; k < (last - num); k++)
                        b.append(')');
                last = num;
                b.append(num);
            }
            for (int j = 0; j < last; j++)
                b.append(')');
            System.out.println(String.format("Case #%d: %s", (i + 1), b.toString()));
        }
    }
}
