import java.util.Scanner;

public class Solution {

    public static void solve(Scanner input, int B) {
        int currentIndex = 1;
        int totalDigits = 1;
        StringBuilder result = new StringBuilder();
        
        while (currentIndex <= B) {
            System.out.println(currentIndex);
            String digit = input.next();
            
            if (totalDigits % 10 != 1) {
                result.append(digit);
                currentIndex++;
            }
            totalDigits++;
        }
        
        System.out.println(result.toString());
        input.next(); // Read the next input string
        
        return;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] inputData = input.nextLine().split(" ");
        int T = Integer.parseInt(inputData[0]);
        int B = Integer.parseInt(inputData[1]);
        
        for (int testCase = 1; testCase <= T; testCase++) {
            solve(input, B);
        }
    }
}