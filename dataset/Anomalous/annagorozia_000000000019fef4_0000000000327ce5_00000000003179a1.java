package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Pair {
        Long num;
        String val;

        public Pair(Long num, String val) {
            this.num = num;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(o -> o.num));
            Character[] result = new Character[10];
            Set<Character> charSet = new HashSet<>();
            int u = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            for (int j = 0; j < 10000; j++) {
                pq.add(new Pair(scanner.nextLong(), scanner.nextLine().trim()));
            }

            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                if (pair.num < 10 && result[Math.toIntExact(pair.num)] != null) continue;

                if (pair.num == 1) {
                    result[1] = pair.val.charAt(0);
                    charSet.add(pair.val.charAt(0));
                    continue;
                }

                if (pair.num < 10 && isUnique(result, pair.val, pair.num)) {
                    charSet.add(pair.val.charAt(0));
                    result[Math.toIntExact(pair.num)] = pair.val.charAt(0);
                    continue;
                }

                for (char c : pair.val.toCharArray()) {
                    if (!charSet.contains(c) && charSet.size() == 9) {
                        result[0] = c;
                        charSet.add(c);
                        break;
                    }
                }

                if (charSet.size() == 10) break;
            }

            StringBuilder r = new StringBuilder();
            for (Character ch : result) {
                r.append(ch);
            }
            System.out.println("Case #" + (i + 1) + ": " + r);
        }

        scanner.close();
    }

    private static boolean isUnique(Character[] result, String val, Long num) {
        for (int i = 0; i < num; i++) {
            if (result[i] != null && val.charAt(0) == result[i]) {
                return false;
            }
        }
        return true;
    }
}