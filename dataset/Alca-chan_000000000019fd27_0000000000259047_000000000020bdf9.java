import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();
        if (numOfCases <= 0) {
            return;
        }

        StringBuilder output = new StringBuilder();
        for (int c = 0; c < numOfCases; c++) {
            int numOfActivities = scanner.nextInt();

            Integer[][] matrix = new Integer[numOfActivities][4];
            for (int i = 0; i < numOfActivities; i++) {
                matrix[i][0] = i;
                matrix[i][1] = scanner.nextInt();
                matrix[i][2] = scanner.nextInt();
            }

            Arrays.sort(matrix, new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    Integer i1 = o1[1];
                    Integer i2 = o2[1];
                    return i1.compareTo(i2);
                }
            });

            int jaimeOccupied = 0;
            int cameronOccupied = 0;

            output.append("Case #").append(c+1).append(": ");
            boolean fail = false;
            for (int i = 0; i < numOfActivities; i++) {
                if (jaimeOccupied > matrix[i][1]) {
                    if (cameronOccupied > matrix[i][1]) {
                        fail = true;
                        matrix[i][3] = 0;
                        break;
                    } else {
                        matrix[i][3] = 1;
                        cameronOccupied = matrix[i][2];
                    }
                } else {
                    matrix[i][3] = 2;
                    jaimeOccupied = matrix[i][2];
                }
            }
            if (fail) {
                output.append("IMPOSSIBLE\n");
            } else {
                Arrays.sort(matrix, new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        Integer i1 = o1[0];
                        Integer i2 = o2[0];
                        return i1.compareTo(i2);
                    }
                });
                for (int i = 0; i < numOfActivities; i++) {
                    if (matrix[i][3] == 1) output.append("C");
                    if (matrix[i][3] == 2) output.append("J");
                }
                output.append("\n");
            }
        }
        System.out.println(output.toString());
    }
}
