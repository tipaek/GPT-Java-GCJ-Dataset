import java.util.Scanner;

class Main {

    static int maxNestingDepth(String str) {
        int currentMax = 0;
        int maxDepth = 0;
        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                currentMax++;
                if (currentMax > maxDepth) {
                    maxDepth = currentMax;
                }
            } else if (str.charAt(i) == ')') {
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

        return maxDepth;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine(); // Consume newline character after integer input

        String[] expressions = new String[n];

        for (int i = 0; i < n; i++) {
            expressions[i] = scan.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Case #" + (i + 1) + ": " + maxNestingDepth(expressions[i]));
        }

        scan.close();
    }
}