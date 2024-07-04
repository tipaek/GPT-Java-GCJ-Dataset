import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            int index = 1;
            int[] bytes = new int[b];

            for (int j = 1; j <= 150; j++) {
                System.out.println(index);
                int response = scanner.nextInt();

                if (j % 10 == 1) {
                    // Placeholder for any special action every 10th query
                }

                bytes[index - 1] = response; // Adjusted index to be zero-based
                index = (index % b) + 1; // Corrected index logic to be within bounds
            }

            System.out.println(convertToString(bytes));
        }
    }

    public static String convertToString(int[] bytes) {
        StringBuilder result = new StringBuilder();
        for (int byteValue : bytes) {
            result.append(byteValue);
        }
        return result.toString();
    }
}