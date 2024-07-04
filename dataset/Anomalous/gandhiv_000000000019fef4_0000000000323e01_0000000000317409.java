import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String moves = sc.next();
            
            int x1 = 0, y1 = 0;
            int x2 = x, y2 = y;
            boolean reached = false;
            boolean prioritizeX = y >= x;

            for (int i = 0; i < moves.length(); i++) {
                if (x1 == x2 && y1 == y2) {
                    reached = true;
                    System.out.println("Case #" + caseNum + ": " + (i + 1));
                    break;
                }

                char move = moves.charAt(i);
                if (move == 'S') {
                    y2--;
                } else if (move == 'N') {
                    y2++;
                } else if (move == 'W') {
                    x2--;
                } else if (move == 'E') {
                    x2++;
                }

                if (x1 == x2 && y1 == y2) {
                    reached = true;
                    System.out.println("Case #" + caseNum + ": " + (i + 1));
                    break;
                }

                if (prioritizeX) {
                    if (x1 == x) {
                        prioritizeX = false;
                    } else {
                        x1++;
                    }
                } else {
                    if (y1 == y) {
                        prioritizeX = true;
                    } else {
                        y1++;
                    }
                }

                if (x1 == x2 && y1 == y2) {
                    reached = true;
                    System.out.println("Case #" + caseNum + ": " + (i + 1));
                    break;
                }
            }

            if (!reached) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}