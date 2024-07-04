import java.util.*;

public class Solution {
    Scanner scanner = new Scanner(System.in);
    int xP;
    int yP;
    int x;
    int y;
    ArrayList<String> moves;
    ArrayList<String> sol;
    boolean done;

    private void exe() {
        int test = scanner.nextInt();
        for (int z = 0; z < test; z++) {
            moves = new ArrayList<String>();
            sol = new ArrayList<String>();
            x = scanner.nextInt();
            y = scanner.nextInt();
            int xT = Math.max(x, x * -1);
            int yT = Math.max(y, y * -1);
            xP = 0;
            yP = 0;
            if ((xT%2 == 1 && yT%2 == 1) || (xT%2 == 0 && yT%2 == 0)) {
                int a = z + 1;
                System.out.println("Case #" + a + ": IMPOSSIBLE");
            } else {
                done = false;
                int a = z + 1;
                System.out.print("Case #" + a + ": ");
                //System.out.print("We start with x = " + x + " and y = " + y);
                if (xT%2 == 1) {
                    xP += 1;
                    moves.add("E");
                    done = rec(1, 1);
                    moves.remove(0);
                    xP -= 1;
                    if (!done) {
                        xP -= 1;
                        moves.add("W");
                        done = rec(1, 1);
                        moves.remove(0);
                        xP += 1;
                    }
                }
                if (yT%2 == 1 && !done) {
                    yP += 1;
                    moves.add("N");
                    done = rec(1, 1);
                    moves.remove(0);
                    yP -= 1;
                    if (!done) {
                        yP -= 1;
                        moves.add("S");
                        done = rec(1, 1);
                        moves.remove(0);
                        yP += 1;
                    }
                }
            }
            for (String s : sol) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private boolean rec(int jump, int i) {
        int j = jump * 2;
        if (/*(jump > x - xP || jump > y - yP)*/ jump > 128 && (xP != x || yP != y)) {
            return false;
        }
        boolean check = false;
        //System.out.println("x was " + xP + " and y was " + yP + " and first move is " + moves.get(0));
        if (xP != x || yP != y) {
            if (x != xP) {
                xP += j;
                moves.add("E");
                check = rec(j, i + 1);
                xP -= j;
                moves.remove(i);
            }
            if (/*!check*/true) {
                if (x != xP) {
                    xP -= j;
                    moves.add("W");
                    check = rec(j, i + 1);
                    xP += j;
                    moves.remove(i);
                }
                if (/*!check*/true) {
                    if (y != yP) {
                        yP += j;
                        moves.add("N");
                        check = rec(j, i + 1);
                        yP -= j;
                        moves.remove(i);
                    }
                    if (/*!check*/true) {
                        if (y != yP) {
                            yP -= j;
                            moves.add("S");
                            check = rec(j, i + 1);
                            yP += j;
                            moves.remove(i);
                        }
                        if (/*!check*/true) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } else {
            //System.out.print("I was here! With x = " + x + " y = " + y);
            if (sol.size() > moves.size() || sol.size() == 0) {
                //System.out.println("I was here!");
                sol = new ArrayList<String>();
                sol.addAll(moves);
            }
            return true;
            /*
            for (String s : moves) {
                System.out.print(s);
            }
            return true;
            */
        }
    }

    public static void main(String[] args) {
        Solution prob = new Solution();
        prob.exe();
    }
}
