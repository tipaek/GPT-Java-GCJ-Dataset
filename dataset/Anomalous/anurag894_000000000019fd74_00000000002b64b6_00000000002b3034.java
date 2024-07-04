import java.util.Scanner;

class Solution {
    static final long MOD = (long) 1e18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int numStrings = scanner.nextInt();
            scanner.nextLine();
            String[] strings = new String[numStrings];
            String longestString = "";
            int maxLength = Integer.MIN_VALUE;

            for (int i = 0; i < numStrings; i++) {
                strings[i] = scanner.nextLine().replace("*", "");
                int length = strings[i].length();
                if (length > maxLength) {
                    maxLength = length;
                    longestString = strings[i];
                }
            }

            boolean allContain = true;
            for (String str : strings) {
                if (!longestString.contains(str)) {
                    allContain = false;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (allContain) {
                System.out.println(longestString);
            } else {
                System.out.println("*");
            }
        }
        
        scanner.close();
    }
}