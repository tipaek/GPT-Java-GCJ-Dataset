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

            Map<Integer, List<Long>> divisorMap = new HashMap<>();
            input = br.readLine().split(" ");
            long[] arr = new long[n];
            Set<Long> uniqueValues = new HashSet<>();

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(input[i]);
                uniqueValues.add(arr[i]);
            }

            Arrays.sort(arr);
            long minOperations = d - 1;

            for (long value : uniqueValues) {
                long operations = 0;
                long currentSlice = 0;

                for (long num : arr) {
                    if (num == value) {
                        currentSlice++;
                    } else if (num > value) {
                        long quotient = num / value;
                        if (currentSlice + quotient >= d) {
                            operations += (num % value != 0) ? (d - currentSlice) : Math.min(d - currentSlice, quotient - 1);
                            currentSlice = d;
                        } else {
                            currentSlice += quotient;
                            operations += quotient - 1;
                        }
                    }
                    if (currentSlice >= d) {
                        break;
                    }
                }

                if (currentSlice >= d) {
                    minOperations = Math.min(operations, minOperations);
                }
            }
            result.append(minOperations).append("\n");
        }

        out.print(result);
        out.flush();
        br.close();
    }

    public static int getValue(int[] arr, int N, int X, int d) {
        int cost = 0;
        int slice = 0;
        for (int i = 0; i < N; i++) {
            // Placeholder for potential future logic
        }
        return cost;
    }

    public static int getAns(int[] arr, int N, int d) {
        int low = arr[N - 1];
        int high = arr[N - 1];

        while ((high - low) > 2) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int cost1 = getValue(arr, N, mid1, d);
            int cost2 = getValue(arr, N, mid2, d);

            if (cost1 < cost2) {
                high = mid2;
            } else {
                low = mid1;
            }
        }
        return getValue(arr, N, (low + high) / 2, d);
    }

    private static void addDivisor(long a, Map<Integer, List<Long>> divisorMap) {
        for (int i = 1; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0) {
                divisorMap.computeIfAbsent(i, k -> new ArrayList<>()).add(a);
                int quotient = (int) (a / i);
                if (quotient != i) {
                    divisorMap.computeIfAbsent(quotient, k -> new ArrayList<>()).add(a);
                }
            }
        }
    }
}