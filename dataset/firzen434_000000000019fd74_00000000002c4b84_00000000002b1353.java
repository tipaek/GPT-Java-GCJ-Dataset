import java.util.*;
import java.io.*;

public class Solution {
    
    /*
    1. Start at 1, 1; sum = 1
    2. Find the biggest, unvisited neighbor M such that M >= N - sum
    3. If such M exists, add M to sum
    4. If not such M exists, backtrack and find next biggest, unvisited neighbor
     */

    private static String soln(int N) {
        List<List<Integer>> triangle = createTriangle(6);
        int sum = 1;
        int r = 0;
        int k = 0;
        int pr = 0;
        int pk = 0;
        int pSum = 1;
        Stack<Integer[]> path = new Stack<>();
        path.push(new Integer[] { 0, 0 });

        while (sum < N) {
            int diff = N - sum;
            int[] a = getBiggestNeighbor(r, k, triangle, diff);
            int nr = a[0];
            int nk = a[1];
            int M = a[2];

            if (nr == triangle.size() - 1) {
                addRow(triangle);
            }

            if (M != -1) {
                pSum = sum;
                sum += M;

                pr = r;
                pk = k;
                r = nr;
                k = nk;

                triangle.get(r).set(k, -1); // mark as visited
                path.push(new Integer[] { r, k });
            } else {
                // backtrack
                r = pr;
                k = pk;
                sum = pSum;
                if (!path.isEmpty()) {
                    path.pop();
                }
            }
        }

        StringBuilder pathSB = new StringBuilder();
        for (Integer[] pair : path) {
            int a = pair[0];
            int b = pair[1];
            pathSB.append(String.format("%d %d\n", a + 1, b + 1));
        }
        return pathSB.toString();
    }

    private static List<List<Integer>> createTriangle(int size) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(1));
        for (int r = 1; r < size; r++) {
            addRow(triangle);
        }
        return triangle;
    }

    private static void addRow(List<List<Integer>> triangle) {
        List<Integer> row = new ArrayList<>();
        int r = triangle.size();
        for (int k = 0; k <= r; k++) {
            if (k == 0 || k == r) {
                row.add(1);
            } else {
                int a = triangle.get(r - 1).get(k - 1);
                int b = triangle.get(r - 1).get(k);
                row.add(a + b);
            }
        }
        triangle.add(row);
    }

    private static int[] getBiggestNeighbor(int r, int k, List<List<Integer>> triangle, int diff) {
        List<Integer> neighbors = new ArrayList<>();
        neighbors.add(getValue(r - 1, k - 1, triangle));
        neighbors.add(getValue(r - 1, k, triangle));
        neighbors.add(getValue(r, k - 1, triangle));
        neighbors.add(getValue(r, k + 1, triangle));
        neighbors.add(getValue(r + 1, k, triangle));
        neighbors.add(getValue(r + 1, k + 1, triangle));

        List<Integer[]> locations = new ArrayList<>();
        locations.add(new Integer[] { r - 1, k - 1 });
        locations.add(new Integer[] { r - 1, k });
        locations.add(new Integer[] { r, k - 1 });
        locations.add(new Integer[] { r, k + 1 });
        locations.add(new Integer[] { r + 1, k });
        locations.add(new Integer[] { r + 1, k + 1 });

        int max = -1;
        Integer[] location = new Integer[] { r, k };
        for (int i = 0; i < neighbors.size(); i++) {
            Integer neighbor = neighbors.get(i);
            if (neighbor <= diff && neighbor > max) {
                max = neighbor;
                location = locations.get(i);
            }
        }
        return new int[] { location[0], location[1], max };
    }

    private static int getValue(int r, int k, List<List<Integer>> triangle) {
        if (r < 0 || k < 0 || r >= triangle.size() || k >= triangle.get(r).size()) {
            return -1;
        }
        return triangle.get(r).get(k);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            System.out.println("Case #" + i + ":\n" + soln(N));
        }
    }
  
}
