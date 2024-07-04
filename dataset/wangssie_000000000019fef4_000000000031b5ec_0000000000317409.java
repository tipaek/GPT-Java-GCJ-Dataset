import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int t=1; t<=T; t++) {
            int xPep = input.nextInt();
            int yPep = input.nextInt();
            String route = input.nextLine().replace(" ", "");

            int timeTaken=-1;
            char nextMove;
            for (int time=0; time<route.length()+1; time++) {
                if (findDistance(0, 0, xPep, yPep)<=time) {
                    timeTaken = time;
                    break;
                }
                if (time<route.length()) {
                    nextMove = route.charAt(time);
                    switch (nextMove) {
                        case 'S':
                            yPep -= 1;
                            break;
                        case 'N':
                            yPep += 1;
                            break;
                        case 'E':
                            xPep += 1;
                            break;
                        case 'W':
                            xPep -= 1;
                            break;
                    }
                }
            }
            System.out.print("Case #"+t+": ");
            if (timeTaken!=-1) {
                System.out.println(timeTaken);
            }
            else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }
    private static int findDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
