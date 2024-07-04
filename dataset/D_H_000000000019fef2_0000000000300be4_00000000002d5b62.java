import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static Set<Pos> posSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num_case = scanner.nextInt();
        for (int testcase = 1; testcase <= num_case; testcase++) {
            posSet = new HashSet<>();
            int xTarget = scanner.nextInt();
            int yTarget = scanner.nextInt();
            int jump = 1;
//            String ans = findAns(0, 0, 1, x, y, "");
//            if (ans == null) {
//                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
//            } else {
//                System.out.println("Case #" + testcase + ": " + ans);
//            }

            List<Loc> locList = new ArrayList<>();
            locList.add(new Loc(new Pos(0, 0), ""));
            boolean hasAns = false;
            while ((jump - Math.abs(xTarget)) < Math.abs(yTarget)) {
                List<Loc> newLocList = new ArrayList<>();
                for (Loc loc : locList) {
//                    System.out.println(loc.pos.x + " " + loc.pos.y);
                    if (!posSet.contains(loc.pos)) {
                        int x = loc.pos.x;
                        int y = loc.pos.y;
                        String steps = loc.step;
                        String ans = null;
                        if (x - jump == xTarget && y == yTarget) {
                            ans = steps + "W";

                        }
                        if (x == xTarget - jump && y == yTarget) {
                            ans = steps + "E";

                        }
                        if (x == xTarget && y - jump == yTarget) {
                            ans = steps + "S";

                        }
                        if (x == xTarget && y == yTarget - jump) {
                            ans = steps + "N";

                        }
                        posSet.add(loc.pos);

                        if (ans != null) {
                            hasAns = true;
                            System.out.println("Case #" + testcase + ": " + ans);
                            break;
                        } else {
                            if (!posSet.contains(new Pos(x - jump, y))) {
                                newLocList.add(new Loc(new Pos(x - jump, y), steps + "W"));
                            }
                            if (!posSet.contains(new Pos(x + jump, y))) {
                                newLocList.add(new Loc(new Pos(x + jump, y), steps + "E"));
                            }
                            if (!posSet.contains(new Pos(x, y - jump))) {
                                newLocList.add(new Loc(new Pos(x, y - jump), steps + "S"));
                            }
                            if (!posSet.contains(new Pos(x, y + jump))) {
                                newLocList.add(new Loc(new Pos(x, y + jump), steps + "N"));
                            }
                        }
                    }
                }
                locList = newLocList;
                jump *= 2;
            }
            if (!hasAns) {
                System.out.println("Case #" + testcase + ": IMPOSSIBLE");
            }
        }
    }

//    static String check(Loc loc, int jump, int xTarget, int yTarget) {
//        if (posSet.contains(loc.pos)) return null;
//        int x = loc.pos.x;
//        int y = loc.pos.y;
//        String steps = loc.step;
//        if (x - jump == xTarget && y == yTarget) {
//            return steps + "W";
//        }
//        if (x == xTarget - jump && y == yTarget) {
//            return steps + "E";
//        }
//        if (x == xTarget && y - jump == yTarget) {
//            return steps + "S";
//        }
//        if (x == xTarget && y == yTarget - jump) {
//            return steps + "N";
//        }
//        posSet.add(loc.pos);
//        return null;
//    }
//
//    static String findAns(int x, int y, int jump, int xTarget, int yTarget, String steps) {
//
//
//        if (x == xTarget && y == yTarget) {
//            return steps;
//        }
//        if (Math.abs(xTarget) < (jump - Math.abs(yTarget))) {
//            return null;
//        }
//
//        int shortest = Integer.MAX_VALUE;
//        String shortestAns = null;
//        String ans = findAns(x - jump, y, jump * 2, xTarget, yTarget, steps + "W");
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }
//        ans = findAns(x + jump, y, jump * 2, xTarget, yTarget, steps + "E");
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }
//        ans = findAns(x, y - jump, jump * 2, xTarget, yTarget, steps + "S");
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }
//        ans = findAns(x, y + jump, jump * 2, xTarget, yTarget, steps + "N");
//        if (ans != null && ans.length() < shortest) {
//            shortest = ans.length();
//            shortestAns = ans;
//        }
//
//        return shortestAns;
//    }


}

class Loc {
    Pos pos;
    String step;
    public Loc(Pos pos, String step) {
        this.pos = pos;
        this.step = step;
    }
}

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
