import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        int[] pepperPosition = new int[2];
        int[] playerPosition = new int[2];

        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        for(int c = 1; c <= numCases; c++) {
            String input = scanner.nextLine();
            String[] inputs = input.split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);
            String pepperMovement = inputs[2];
            char[] charPepperMovement = pepperMovement.toCharArray();
            pepperPosition[0] = x;
            pepperPosition[1] = y;
            playerPosition[0] = 0;
            playerPosition[1] = 0;
            // To shorten the time we should remove every NS pair
            int bestMeet = Integer.MAX_VALUE;
            for(int ch = 0; ch <= charPepperMovement.length; ch++) {
                if(shortestPathMoves(pepperPosition) < bestMeet && shortestPathMoves(pepperPosition) <= ch) {
                    bestMeet = ch;
                    break;
                }
                // Update peppers position
                if(ch != charPepperMovement.length) {
                    if (charPepperMovement[ch] == 'N') {
                        pepperPosition[1] = pepperPosition[1] + 1;
                    } else if (charPepperMovement[ch] == 'S') {
                        pepperPosition[1] = pepperPosition[1] - 1;
                    }
                }
            }
            if(bestMeet == Integer.MAX_VALUE) {
                System.out.printf("Case #%s: IMPOSSIBLE%n", c);
            } else {
                System.out.printf("Case #%s: %s%n", c, bestMeet);
            }
        }
    }

    public static int shortestPathMoves(int[] end) {
        return Math.abs(end[0]) + Math.abs(end[1]);
    }

}
