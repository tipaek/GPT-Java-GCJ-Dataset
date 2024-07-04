import java.util.Scanner;

public class Main {

    static int max(String S) {
        int currentMax = 0;
        int max = 0;
        int n = S.length();

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                currentMax++;
                if (currentMax > max) {
                    max = currentMax;
                }
            } else if (S.charAt(i) == ')') {
                if (currentMax > 0) {
                    currentMax--;
                } else {
                    return -1;
                }
            }
        }

        if (currentMax != 0) {
            return -1;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();  // Consume newline left-over
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = scan.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Case #" + (i + 1) + ": " + max(s[i]));
        }
    }
}