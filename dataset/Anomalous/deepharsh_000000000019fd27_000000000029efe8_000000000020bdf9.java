import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 1; i <= T; i++) {
            int n = scanner.nextInt();
            int[] num = new int[n * 2];
            for (int j = 0; j < num.length; j++) {
                num[j] = scanner.nextInt();
            }
            System.out.println("Case #" + i + ": " + findSchedule(num, "", 0));
        }
    }

    public static String findSchedule(int[] num, String str, int i) {
        if (i >= num.length - 2) {
            return "IMPOSSIBLE";
        }
        
        str += "C";
        
        if (num[i + 1] <= num[i + 2]) {
            while (num[i + 1] <= num[i + 2]) {
                str += "C";
                i += 2;
                if (i >= num.length - 2) {
                    return str;
                }
            }
            return switchToJ(num, str, i + 2);
        } else {
            return switchToJ(num, str, i + 2);
        }
    }

    public static String switchToJ(int[] num, String str, int i) {
        if (i >= num.length - 2) {
            return "IMPOSSIBLE";
        }
        
        str += "J";
        
        if (num[i + 1] <= num[i + 2]) {
            while (num[i + 1] <= num[i + 2]) {
                str += "J";
                i += 2;
                if (i >= num.length - 2) {
                    return str;
                }
            }
            return findSchedule(num, str, i + 2);
        } else {
            return findSchedule(num, str, i + 2);
        }
    }
}