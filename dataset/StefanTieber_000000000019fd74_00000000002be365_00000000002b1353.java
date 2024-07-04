import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            String[] parts;

            line = reader.readLine();
            int numberOfSets = Integer.parseInt(line);

            for (int i = 0; i < numberOfSets; i++) {
                int number = Integer.parseInt(reader.readLine());

                String solution = solve(number);

                System.out.println("Case #" + (i + 1) + ":\n" + solution);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String solve(int number) {
        StringBuilder stringBuilder = new StringBuilder();

        if (number <= 500) {
            for (int i = 0; i < number; i++) {
                stringBuilder.append(i + 1).append(" 1\n");
            }

            return stringBuilder.toString();
        }

        int workingNumber = number - 30;

        int currentValue = 0;

        int[][] pascal = new int[30][31];

        int position = 0;

        int i;
        for (i = 0; i < 30; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascal[i][j] = 1;
                } else {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
                }
            }

            int bit = workingNumber % 2;
            workingNumber /= 2;

            if (bit == 1) {
                if (position == 0) {
                    for (int j = 0; j <= i; j++) {
                        stringBuilder.append(i + 1).append(" ").append(j + 1).append("\n");
                        currentValue += pascal[i][j];
                    }
                    position = 1;
                } else {
                    for (int j = i; j >= 0; j--) {
                        stringBuilder.append(i + 1).append(" ").append(j + 1).append("\n");
                        currentValue += pascal[i][j];
                    }
                    position = 0;
                }
            } else {
                if (position == 0) {
                    stringBuilder.append(i + 1).append(" ").append(1).append("\n");
                } else {
                    stringBuilder.append(i + 1).append(" ").append(i + 1).append("\n");
                }
                currentValue += 1;
            }
        }

        for (; currentValue < number; i++) {
            if (position == 0) {
                stringBuilder.append(i + 1).append(" ").append(1).append("\n");
            } else {
                stringBuilder.append(i + 1).append(" ").append(i + 1).append("\n");
            }
            currentValue += 1;
        }

        return stringBuilder.toString();
    }
}
