import java.util.*;

public class Solution {

    Scanner scan = new Scanner(System.in);
//    1 1
//            2 1
//            2 2
//            3 3
//            4 4
//            5 4
//            6 4

    int[][] pascal = {
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1},
            {1, 5, 10, 10, 5, 1},
            {1, 6, 15, 20, 15, 6, 1},
            {1, 7, 21, 35, 35, 21, 7, 1},
            {1, 8, 28, 56, 70, 56, 28, 8, 1},
            {1, 9, 36, 84, 126, 126, 84, 36, 9, 1},
            {1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1},
            {1, 11, 55, 165, 330, 462, 462, 330, 165, 55, 11, 1},
            {1, 12, 66, 220, 495, 792, 924, 792, 495, 220, 66, 12, 1},
            {1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1},
            {1, 14, 91, 364, 1001, 2002, 3003, 3432, 3003, 2002, 1001, 364, 91, 14, 1},
            {1, 15, 105, 455, 1365, 3003, 5005, 6435, 6435, 5005, 3003, 1365, 455, 105, 15, 1},
            {1, 16, 120, 560, 1820, 4368, 8008, 11440, 12870, 11440, 8008, 4368, 1820, 560, 120, 16, 1},
            {1, 17, 136, 680, 2380, 6188, 12376, 19448, 24310, 24310, 19448, 12376, 6188, 2380, 680, 136, 17, 1},
            {1, 18, 153, 816, 3060, 8568, 18564, 31824, 43758, 48620, 43758, 31824, 18564, 8568, 3060, 816, 153, 18, 1},
            {1, 19, 171, 969, 3876, 11628, 27132, 50388, 75582, 92378, 92378, 75582, 50388, 27132, 11628, 3876, 969, 171, 19, 1},
            {1, 20, 190, 1140, 4845, 15504, 38760, 77520, 125970, 167960, 184756, 167960, 125970, 77520, 38760, 15504, 4845, 1140, 190, 20, 1},
    };

    Set<String> pascalSet = new HashSet<>();


    public static void main(String[] args) {
        new Solution().start();
    }

    void start() {
        for (int r = 0; r < pascal.length; r++) {
            for (int c = 0; c < pascal[r].length; c++) {
                pascalSet.add((r + 1) + " " + (c + 1));
            }
        }
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            List<String> ans = getAnswer();
            System.out.println("Case #" + (i + 1) + ":");
            for (String s : ans) {
                System.out.println(s);
            }
        }
    }

    class Possibility {
        int r, c, n;
        Set<String> seen;
        List<String> visited;

        Possibility(int n, int r, int c, Set<String> seen, List<String> visited) {
            this.n = n - getVal(r, c);
            this.r = r;
            this.c = c;
            this.seen = seen;
            this.visited = visited;
            seen.add(getRC());
            visited.add(getRC());
        }

        String getRC() {
            return r + " " + c;
        }

    }

    void check(int r, int c, Queue<Possibility> ps, Possibility p) {
        String s = getRC(r, c);
        if (pascalSet.contains(s) && !p.visited.contains(s)) {
            List<String> curr = new ArrayList<>(p.visited);
            Set<String> seen2 = new HashSet<>(p.seen);
            ps.add(new Possibility(p.n, r, c, seen2, curr));
        }
    }

    List<String> getAnswer() {
        int n = scan.nextInt();
        Queue<Possibility> possibilities = new ArrayDeque<>();
        possibilities.add(new Possibility(n, 1, 1, new HashSet<>(), new ArrayList<>()));

        while (!possibilities.isEmpty()) {
            Possibility p = possibilities.poll();
            if (p.n == 0) {
                return p.visited;
            }
            if (p.n < 0) {
                continue;
            }
            int r = p.r;
            int c = p.c;
            check(r - 1, c, possibilities, p);
            check(r - 1, c - 1, possibilities, p);
            check(r, c - 1, possibilities, p);
            check(r, c + 1, possibilities, p);
            check(r + 1, c, possibilities, p);
            check(r + 1, c + 1, possibilities, p);
        }
        return null;
    }

    int getVal(int r, int c) {
        return pascal[r - 1][c - 1];
    }

    String getRC(int r, int c) {
        return r + " " + c;
    }


}
