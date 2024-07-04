import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static ArrayList<String> answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            answer = new ArrayList<>();
            String[] inputs = scanner.nextLine().split(" ");
            int finalX = Integer.valueOf(inputs[0]);
            int finalY = Integer.valueOf(inputs[1]);
            String out;
            if ((finalX % 2 != 0 && finalY % 2 != 0) || (finalX % 2 == 0 && finalY % 2 == 0)) {
                out = "IMPOSSIBLE";
            } else {
                solve(finalX, finalY, "");
                answer.sort((o1, o2) -> o1.length() - o2.length());
                out = answer.get(0);
            }
            System.out.println("Case #" + (i + 1) + ": " + out);
        }
    }

    private static void solve(int finalX, int finalY, String current) {
        if (current.length() > 8) {
            return;
        }
        int currentX = 0;
        int currentY = 0;
        char[] charArray = current.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch (c) {
                case 'N':
                    currentY += Math.pow(2, i);
                    break;
                case 'W':
                    currentX -= Math.pow(2, i);
                    break;
                case 'S':
                    currentY -= Math.pow(2, i);
                    break;
                case 'E':
                    currentX += Math.pow(2, i);
                    break;
            }
        }
        if (currentX == finalX && currentY == finalY) {
            answer.add(current);
        } else {
            solve(finalX, finalY, current + "N");
            solve(finalX, finalY, current + "W");
            solve(finalX, finalY, current + "S");
            solve(finalX, finalY, current + "E");
        }
    }
}
