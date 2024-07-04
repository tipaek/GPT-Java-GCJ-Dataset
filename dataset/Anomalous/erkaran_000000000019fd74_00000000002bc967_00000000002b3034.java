import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
            }

            Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());
            boolean isValid = true;
            char lastChar = arr[0].charAt(arr[0].length() - 1);
            String subPattern = arr[0].substring(1);

            for (int i = 1; i < n; i++) {
                if (lastChar == arr[i].charAt(arr[i].length() - 1)) {
                    if (!subPattern.contains(arr[i].substring(1))) {
                        isValid = false;
                        break;
                    }
                } else {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + subPattern);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }
}