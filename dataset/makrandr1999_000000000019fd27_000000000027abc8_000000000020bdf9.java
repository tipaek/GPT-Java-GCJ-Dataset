import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    private static Scanner sc;
    static int T = 1;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            solveProblem();
        }
    }
    private static boolean hasOverlap(int[] a, int[] b) {
        return a[1] > b[0];
    }
    private static char getp(char p) {
        return p == 'J' ? 'C' : 'J';
    }
    private static void solveProblem() {
        int n = sc.nextInt();
        char p = 'J';
        char[] chars = new char[n];
        int[][] matrix = new int[n][2];
        int[][] matrixSorted = matrix.clone();
        boolean imp = false;
        Stack <int[]> CS = new Stack <>();
        Stack <int[]> JS = new Stack <>();
        
        
        Map < int[], Integer > map = new HashMap < > ();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
            map.put(matrix[i], i);
        }
        Arrays.sort(matrixSorted, new Comparator < int[] > () {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < matrixSorted.length; i++) {
            chars[map.get(matrixSorted[i])] = p;
            if (i < matrixSorted.length - 1 && hasOverlap(matrixSorted[i], matrixSorted[i + 1])) {
                if (p == 'J') {
                    JS.push(matrixSorted[i]);
                    p = getp(p);

                    if (!CS.isEmpty() && hasOverlap(CS.peek(), matrixSorted[i + 1])) {
                        imp = true;
                        break;
                    }
                } else {
                    CS.push(matrixSorted[i]);
                    p = getp(p);
                    if (!JS.isEmpty() && hasOverlap(JS.peek(), matrixSorted[i + 1])) {
                        imp = true;
                        break;
                    }
                }
            } else {
                if (p == 'J') {
                    JS.push(matrixSorted[i]);
                } else {
                    CS.push(matrixSorted[i]);
                }
            }
        }
        System.out.println("Case #" + (T++) + ": " + (imp? "IMPOSSIBLE" : new String(chars)));
    }
    


}
