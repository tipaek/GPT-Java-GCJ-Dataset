import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            int count = 0;
            String n = scanner.nextLine();
            StringBuilder s = new StringBuilder();

            for (char c : n.toCharArray()) {
                int j = Character.getNumericValue(c);
                if (j == count) {
                    s.append(j);
                } else if (count < j) {
                    s.append("(".repeat(j - count)).append(j);
                } else {
                    s.append(")".repeat(count - j)).append(j);
                }
                count = j;
            }
            s.append(")".repeat(count));
            System.out.println("case #" + (i + 1) + ": " + s);
        }
        scanner.close();
    }
}