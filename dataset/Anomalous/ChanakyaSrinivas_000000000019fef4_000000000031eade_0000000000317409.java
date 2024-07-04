import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            int position = -1;
            
            for (int i = 0; i < path.length(); i++) {
                char direction = path.charAt(i);
                
                switch (direction) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    position = i + 1;
                    break;
                }
            }
            
            System.out.print("Case #" + t + ": ");
            if (position != -1) {
                System.out.println(position);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}