import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int currentX = 0, currentY = 0, result = -1;

            String moves = sc.next();

            for (int i = 0; i < moves.length(); i++) {
                char move = moves.charAt(i);

                if (move == 'N') {
                    y++;
                } else {
                    y--;
                }

                if (currentX < x) {
                    currentX++;
                    if (currentY == y && currentX == x) {
                        result = i + 1;
                        break;
                    }
                } else {
                    if (currentY == y) {
                        result = i + 1;
                        break;
                    } else {
                        if (currentY < y) {
                            currentY++;
                            if (currentY == y) {
                                result = i + 1;
                                break;
                            }
                        } else {
                            currentY--;
                            if (currentY == y) {
                                result = i + 1;
                                break;
                            }
                        }
                    }
                }
            }

            if (result == -1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }

            t--;
            caseNumber++;
        }
    }
}