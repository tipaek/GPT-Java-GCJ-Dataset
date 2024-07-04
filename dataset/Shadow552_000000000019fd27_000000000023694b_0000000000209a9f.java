import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTest = s.nextInt();

        for (int i = 0; i < numTest; i++) {
            String line_str = s.next();
            StringBuilder sb = new StringBuilder();

            int[] line_int = new int[line_str.length()];
            toIntArray(line_str, line_int);

            for (int k = 0; k < line_int[0]; k++) {
                sb.append("(");
            }
            sb.append(line_int[0]);

            for (int j = 0; j < line_int.length - 1; j++) {
                int diff;
                if (line_int[j] < line_int[j + 1]) {
                    diff = line_int[j + 1] - line_int[j];
                    for (int k = 0; k < diff; k++) {
                        sb.append("(");
                    }
                    sb.append(line_int[j+1]);
                } else if (line_int[j + 1] < line_int[j]) {
                    diff = line_int[j] - line_int[j + 1];
                    for (int k = 0; k < diff; k++) {
                        sb.append(")");
                    }
                    sb.append(line_int[j+1]);
                } else {
                    sb.append(line_int[j+1]);
                }
            }

            for (int k = 0; k < line_int[line_int.length - 1]; k++) {
                sb.append(")");
            }

            System.out.println("Case #" + (i+1) + ": "+sb.toString());
        }
    }

    public static int[] toIntArray(String s, int[] res) {
        for (int i = 0; i < res.length; i++) {
            res[i] = Character.getNumericValue(s.charAt(i));
        }
        return res;
    }
}
