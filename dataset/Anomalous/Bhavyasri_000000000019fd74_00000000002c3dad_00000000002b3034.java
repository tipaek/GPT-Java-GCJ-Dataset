import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int io = 1; io <= testCase; io++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            List<String[]> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextLine().split("\\*"));
            }

            String ans = arr.get(0)[1];
            boolean valid = true;

            for (int i = 0; i < arr.size() - 1; i++) {
                if (ans.length() <= arr.get(i + 1)[1].length()) {
                    if (arr.get(i)[1].contains(arr.get(i + 1)[1])) {
                        ans = arr.get(i + 1)[1];
                    } else {
                        ans = "*";
                        valid = false;
                        break;
                    }
                } else {
                    if (arr.get(i + 1)[1].length() < ans.length()) {
                        if (arr.get(i + 1)[1].contains(arr.get(i)[1])) {
                            continue;
                        } else {
                            ans = "*";
                            valid = false;
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + io + ": " + (valid ? ans : "*"));
        }

        scanner.close();
    }
}