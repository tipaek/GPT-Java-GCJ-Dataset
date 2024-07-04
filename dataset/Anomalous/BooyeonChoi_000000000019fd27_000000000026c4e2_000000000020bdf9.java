/*
ID: brianch4
LANG: JAVA
TASK: parenting
*/
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("parenting.in"));

        int numCases = Integer.parseInt(f.readLine());

        for (int num = 0; num < numCases; num++) {
            int numTests = Integer.parseInt(f.readLine());

            HashSet<Integer> j = new HashSet<>();
            HashSet<Integer> c = new HashSet<>();

            boolean finalCheck = true;

            int[][] t = new int[numTests][2];
            int[][] realOne = new int[numTests][2];

            for (int jc = 0; jc < numTests; jc++) {
                String[] times = f.readLine().split(" ");
                t[jc][0] = Integer.parseInt(times[0]);
                t[jc][1] = Integer.parseInt(times[1]);
                realOne[jc][0] = t[jc][0];
                realOne[jc][1] = t[jc][1];
            }

            String[] result = new String[numTests];

            Arrays.sort(t, Comparator.comparingInt(a -> a[0]));

            for (int tests = 0; tests < t.length; tests++) {
                boolean jCheck = true;
                boolean cCheck = true;

                int start = t[tests][0];
                int end = t[tests][1];

                for (int i = start; i < end; i++) {
                    if (j.contains(i)) {
                        jCheck = false;
                        break;
                    }
                }
                if (jCheck) {
                    for (int i = start; i < end; i++) {
                        j.add(i);
                    }
                }

                if (!jCheck) {
                    for (int i = start; i < end; i++) {
                        if (c.contains(i)) {
                            cCheck = false;
                            break;
                        }
                    }
                    if (cCheck) {
                        for (int i = start; i < end; i++) {
                            c.add(i);
                        }
                    }
                }

                int index = -1;
                for (int i = 0; i < realOne.length; i++) {
                    if (Arrays.equals(t[tests], realOne[i])) {
                        index = i;
                        break;
                    }
                }

                if (jCheck) {
                    result[index] = "J";
                } else if (cCheck) {
                    result[index] = "C";
                } else {
                    finalCheck = false;
                }
            }

            if (!finalCheck) {
                System.out.printf("Case #%d: %s\n", num + 1, "IMPOSSIBLE");
            } else {
                StringBuilder returnVal = new StringBuilder();
                for (String res : result) {
                    returnVal.append(res);
                }
                System.out.printf("Case #%d: %s\n", num + 1, returnVal.toString());
            }
        }

        f.close();
    }
}