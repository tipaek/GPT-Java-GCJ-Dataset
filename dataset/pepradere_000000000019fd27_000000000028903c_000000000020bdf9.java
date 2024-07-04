import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static int[][] data;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int C = 1;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String sol = "IMPOSSIBLE";
            int N = Integer.parseInt(in.readLine());
            data = new int[N][];
            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                data[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i, -1};
            }

            char solution[] = new char[N];
            int numberCurrentTask = 0;
            int[] calendarC = new int[24 * 60];
            int[] calendarJ = new int[24 * 60];
            char[] possible = process(solution, numberCurrentTask, calendarC, calendarJ);

            boolean ok = true;
            for (int i = 0; i < possible.length; ++i) {
                if (possible[i] != 'C' && possible[i] != 'J') {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                sol = "";
                for (int i = 0; i < possible.length; ++i) {
                    sol += possible[i];
                }
            }

            sb.append("Case #" + (C++) + ": " + sol + "\n");
        }
        System.out.print(new String(sb));

    }

    public static char[] process(char[] solution, int numberCurrentTask, int[] calendarC, int[] calendarJ) {
        if (numberCurrentTask >= solution.length)
            return solution;

        char[] cpyC = new char[solution.length];
        char[] cpyJ = new char[solution.length];
        for (int i = 0; i < solution.length; ++i) {
            cpyC[i] = solution[i];
            cpyJ[i] = solution[i];
        }


        int[] cpyCCalendarC = new int[calendarC.length];
        int[] cpyCCalendarJ = new int[calendarJ.length];
        for (int i = 0; i < calendarC.length; ++i) {
            cpyCCalendarC[i] = calendarC[i];
            cpyCCalendarJ[i] = calendarJ[i];
        }

        boolean cCan = true;
        for (int i = data[numberCurrentTask][0]; i < data[numberCurrentTask][1]; ++i) {
            if (cpyCCalendarC[i] == 0) {
                cpyCCalendarC[i] = 1;
            } else {
                cCan = false;
                break;
            }
        }
        if (cCan) {
            cpyC[numberCurrentTask] = 'C';
            char[] possibleSol = process(cpyC, numberCurrentTask + 1, cpyCCalendarC, calendarJ);
            boolean ok = true;
            for (int i = 0; i < possibleSol.length; ++i) {
                if (possibleSol[i] != 'C' && possibleSol[i] != 'J') {
                    ok = false;
                    break;
                }
            }
            if (ok)
                return possibleSol;
        }

        boolean jCan = true;
        for (int i = data[numberCurrentTask][0]; i < data[numberCurrentTask][1]; ++i) {
            if (cpyCCalendarJ[i] == 0) {
                cpyCCalendarJ[i] = 1;
            } else {
                jCan = false;
                break;
            }
        }
        if (jCan) {
            cpyJ[numberCurrentTask] = 'J';
            char[] possibleSol = process(cpyJ, numberCurrentTask + 1, calendarC, cpyCCalendarJ);
            boolean ok = true;
            for (int i = 0; i < possibleSol.length; ++i) {
                if (possibleSol[i] != 'C' && possibleSol[i] != 'J') {
                    ok = false;
                    break;
                }
            }
            if (ok)
                return possibleSol;
        }

        return solution;
    }


}
