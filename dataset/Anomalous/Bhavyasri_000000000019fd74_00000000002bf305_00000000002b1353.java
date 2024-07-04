import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = Integer.parseInt(scanner.nextLine());

        for (int io = 1; io <= testCase; io++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<String[]> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextLine().split("\\*"));
            }

            String ans = arr.get(0)[1];
            boolean isValid = true;

            for (int i = 0; i < arr.size() - 1; i++) {
                if (ans.length() <= arr.get(i + 1)[1].length()) {
                    if (arr.get(i)[1].contains(arr.get(i + 1)[1])) {
                        ans = arr.get(i + 1)[1];
                    } else {
                        ans = "*";
                        isValid = false;
                        break;
                    }
                } else {
                    if (arr.get(i + 1)[1].length() < ans.length()) {
                        if (arr.get(i + 1)[1].contains(arr.get(i)[1])) {
                            continue;
                        } else {
                            ans = "*";
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + io + ": " + ans);
        }

        scanner.close();
    }
}