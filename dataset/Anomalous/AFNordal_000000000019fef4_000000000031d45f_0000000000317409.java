import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            char[] directions = scanner.nextLine().toCharArray();
            
            for (int j = 1; j <= directions.length; j++) {
                switch (directions[j - 1]) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                
                if (j >= Math.abs(x) + Math.abs(y)) {
                    System.out.println("case #" + (i + 1) + ": " + j);
                    break;
                } else if (j == directions.length) {
                    System.out.println("case #" + (i + 1) + ": IMPOSSIBLE");
                }
            }
        }
        
        scanner.close();
    }
}