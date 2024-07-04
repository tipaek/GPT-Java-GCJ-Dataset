import java.util.*;

class Vestigium {
    public static void main(String args[] ) throws Exception {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int t = 0; t< T; t++) {
            int COL_REP = 0, ROW_REP = 0, TRACE = 0;
            int N = scn.nextInt();

            ArrayList<Set<Integer>> column_maps = new ArrayList<>();
            for (int i = 0; i < N; i++)
                column_maps.add(i, new HashSet<Integer>());

            Set<Integer> currentRowSet = new HashSet<Integer>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int input = scn.nextInt();
                    currentRowSet.add(input);
                    column_maps.get(j).add(input);
                    if (i == j) TRACE += input;
                }
                if (currentRowSet.size() != N) ROW_REP++;
                currentRowSet.clear();
            }
            for (int i = 0; i < N; i++)
                if (column_maps.get(i).size() != N) COL_REP++;

            System.out.println("Case #"+(t+1)+": " + TRACE + " " + ROW_REP + " "  + COL_REP);
        }
    }
}