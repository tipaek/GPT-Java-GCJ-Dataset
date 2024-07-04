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
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(myReader.nextLine());
        Character[] res = new Character[10];
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < T; i++) {
            int u = myReader.nextInt();
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(o -> o.num));

            for (int j = 0; j < 10000; j++) {
                pq.add(new Pair(myReader.nextLong(), myReader.next().replaceAll("\\s+", "")));
            }

            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                if (pair.num / 10 == 0 && res[Math.toIntExact(pair.num)] != null) continue;
                if (pair.num == 1) {
                    res[1] = pair.val.charAt(0);
                    charSet.add(pair.val.charAt(0));
                } else if (pair.num / 10 == 0 && notEqualToOthers(res, pair.val, pair.num)) {
                    res[Math.toIntExact(pair.num)] = pair.val.charAt(0);
                    charSet.add(pair.val.charAt(0));
                } else {
                    for (char c : pair.val.toCharArray()) {
                        if (!charSet.contains(c)) {
                            res[0] = c;
                            break;
                        }
                    }
                }
            }

            StringBuilder r = new StringBuilder();
            for (Character character : res) {
                r.append(character);
            }
            System.out.println("Case #" + (i + 1) + ": " + r);
        }
        myReader.close();
    }

    private static boolean notEqualToOthers(Character[] res, String val, Long num) {
        for (int i = 0; i < num; i++) {
            if (res[i] != null && val.charAt(0) == res[i]) {
                return false;
            }
        }
        return true;
    }
}