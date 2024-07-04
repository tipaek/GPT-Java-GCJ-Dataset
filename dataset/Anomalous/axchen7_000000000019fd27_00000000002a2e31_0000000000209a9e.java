import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            boolean[] bits = new boolean[b];
            boolean[] matchStatus = new boolean[b / 2];
            
            // Read initial bit pairs
            for (int i = 0; i < b / 2; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt() == 1;
                
                System.out.println(b - i);
                bits[b - i - 1] = scanner.nextInt() == 1;
                
                matchStatus[i] = (bits[i] == bits[b - i - 1]);
            }
            
            boolean[] complementStatus = new boolean[b / 10];
            boolean[] reverseStatus = new boolean[b / 10];
            
            // Determine complement and reverse status
            for (int i = 0; i < b / 10; i++) {
                boolean allMatch = true;
                boolean allDifferent = true;
                int firstMatchIndex = -1;
                int firstDifferentIndex = -1;
                
                for (int j = 0; j < 5; j++) {
                    if (matchStatus[i * 5 + j]) {
                        allDifferent = false;
                        firstMatchIndex = j;
                    } else {
                        allMatch = false;
                        firstDifferentIndex = j;
                    }
                }
                
                if (allMatch || allDifferent) {
                    System.out.println(i * 5 + 1);
                    complementStatus[i] = (scanner.nextInt() == 1) != bits[i * 5];
                    System.out.println(1);
                    scanner.nextInt();
                } else {
                    System.out.print(i * 5 + firstMatchIndex + 1);
                    complementStatus[i] = (scanner.nextInt() == 1) != bits[i * 5 + firstMatchIndex];
                    System.out.print(i * 5 + firstDifferentIndex + 1);
                    reverseStatus[i] = (scanner.nextInt() == 1) == bits[i * 5 + firstDifferentIndex] == complementStatus[i];
                }
            }
            
            // Construct the output
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(bits[i] ? '1' : '0');
            }
            System.out.println(result);
            
            // Check if the result is correct
            if (scanner.next().equals("N")) break;
        }

        scanner.close();
    }
}