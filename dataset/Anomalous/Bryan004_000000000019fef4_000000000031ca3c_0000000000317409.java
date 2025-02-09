import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String path = input[2];
            
            int moves = -1;
            int time = 1;
            
            int dx = Math.abs(x);
            int dy = Math.abs(y);
            int distance = dx + dy;
            
            if (distance <= time) {
                moves = distance;
            } else {
                for (int j = 0; j < path.length(); j++) {
                    time++;
                    switch (path.charAt(j)) {
                        case 'N': y++; break;
                        case 'S': y--; break;
                        case 'E': x++; break;
                        case 'W': x--; break;
                    }
                    
                    dx = Math.abs(x);
                    dy = Math.abs(y);
                    distance = dx + dy;
                    
                    if (distance <= time) {
                        moves = Math.max(moves, distance);
                    }
                }
            }
            
            if (moves == -1 || moves > path.length()) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + moves);
            }
        }
        
        scanner.close();
    }
}