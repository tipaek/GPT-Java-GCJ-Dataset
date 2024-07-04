import java.util.Scanner;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline left-over
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline left-over
            String result = "";
            for (int i = 0; i < n / 2; i++) {
                String str1 = "." + sc.next();
                String str2 = "." + sc.next();
                boolean matchFound = Pattern.matches(str1, str2);
                if (matchFound) {
                    result = str2;
                }
            }
            if (result.isEmpty()) {
                System.out.println("*");
            } else {
                System.out.println(result.substring(1));
            }
        }
        sc.close();
    }
}