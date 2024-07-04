import java.util.Scanner;

public class Code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            
            for (char ch : input.toCharArray()) {
                if (ch == '1') {
                    System.out.print("(" + ch + ")");
                } else if (ch == '0') {
                    System.out.print(ch);
                }
            }
        }
    }
}