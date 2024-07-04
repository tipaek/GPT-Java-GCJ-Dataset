import java.util.*;

public class Solution {

    Scanner scan = new Scanner(System.in);

    int[][] pascal = {
            {1},
            {1,1},
            {1,2,1},
            {1,3,3,1},
            {1,4,6,4,1},
            {1,5,10,10,5,1},
            {1,6,15,20,15,6,1},
            {1,7,21,35,35,21,7,1},
            {1,8,28,56,70,56,28,8,1},
            {1,9,36,84,126,126,84,36,9,1},
            {1,10,45,120,210,252,210,120,45,10,1},
            {1,11,55,165,330,462,262,330,165,55,11,1},
            {1,12,66,220,495,792,924,792,495,220,66,12,1},
            {1,13,78,186,715,1287,1716,1716,1287,715,186,78,13,1},
    };

    Set<String> pascalSet = new HashSet<>();


    public static void main(String[] args) {
        new Solution().start();
    }

    void start() {
        for (int r = 0; r < pascal.length; r++) {
            for (int c = 0; c < pascal[r].length; c++) {
                pascalSet.add((r+1) + " " + (c+1));
            }
        }
        int cases = scan.nextInt();
        for (int i = 0; i < cases; i++) {
            List<String> ans = getAnswer();
            System.out.println("Case #" + (i+1) +":");
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
            String topright = getRC(r - 1, c);
            String topleft = getRC(r - 1, c - 1);
            String left = getRC(r, c - 1);
            String right = getRC(r, c + 1);
            String botleft = getRC(r + 1, c);
            String botright = getRC(r + 1, c + 1);
            List<String> all = new ArrayList<>();
            all.add(topright);
                all.add(topleft);
            all.  add(left);
            all.  add(right);
            all.  add(botleft);
            all.  add(botright);

            for (String s : all) {
                if (pascalSet.contains(s) && !p.visited.contains(s)) {
                    String[] sp = s.split(" ");
                    List<String> curr = new ArrayList<>(p.visited);
                    Set<String> seen2 = new HashSet<>(p.seen);
                    possibilities.add(new Possibility(p.n, Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), seen2, curr));
                }
            }
        }
        return null;



        //return walk(n, 1, 1, new ArrayList<>(), new HashSet<>());
   }

   int getVal(int r, int c) {
        return pascal[r-1][c-1];
   }

   String getRC(int r, int c) {
        return r + " " + c;
   }


//   List<String> walk(int r, int c, int n, List<String> current, Set<String> seen) {
//        String rc = getRC(r, c);
//        n -= getVal(r, c);
//        current.add(rc);
//        seen.add(rc);
//        if (n == 0) {
//            return current;
//        }
//        if (n > 0) {
//            // keep going
//            String topright = getRC(r-1,c+1);
//            String topleft = getRC(r-1, c-1);
//            String left = getRC(r, c-1);
//            String right = getRC(r, c+1);
//            String botleft = getRC(r+1, c-1);
//            String botright = getRC(r+1, c+1);
//            List<String> all = new ArrayList<>() {{
//                add(topright);
//                add(topleft);
//                add(left);
//                add(right);
//                add(botleft);
//                add(botright);
//            }};
//            for (String s : all) {
//                if (pascalSet.contains(s)) {
//                    String[] sp = s.split(" ");
//                    List<String> curr = new ArrayList<>(current);
//                    Set<String> seen2 = new HashSet<>(seen);
//                    List<String> res = walk(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), n, curr, seen2);
//                    if (res != null) {
//                        return res;
//                    }
//                }
//            }
//        }
//        return null;
//   }

}
