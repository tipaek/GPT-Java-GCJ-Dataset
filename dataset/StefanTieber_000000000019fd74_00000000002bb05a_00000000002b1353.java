import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        int workingNumber = number - 30;

        int currentValue = 0;

        StringBuilder stringBuilder = new StringBuilder();

        if (number <= 500) {
            for (int i = 0; i < number; i++) {
                stringBuilder.append(i + 1).append(" 1\n");
            }

            return stringBuilder.toString();
        }

        for (int k = 0; k < 30; k++) {

        }

        return "";
    }
}
