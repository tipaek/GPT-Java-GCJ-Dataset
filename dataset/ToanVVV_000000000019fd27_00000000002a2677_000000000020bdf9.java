import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numCase = in.nextInt();
        for (int i = 0; i < numCase; i++) {
            int n = in.nextInt();
            int rui[][] = new int[n][2];

            ArrayList<int[][]> ruiIndex = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int ti = in.nextInt();
                int tf = in.nextInt();
                rui[j][0] = ti;
                rui[j][1] = tf;
                int[][] x = new int[1][2];
                x[0][0] = ti;
                x[0][1] = tf;
                ruiIndex.add(x);
            }
            sortCol(rui, 0);

            ArrayList<int[][]> C = new ArrayList<>();
            ArrayList<int[][]> J = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            char[] anser = new char[n];

            boolean impossible = false;
            for (int j = 0; j < n; j++) {
                int ti = rui[j][0];
                int tf = rui[j][1];
                boolean cf = false;
                boolean jf = false;
                for (int[][] o : C) {
                    if (((ti >= o[0][0]) && ti < o[0][1]) || ((tf > o[0][0]) && tf <= o[0][1])) {
                        cf = true;
                        break;
                    }
                }
                if (!cf) {
                    int[][] x = new int[1][2];
                    x[0][0] = ti;
                    x[0][1] = tf;
                    C.add(x);
                    int pos = 0;
                    for (int[][] o : ruiIndex) {
                        if (o[0][0] == ti && o[0][1] == tf) {
                            if (!set.contains(pos)) {
                                set.add(pos);
                                break;
                            }
                        }
                        pos++;
                    }

                    anser[pos] = 'C';
                } else {
                    for (int[][] o : J) {
                        if (((ti >= o[0][0]) && ti < o[0][1]) || ((tf > o[0][0]) && tf <= o[0][1])) {
                            jf = true;
                            break;
                        }
                    }
                    if (!jf) {
                        int[][] x = new int[1][2];
                        x[0][0] = ti;
                        x[0][1] = tf;
                        J.add(x);
                        int pos = 0;
                        for (int[][] o : ruiIndex) {
                            if (o[0][0] == ti && o[0][1] == tf) {
                                if (!set.contains(pos)) {
                                    set.add(pos);
                                    break;
                                }
                            }
                            pos++;
                        }

                        anser[pos] = 'J';
                    } else {
                        impossible = true;
                    }
                }
            }

            if (impossible)
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            else {
                StringBuilder result = new StringBuilder("");
                for (int j = 0; j < n; j++)
                    result.append(anser[j]);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }

        }

    }

    public static void sortCol(int arr[][], int col) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(final int[] entry1, final int[] entry2) {
                if (entry1[col] >= entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }
}
