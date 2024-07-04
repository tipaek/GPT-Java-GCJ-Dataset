import java.util.Scanner;

public class Solution {
    public static void solve10(Scanner input) {
        StringBuilder responseBuilder = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            String response = input.next();
            responseBuilder.append(response);
        }
        String responses = responseBuilder.toString();
        System.out.println(responses);
        if (responses.equals("Y") || responses.equals("N")) {
            return;
        }
    }

    public static void solve20(Scanner input) {
        // No implementation needed as per original functionality
    }

    public static void solve100(Scanner input) {
        // No implementation needed as per original functionality
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        
        for (int ks = 1; ks <= T; ks++) {
            if (B == 10) {
                solve10(input);
            } else if (B == 20) {
                solve20(input);
            } else {
                solve100(input);
            }
        }
    }
}