import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int i = 0; i < numTests; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.next();
            check(i + 1, x, y, path);
        }
    }

    private static void check(int i, int x, int y, String path) {
        char[] ch = path.toCharArray();
        Set<Pair> sP = new HashSet<>();
        Pair currentPurr = new Pair(x, y, 0);
        sP.add(currentPurr);
        Pair currentMe = new Pair(0, 0, 0);
        int time = 1;
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == 'S') {
                Pair p = new Pair(currentPurr.x, currentPurr.y - 1, time);
                currentPurr = p;
                sP.add(currentPurr);
            } else if (ch[j] == 'N') {
                Pair p = new Pair(currentPurr.x, currentPurr.y + 1, time);
                currentPurr = p;
                sP.add(currentPurr);
            } else if (ch[j] == 'E') {
                Pair p = new Pair(currentPurr.x + 1, currentPurr.y, time);
                currentPurr = p;
                sP.add(currentPurr);
            } else if (ch[j] == 'W') {
                Pair p = new Pair(currentPurr.x - 1, currentPurr.y, time);
                currentPurr = p;
                sP.add(currentPurr);
            }
            time++;
        }

        for (Pair pPath : sP) {
            if (pPath.time >= Math.abs(pPath.x) + Math.abs(pPath.y)) {
                printAnsw(i, String.valueOf(pPath.time));
                return;
            }
        }

        printAnsw(i, "IMPOSSIBLE");
    }

    private static void printAnsw(int i, String res) {
        System.out.println("Case #" + i + ": " + res);
    }

    private static class Pair {
        int x;
        int y;
        int time;

        public Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y && time == pair.time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, time);
        }
    }
}
