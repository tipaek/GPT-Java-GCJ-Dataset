import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int result = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            String directions = sc.next();
            
            for (int j = 0; j < directions.length(); j++) {
                char direction = directions.charAt(j);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                
                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= (j + 1)) {
                    result = j + 1;
                    break;
                }
            }
            
            if (result == 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result);
            }
        }
        
        sc.close();
    }
}