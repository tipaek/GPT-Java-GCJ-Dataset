import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            int result = 0;
            System.out.print("Case #" + (i + 1) + ": ");
            String path = sc.next();
            
            if (x == 0 && y == 0) {
                result = 0;
            } else {
                for (int j = 0; j < path.length(); j++) {
                    if (x > 0) {
                        x--;
                    } else {
                        y--;
                    }
                    result++;
                    
                    if (x == 0 && y == 0) {
                        break;
                    }
                    
                    char direction = path.charAt(j);
                    switch (direction) {
                        case 'S':
                            y -= 1;
                            break;
                        case 'N':
                            y += 1;
                            break;
                        case 'E':
                            x += 1;
                            break;
                        case 'W':
                            x -= 1;
                            break;
                    }
                    
                    if (x == 0 && y == 0) {
                        break;
                    }
                    
                    if (j == path.length() - 1) {
                        result = -1;
                        break;
                    }
                }
            }
            
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }
}