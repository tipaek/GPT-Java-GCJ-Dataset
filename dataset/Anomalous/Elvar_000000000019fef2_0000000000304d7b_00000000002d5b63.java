import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        for (int testcase = 1; testcase <= T; testcase++) {
            int rx1 = findCoordinate(sc, -1);
            int rx2 = findCoordinate(sc, 1);
            int ry1 = findCoordinate(sc, 2);
            
            if (rx1 == Integer.MIN_VALUE || rx2 == Integer.MIN_VALUE || ry1 == Integer.MIN_VALUE) {
                continue; // Center found, no need to proceed
            }
            
            int ox = (rx1 + rx2) / 2;
            int oy = ry1 / 2;
            
            for (int i = 0; i < 121; i++) {
                int giskx = ox - 5 + i % 11;
                int gisky = oy - 5 + i / 11;
                System.out.println(giskx + " " + gisky);
                if (sc.next().equals("CENTER")) {
                    break;
                }
            }
        }
    }
    
    private static int findCoordinate(Scanner sc, int direction) {
        int inc = (int) (Math.pow(10, 7)) * 2;
        int a = (direction == 1) ? (int) (Math.pow(10, 9)) + inc : (int) (-Math.pow(10, 9)) - inc;
        int b = a - direction * inc;
        boolean found = false;
        
        while (!found) {
            String response;
            do {
                a -= direction * inc;
                b -= direction * inc;
                System.out.println((direction == 2 ? 0 : b) + " " + (direction == 2 ? b : 0));
                response = sc.next();
            } while (response.equals("MISS"));
            
            if (response.equals("CENTER")) {
                return Integer.MIN_VALUE;
            } else {
                while (a + 1 < b) {
                    int c = (a + b) / 2;
                    System.out.println((direction == 2 ? 0 : c) + " " + (direction == 2 ? c : 0));
                    response = sc.next();
                    if (response.equals("MISS")) {
                        b = c;
                    } else if (response.equals("HIT")) {
                        a = c;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                found = true;
            }
        }
        return a;
    }
}