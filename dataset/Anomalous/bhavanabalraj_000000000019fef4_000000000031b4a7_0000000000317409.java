import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            
            int len = path.length();
            boolean isPossible = false;
            int time = 0;
            
            for (time = 0; time <= len; time++) {
                if (Math.abs(x) + Math.abs(y) <= time) {
                    isPossible = true;
                    break;
                }
                
                if (time < len) {
                    char direction = path.charAt(time);
                    switch (direction) {
                        case 'N':
                            y += 1;
                            break;
                        case 'S':
                            y -= 1;
                            break;
                        case 'E':
                            x -= 1;
                            break;
                        case 'W':
                            x += 1;
                            break;
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + t + ": " + time);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}