import java.util.Scanner;

public class Main {

    public static String solve(String t, String result, String prev) {
        if (!prev.isEmpty() && !t.isEmpty()) {
            if (Integer.parseInt(prev) > Integer.parseInt(t.substring(0, 1))) {
                for (int i = 0; i < Integer.parseInt(prev) - Integer.parseInt(t.substring(0, 1)); i++) {
                    result += ")";
                }
            }
        }
        if (t.isEmpty()) {
            for (int i = 0; i < Integer.parseInt(prev); i++) {
                result += ")";
            }
            return result;
        }
        if (Integer.parseInt(t.substring(0, 1)) == 0) {
            return solve(t.substring(1), result + t.substring(0, 1), t.substring(0, 1));
        }
        if (Integer.parseInt(t.substring(0, 1)) == 1) {
            if (!prev.isEmpty()) {
                if (Integer.parseInt(prev) == 0) {
                    result += "(" + t.substring(0, 1);
                } else {
                    result += t.substring(0, 1);
                }
            } else {
                result += "(" + t.substring(0, 1);
            }
            return solve(t.substring(1), result, t.substring(0, 1));
        }
        if (Integer.parseInt(t.substring(0, 1)) > 1) {
            if (!prev.isEmpty()) {
                for (int i = 0; i < Integer.parseInt(t.substring(0, 1)) - Integer.parseInt(prev); i++) {
                    result += "(";
                }
                result += t.substring(0, 1);
            } else {
                for (int i = 0; i < Integer.parseInt(t.substring(0, 1)); i++) {
                    result += "(";
                }
                result += t.substring(0, 1);
            }
            return solve(t.substring(1), result, t.substring(0, 1));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int m = 0; m < t; m++) {
            String k = scanner.nextLine();
            System.out.println("Case #" + (m + 1) + ": " + solve(k, "", ""));
        }
        scanner.close();
    }
}