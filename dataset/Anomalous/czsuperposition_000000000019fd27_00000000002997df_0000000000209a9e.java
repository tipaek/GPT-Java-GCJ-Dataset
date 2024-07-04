import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        
        // Ensure B is 10, otherwise exit
        if (B != 10) {
            System.exit(0);
        }
        
        for (int i = 0; i < T; i++) {
            StringBuilder arr = new StringBuilder();
            
            // Read and append the first reply
            System.out.println(1);
            arr.append(scanner.nextInt());
            
            // Read and append the remaining replies
            for (int j = 1; j < B; j++) {
                System.out.println(j + 1);
                arr.append(scanner.nextInt());
            }
            
            // Print the accumulated replies
            System.out.println(arr.toString());
            
            // Check if the output is okay
            String ok = scanner.next();
            if (ok.equals("N")) {
                System.exit(0);
            }
        }
        
        scanner.close();
        System.exit(0);
    }
}