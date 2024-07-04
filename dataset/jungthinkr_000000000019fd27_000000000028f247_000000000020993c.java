    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int k=1;k<=numCases;k++) {
            int size = in.nextInt();
            int[][] m = new int[size][size];
            int trace = 0, r = 0, c = 0;

            for (int i=0;i<size;i++) {
                for (int j=0;j<size;j++) {
                    m[i][j] = in.nextInt();
                }
            }
            for (int i=0;i<size;i++) {
                Set<Integer> R = new HashSet<>();
                Set<Integer> C = new HashSet<>();
                boolean uniqueR = true, uniqueC = true;
                for (int j=0;j<size;j++) {
                    int a = m[i][j];
                    int b = m[j][i];
                    if (R.contains(a)) {
                        uniqueR = false;
                    }
                    if (C.contains(b)) {
                        uniqueC = false;
                    }
                    R.add(a);
                    C.add(b);
                }

                if (!uniqueR) r++;
                if (!uniqueC) c++;
            }

            for (int i=0;i<size;i++) {
                trace += m[i][i];
            }
            System.out.println("Case #" + k + ":" + String.format(" %s %s %s", trace, r, c));
        }
      }
    }
  