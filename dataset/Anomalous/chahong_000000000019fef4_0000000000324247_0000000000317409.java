import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int mx = 0, my = 0;
            int result = 0;
            
            System.out.print("Case #" + (i + 1) + ": ");
            String path = sc.next();
            
            if (x == 0 && y == 0) {
                result = 0;
            } else {
                for (int j = 0; j < path.length(); j++) {
                    char direction = path.charAt(j);
                    switch (direction) {
                        case 'S': y -= 1; break;
                        case 'N': y += 1; break;
                        case 'E': x += 1; break;
                        case 'W': x -= 1; break;
                    }
                    result++;
                    
                    int xgap = Math.abs(x - mx);
                    int ygap = Math.abs(y - my);
                    
                    if (xgap > ygap) {
                        if (x > mx) mx++;
                        else if (x < mx) mx--;
                    } else {
                        if (y > my) my++;
                        else if (y < my) my--;
                    }
                    
                    if (x == mx && y == my) {
                        break;
                    }
                    
                    if (j == path.length() - 1) {
                        result = -1;
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