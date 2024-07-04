import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = in.readLine().split(" ");
            int tests = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            for (int test = 0; test < tests; test++) {
                int[] bits = new int[n];
                int index = 0;
                int stablePair = -1;
                int unstablePair = -1;
                int stableSign = 0;
                int unstableSign = 0;

                while (index < n/2) {
                    int runs = 5;
                    if (unstablePair != -1 || stablePair != -1) {
                        runs--;
                        if (stablePair != -1) {
                            System.out.println(stablePair + 1);
                            System.out.flush();
                            int x = Integer.parseInt(in.readLine());
                            if (x != stableSign) {
                                for (int i = 0; i < bits.length; i++) {
                                    bits[i] = 1-bits[i];
                                }
                                stableSign = x;
                                unstableSign = 1 - unstableSign;
                            }
                        }
                        if (unstablePair != -1)  {
                            System.out.println(unstablePair + 1);
                            System.out.flush();
                            int x = Integer.parseInt(in.readLine());
                            if (x != unstableSign) {
                                for (int i = 0; i < bits.length; i++) {
                                    if (bits[i] != bits[n-i-1])
                                        bits[i] = 1-bits[i];
                                }
                                unstableSign = x;
                            }
                        }
                        if (unstablePair == -1 || stablePair == -1) {
                            System.out.println(stablePair + 1);
                            System.out.flush();
                            in.readLine();
                        }
                    }
                    for (int i = 0; i < runs; i++) {
                        System.out.println(index + 1);
                        System.out.flush();
                        int x = Integer.parseInt(in.readLine());
                        System.out.println(n - index);
                        System.out.flush();
                        int y = Integer.parseInt(in.readLine());
                        if (x == y && stablePair == -1) {
                            stablePair = index;
                            stableSign = x;
                        }
                        else if (x != y && unstablePair == -1) {
                            unstablePair = index;
                            unstableSign = y;
                        }
                        bits[index] = x;
                        bits[n - 1 - index] = y;
                        index++;
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (int bit : bits) {
                    sb.append(bit);
                }
                System.out.println(sb);
                String status = in.readLine();
                if (status.equals("N")) {
                    System.exit(0);
                }
            }
        }
    }
}