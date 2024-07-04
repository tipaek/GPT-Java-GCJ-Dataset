import java.util.Scanner;

public class Solution {

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static String paranthesize(String str) {
        StringBuilder sb = new StringBuilder(str);
        int[] nest = new int[str.length()];
        int remaining = 0;

        for (int i = 0; i < str.length(); i++) {
            nest[i] = str.charAt(i) - '0';
            if (nest[i] > 0) {
                remaining++;
            }
        }

        while (remaining > 0) {
            int idx = 0;
            int nidx = 0;
            boolean terminate = false;
            int open = -1;
            int close = -1;

            // Place opening parenthesis
            while (idx < sb.length()) {
                char currentChar = sb.charAt(idx);

                if (currentChar == '(' || currentChar == ')') {
                    idx++;
                    continue;
                }

                if (nest[nidx] > 0) {
                    open = idx;
                    break;
                }

                idx++;
                nidx++;
            }

            if (open == -1) {
                break;
            }

            // Place closing parenthesis
            while (idx < sb.length()) {
                char currentChar = sb.charAt(idx);

                if (currentChar == '(' || currentChar == ')') {
                    idx++;
                    continue;
                }

                if (nest[nidx] == 0) {
                    close = idx + 1;
                    break;
                }

                if (nest[nidx] > 0) {
                    nest[nidx]--;
                    if (nest[nidx] == 0) {
                        remaining--;
                    }
                    nidx++;
                }

                idx++;
            }

            if (close == -1) {
                close = sb.length() + 1;
            }

            sb.insert(open, '(');
            sb.insert(close, ')');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = Integer.parseInt(scan.nextLine());

        for (int t = 1; t <= tc; t++) {
            String s = scan.nextLine();
            System.out.println("Case #" + t + ": " + paranthesize(s));
        }
    }
}