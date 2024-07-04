import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfCases = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                int startX = scanner.nextInt();
                int startY = scanner.nextInt();
                String route = scanner.next();

                int currentX = startX;
                int currentY = startY;
                int routeLength = route.length();
                int time = 1;
                boolean isPossible = false;

                for (int i = 0; i < routeLength; i++) {
                    char direction = route.charAt(i);
                    switch (direction) {
                        case 'N':
                            currentY++;
                            break;
                        case 'S':
                            currentY--;
                            break;
                        case 'W':
                            currentX--;
                            break;
                        case 'E':
                            currentX++;
                            break;
                    }

                    if (Math.abs(currentX) + Math.abs(currentY) <= time) {
                        isPossible = true;
                        break;
                    } else {
                        time++;
                    }
                }

                String result = isPossible ? String.valueOf(time) : "IMPOSSIBLE";
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}