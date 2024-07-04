import java.util.Scanner;

public class Solution {

    static String helper(String path, int x, int y) {
        int minute = 0;
        if(minute == x + y) {
            return "0";
        }
        int i = 0;
        while(i < path.length()) {
            minute++;
            if(path.charAt(i) == 'N') {
                y += 1;
            } else if(path.charAt(i) == 'S') {
                y -= 1;
            } else if(path.charAt(i) == 'W') {
                x -=1;
            } else if(path.charAt(i) == 'E') {
                x += 1;
            }
            if(minute >= Math.abs(x) + Math.abs(y)) {
                return "" + minute;
            }
            i++;
        }
        return "IMPOSSIBLE";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseN = scanner.nextInt();
        int testCase = 1;
        StringBuilder builder = new StringBuilder();
        while(testCase <= testCaseN) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.nextLine().trim();
            String res = helper(path, x, y);
            builder.append("Case #" + testCase + ": " + res + "\n");
            testCase++;
        }

        System.out.println(builder.toString());
    }
}