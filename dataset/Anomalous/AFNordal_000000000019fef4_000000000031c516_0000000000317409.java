import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String directions = scanner.next().strip();
            
            boolean reached = false;
            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);
                
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                
                if (j + 1 >= Math.abs(x) + Math.abs(y)) {
                    System.out.println("case #" + (i + 1) + ": " + (j + 1));
                    reached = true;
                    break;
                }
            }
            
            if (!reached) {
                System.out.println("case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}