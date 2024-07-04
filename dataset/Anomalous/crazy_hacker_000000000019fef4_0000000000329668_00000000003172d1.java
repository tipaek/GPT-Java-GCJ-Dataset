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

            String[] numbers = br.readLine().split(" ");
            long[] arr = new long[n];
            Set<Long> uniqueNumbers = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(numbers[i]);
                uniqueNumbers.add(arr[i]);
            }

            Arrays.sort(arr);
            long minOperations = d - 1;

            for (long hl : uniqueNumbers) {
                long count = 0;
                long currentSlice = 0;
                long greaterCount = 0;

                for (long value : arr) {
                    if (value == hl) {
                        currentSlice++;
                    } else if (value % hl == 0) {
                        long b = value / hl;
                        if (currentSlice + b >= d) {
                            count += Math.min(d - currentSlice, b - 1);
                            currentSlice = d;
                        } else {
                            currentSlice += b;
                            count += (b - 1);
                        }
                    } else if (value > hl) {
                        greaterCount += (value / hl);
                    }

                    if (currentSlice >= d) {
                        break;
                    }
                }

                if (currentSlice >= d) {
                    minOperations = Math.min(count, minOperations);
                } else if (greaterCount + currentSlice >= d) {
                    minOperations = Math.min(minOperations, count + d - currentSlice);
                }
            }

            result.append(minOperations).append("\n");
        }

        out.print(result);
        out.flush();
        br.close();
    }
}