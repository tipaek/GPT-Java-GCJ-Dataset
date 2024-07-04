
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int t = Integer.valueOf(input.nextLine());
        int caseNumber = 1;
        List<String> results = new ArrayList<>();

        while (t > 0) {
            String[] rc =  input.nextLine().split(" ");
            int r = Integer.valueOf(rc[0]);
            int c = Integer.valueOf(rc[1]);
            int[][] m = new int[r][c];
            int i = 0;

            while (i < r) {
                String[] line =  input.nextLine().split(" ");
                for (int j = 0; j < c; j++) {
                    m[i][j] = Integer.valueOf(line[j]);
                }
                i++;
            }

            results.add(String.format("Case #%d: %s", caseNumber, getResult(m)));
            caseNumber++;
            t--;
        }

        for (String r : results) {
            System.out.println(r);
        }

    }

    private static String getResult(int[][] m) {
        int result = 0;
        int firstRoundInterest = getInterest(m);
        result += firstRoundInterest;

        if (m.length == 1 && m[0].length == 1) {
            return String.valueOf(result);
        }

        int eliminated = 1;

            while (eliminated > 0) {
                Pair nextRound = getRound(m);

                eliminated = nextRound.eliminated;

                if (eliminated > 0) {
                    result += nextRound.levelInterest;
                }
                m = nextRound.round;
            }

        return String.valueOf(result);
    }

    private static Pair getRound(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        int eliminated = 0;

        int[][] m2 = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] != 0) {
                    double nSkills = getNSkills(m, i, j);
                    int d = m[i][j];
                    if (d < nSkills) {
                        eliminated++;
                        m2[i][j] = 0;
                    } else {
                        m2[i][j] = d;
                    }
                }
            }
        }

        Pair result = new Pair();
        result.levelInterest = getInterest(m2);
        result.eliminated = eliminated;
        result.round = m2;

        return result;
    }

    private static double getNSkills(int[][] m, int i, int j) {
        int r = m.length;
        int c = m[0].length;

        int n = 0;
        int a = 0;
        int l = j - 1;

        while (l >= 0) {
            if (m[i][l] > 0) {
                a = m[i][l];
                n++;
                break;
            } else {
                l--;
            }
        }

        int b = 0;
        int rr = j + 1;
        while (rr < c) {
            if (m[i][rr] > 0) {
                b = m[i][rr];
                n++;
                break;
            } else {
                rr++;
            }
        }

        int cc = 0;
        int u = i - 1;
        while (u >=0 ) {
            if (m[u][j] > 0) {
                cc = m[u][j];
                n++;
                break;
            } else {
                u--;
            }
        }

        int d = 0;
        int dd = i + 1;
        while (dd < r) {
            if (m[dd][j] > 0) {
                d = m[dd][j];
                n++;
                break;
            } else {
                dd++;
            }
        }

        if (n == 0) {
            return 0.0d;
        } else {
            return (double) (a + b + cc + d) / n;
        }
    }

    private static int getInterest(int[][] m) {
        int interest = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                interest += m[i][j];
            }
        }

        return interest;
    }

    private static class Pair {
        int levelInterest;
        int[][] round;
        int eliminated;
    }
}
