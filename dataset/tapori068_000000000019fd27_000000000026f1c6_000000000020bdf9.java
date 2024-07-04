import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        int MAX_LENGTH = 24*60;
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            String camString = repeat('-', MAX_LENGTH);
            String jamString = repeat('-', MAX_LENGTH);
            StringBuffer result = new StringBuffer();
            boolean impossible = false;
            for(int j = 0; j < N; j++)
            {
                int start = in.nextInt();
                int end = in.nextInt();

                if (impossible) {
                    continue;
                }

                if (camString.substring(start, end).equals(repeat('-', end-start))) {
                    result.append('C');
                    camString = new StringBuffer(camString.substring(0, start))
                                    .append(repeat('C', end-start))
                                    .append(camString.substring(end))
                                    .toString();
                } else if (jamString.substring(start, end).equals(repeat('-', end-start))) {
                    result.append('J');
                    jamString = new StringBuffer(jamString.substring(0, start))
                                    .append(repeat('J', end-start))
                                    .append(jamString.substring(end))
                                    .toString();

                } else {
                    impossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + (impossible? "IMPOSSIBLE" : result));
        }
    }

    private static String repeat(char ch, int n) {
        StringBuffer out = new StringBuffer();
        IntStream.range(0, n).forEach(i -> out.append(ch));
        return out.toString();
    }
}
