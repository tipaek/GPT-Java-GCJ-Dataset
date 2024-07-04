import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int testCaseCount = Integer.parseInt(input.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            out.print("Case #" + testCase + ": ");
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());
            int D = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(input.readLine());
            Map<Long, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                long num = Long.parseLong(tokenizer.nextToken());
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }

            int minimumCuts = D - 1;

            for (long key : frequencyMap.keySet()) {
                int count = frequencyMap.get(key);
                int cuts = 0;

                if (count >= D) {
                    minimumCuts = Math.min(minimumCuts, cuts);
                    continue;
                }

                TreeSet<Long> multiples = new TreeSet<>();
                TreeSet<Long> others = new TreeSet<>();

                for (long otherKey : frequencyMap.keySet()) {
                    if (otherKey > key) {
                        if (otherKey % key == 0) {
                            multiples.add(otherKey);
                        } else {
                            others.add(otherKey);
                        }
                    }
                }

                for (long multiple : multiples) {
                    long temp = multiple;
                    while (temp > key) {
                        if (temp == key * 2) {
                            count += 2;
                        } else {
                            count++;
                        }
                        cuts++;
                        temp -= key;

                        if (count >= D) {
                            minimumCuts = Math.min(minimumCuts, cuts);
                            break;
                        }
                    }
                }

                for (long other : others) {
                    long temp = other;
                    while (temp > key) {
                        count++;
                        cuts++;
                        temp -= key;

                        if (count >= D) {
                            minimumCuts = Math.min(minimumCuts, cuts);
                            break;
                        }
                    }
                }
            }

            out.println(minimumCuts);
        }

        out.flush();
        out.close();
    }
}