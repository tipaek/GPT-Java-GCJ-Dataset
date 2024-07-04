import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println("Case #"+t+": "+getAnswer(scanner,T,A,B));
        }
    }
    // Guess radius R  and center (X,Y)
    // Case 1 we know radius = 10^9-5
    public static void findAnswer(Scanner scanner,int T,int A,int B) {
        boolean found = false;
        int t = 0;
        while (t < T) {
            for (int i=-5;i <= 5; i++) {
                for (int j=-5; j <=5; j++) {
                    System.out.println(i+" "+j);
                    if (scanner.next().equals("CENTER")) {
                        found = true;
                        break;
                    }
                }
                if (found = true) {
                    t++;
                    found = false;
                    break;
                }
            }
        }
    }
}
