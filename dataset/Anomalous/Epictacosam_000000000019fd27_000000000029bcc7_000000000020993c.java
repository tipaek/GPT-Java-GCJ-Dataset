import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        for (int i = 0; i < n; i++) {
            int rowRepeat = 0;
            int colRepeat = 0;
            int diagonal = 0;
            int cubeSize = stdin.nextInt();

            int[][] cube = new int[cubeSize][cubeSize];
            List<Set<Integer>> rows = new ArrayList<>(cubeSize);
            List<Set<Integer>> cols = new ArrayList<>(cubeSize);

            boolean[] rowRepeatFlag = new boolean[cubeSize];
            boolean[] colRepeatFlag = new boolean[cubeSize];

            for (int j = 0; j < cubeSize; j++) {
                rows.add(new HashSet<>());
                cols.add(new HashSet<>());
            }

            for (int j = 0; j < cubeSize; j++) {
                for (int k = 0; k < cubeSize; k++) {
                    int value = stdin.nextInt();
                    cube[j][k] = value;

                    if (j == k) {
                        diagonal += value;
                    }

                    if (!rows.get(j).add(value) && !rowRepeatFlag[j]) {
                        rowRepeat++;
                        rowRepeatFlag[j] = true;
                    }

                    if (!cols.get(k).add(value) && !colRepeatFlag[k]) {
                        colRepeat++;
                        colRepeatFlag[k] = true;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonal + " " + rowRepeat + " " + colRepeat);
        }

        stdin.close();
    }
}