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
        StringBuilder str = new StringBuilder();

        for (int h = 1; h <= t; h++) {
            str.append("Case #").append(h).append(": ");
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            long d = Long.parseLong(in[1]);

            long[] arr = Arrays.stream(br.readLine().split(" "))
                               .mapToLong(Long::parseLong)
                               .toArray();
            Set<Long> uniqueElements = new HashSet<>();
            for (long num : arr) {
                uniqueElements.add(num);
            }
            Arrays.sort(arr);

            long ans = d - 1;
            for (long hl : uniqueElements) {
                long count = 0;
                long currSlice = 0;
                long greater = 0;

                for (long num : arr) {
                    if (num == hl) {
                        currSlice++;
                    } else if (num % hl == 0) {
                        long b = num / hl;
                        if (currSlice + b >= d) {
                            count += Math.min(d - currSlice, b - 1);
                            currSlice = d;
                        } else {
                            currSlice += b;
                            count += (b - 1);
                        }
                    } else if (num > hl) {
                        greater++;
                    }
                    if (currSlice >= d) {
                        break;
                    }
                }
                if (currSlice >= d) {
                    ans = Math.min(count, ans);
                } else if (greater + currSlice >= d) {
                    ans = Math.min(ans, d - currSlice);
                }
            }
            str.append(ans).append("\n");
        }
        out.print(str);
        out.flush();
        br.close();
    }

    public static int getValue(int[] arr, int N, int X, int d) {
        int cost = 0;
        int slice = 0;
        for (int i = 0; i < N; i++) {
            // Implement the logic if needed
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

    private static void addDivisor(long a, Map<Integer, List<Long>> s) {
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                List<Long> k = s.getOrDefault(i, new ArrayList<>());
                k.add(a);
                s.put(i, k);

                int h = (int) (a / i);
                if (h != i) {
                    k = s.getOrDefault(h, new ArrayList<>());
                    k.add(a);
                    s.put(h, k);
                }
            }
        }
    }
}