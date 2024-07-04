import java.util.Scanner;

public class Solution {

    private static String answer;
    private static int[] arr;
    private static int index;
    private static int nest;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            String s = input.next();
            System.out.println(String.format("Case #%d: %s", ks, solve(s)));
        }
        input.close();
    }

    private static String solve(String s) {
        answer = "";
        index = 0;
        nest = 0;
        arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        processDigits();
        return answer;
    }

    private static void processDigits() {
        while (index < arr.length) {
            if (arr[index] == nest) {
                answer += arr[index];
                index++;
            } else if (nest > arr[index]) {
                answer += ")";
                nest--;
            } else {
                answer += "(";
                nest++;
            }
        }
        while (nest > 0) {
            answer += ")";
            nest--;
        }
    }
}