import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = in.nextInt();
        for (int nooftestcases = 1; nooftestcases <= testcases; ++nooftestcases) {
            int nooftimes = in.nextInt();
            int[][] matrix = new int[nooftimes][2];
            int[][] matrixsorted = matrix.clone();
            char[] chars = new char[nooftimes];
            char person = 'J';
            Map<int[], Integer> map = new HashMap<>();
            Stack<int[]> jamiestack = new Stack<>();
            Stack<int[]> camiestack = new Stack<>();
            boolean impossible = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = in.nextInt();
                }
                map.put(matrix[i], i);

            }
            Arrays.sort(matrixsorted, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0] - t1[0];
                }
            });

            for (int i = 0; i < matrixsorted.length; i++) {
                chars[map.get(matrixsorted[i])] = person;

                if (i < matrixsorted.length - 1 && doesoverlap(matrixsorted[i], matrixsorted[i + 1])) {
                    if (person == 'J') {
                        jamiestack.push(matrixsorted[i]);
                        person = getPerson(person);
                        if (!camiestack.isEmpty() && doesoverlap(camiestack.peek(), matrixsorted[i + 1])) {
                            impossible = true;
                            break;
                        }
                    } else {
                        camiestack.push(matrixsorted[i]);
                        person = getPerson(person);
                        if (!jamiestack.isEmpty() && doesoverlap(jamiestack.peek(), matrixsorted[i + 1])) {
                            impossible = true;
                            break;
                        }
                    }
                } else {


                    if (person == 'J') {
                        jamiestack.push(matrixsorted[i]);

                    } else {
                        camiestack.push(matrixsorted[i]);

                    }
                }

            }
            System.out.println("Case #" + nooftestcases + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
        }
    }

    public static boolean doesoverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }

    public static char getPerson(char p) {
        return p == 'J' ? 'C' : 'J';
    }
}

