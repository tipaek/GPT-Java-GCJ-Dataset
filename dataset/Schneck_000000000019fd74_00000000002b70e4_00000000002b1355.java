import java.io.*;
import java.util.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        int R = scan.nextInt();
        int C = scan.nextInt();
        Dancer[][] floor = new Dancer[R][C];
        List<Dancer> dancers = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            line = in.readLine();
            scan = new Scanner(line);
            for (int j = 0; j < C; j++) {
                Dancer dancer = new Dancer();
                dancer.skill = scan.nextInt();
                floor[i][j] = dancer;
                dancers.add(dancer);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i > 0) {
                    floor[i][j].upNeighbor = floor[i-1][j];
                }
                if (i < R - 1) {
                    floor[i][j].downNeighbor = floor[i+1][j];
                }
                if (j > 0) {
                    floor[i][j].leftNeighbor = floor[i][j-1];
                }
                if (j < C - 1) {
                    floor[i][j].rightNeighbor = floor[i][j+1];
                }
            }
        }
        for (Dancer dancer : dancers) {
            dancer.newUpNeighbor = dancer.upNeighbor;
            dancer.newDownNeighbor = dancer.downNeighbor;
            dancer.newLeftNeighbor = dancer.leftNeighbor;
            dancer.newRightNeighbor = dancer.rightNeighbor;
        }
        long sum = interestLevel(dancers);
        while (eliminate(dancers)) {
            sum += interestLevel(dancers);
        }
        System.out.println(sum);
    }

    private boolean eliminate(List<Dancer> dancers) {
        boolean found = false;
        for (Dancer dancer : dancers) {
            int multipleSelf = 0;
            int sumOfNeighbors = 0;
            if (dancer.upNeighbor != null) {
                multipleSelf += dancer.skill;
                sumOfNeighbors += dancer.upNeighbor.skill;
            }
            if (dancer.downNeighbor != null) {
                multipleSelf += dancer.skill;
                sumOfNeighbors += dancer.downNeighbor.skill;
            }
            if (dancer.leftNeighbor != null) {
                multipleSelf += dancer.skill;
                sumOfNeighbors += dancer.leftNeighbor.skill;
            }
            if (dancer.rightNeighbor != null) {
                multipleSelf += dancer.skill;
                sumOfNeighbors += dancer.rightNeighbor.skill;
            }
            if (multipleSelf < sumOfNeighbors) {
                found = true;
                dancer.eliminated = true;
                if (dancer.newUpNeighbor != null) {
                    dancer.newUpNeighbor.newDownNeighbor = dancer.newDownNeighbor;
                }
                if (dancer.newDownNeighbor != null) {
                    dancer.newDownNeighbor.newUpNeighbor = dancer.newUpNeighbor;
                }
                if (dancer.newLeftNeighbor != null) {
                    dancer.newLeftNeighbor.newRightNeighbor = dancer.newRightNeighbor;
                }
                if (dancer.newRightNeighbor != null) {
                    dancer.newRightNeighbor.newLeftNeighbor = dancer.newLeftNeighbor;
                }
            }
        }
        Iterator<Dancer> iter = dancers.iterator();
        while (iter.hasNext()) {
            Dancer dancer = iter.next();
            if (dancer.eliminated) iter.remove();
            else {
                dancer.leftNeighbor = dancer.newLeftNeighbor;
                dancer.rightNeighbor = dancer.newRightNeighbor;
                dancer.upNeighbor = dancer.newUpNeighbor;
                dancer.downNeighbor = dancer.newDownNeighbor;
            }
        }
        return found;
    }

    private long interestLevel(List<Dancer> dancers) {
        long res = 0;
        for (Dancer dancer : dancers) {
            res += dancer.skill;
        }
        return res;
    }

    static class Dancer {
        int skill;
        Dancer upNeighbor, downNeighbor, leftNeighbor, rightNeighbor;
        Dancer newUpNeighbor, newDownNeighbor, newLeftNeighbor, newRightNeighbor;
        boolean eliminated;
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
