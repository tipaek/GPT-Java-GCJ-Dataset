import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            findAnswer(scanner,T,A,B);
        }
    }
    // Guess radius R  and center (X,Y)
    // Case 1 we know radius = 10^9-5
    // Case 2 we know radius = 10^9-50
    public static void findAnswer(Scanner scanner,int T,int A,int B) {
        boolean found = false;
        long TENPOW9 = 1_000_000_000;
        int t = 0;
        while (t < T) {
            for (int i=-6;i <= 6; i++) {
                for (int j=-6; j <=6; j++) {
                    System.out.println((TENPOW9+i)+" "+(TENPOW9+j));
                    String answer = scanner.next();
                    if (answer.equals("CENTER")) {
                        found = true;
                        break;
                    } else if (answer.equals("WRONG")) {
                        return;
                    }
                }
                if (found) {
                    found = false;
                    break;
                }
            }
            t++;
        }
    }
}
