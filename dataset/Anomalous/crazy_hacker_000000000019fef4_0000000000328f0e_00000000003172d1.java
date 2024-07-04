import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int h = 1; h <= t; h++) {
            result.append("Case #").append(h).append(": ");
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            long d = Long.parseLong(input[1]);
            String[] arrStr = br.readLine().split(" ");
            long[] arr = new long[n];
            Set<Long> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(arrStr[i]);
                set.add(arr[i]);
            }

            Arrays.sort(arr);
            long minOperations = d - 1;

            for (long hl : set) {
                long count = 0;
                long currSlice = 0;
                long greaterCount = 0;

                for (long value : arr) {
                    if (value == hl) {
                        currSlice++;
                    } else if (value % hl == 0) {
                        long quotient = value / hl;
                        if (currSlice + quotient >= d) {
                            count += Math.min(d - currSlice, quotient - 1);
                            currSlice = d;
                        } else {
                            currSlice += quotient;
                            count += quotient - 1;
                        }
                    } else if (value > hl) {
                        greaterCount++;
                    }

                    if (currSlice >= d) {
                        break;
                    }
                }

                if (currSlice >= d) {
                    minOperations = Math.min(count, minOperations);
                } else if (greaterCount + currSlice >= d) {
                    minOperations = Math.min(minOperations, count + d - currSlice);
                }
            }

            result.append(minOperations).append("\n");
        }

        out.print(result);
        out.flush();
        br.close();
    }
}