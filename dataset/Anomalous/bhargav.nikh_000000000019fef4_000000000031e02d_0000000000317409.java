import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().solveCases();
    }

    private Map<Character, Node> directionMap;

    private class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void solveCases() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());
        initializeDirectionMap();
        for (int i = 1; i <= numberOfCases; i++) {
            processCase(i, reader);
        }
    }

    private void processCase(int caseNumber, BufferedReader reader) throws Exception {
        String[] input = reader.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        String path = input[2];
        findSolution(caseNumber, x, y, path);
    }

    private void initializeDirectionMap() {
        directionMap = new HashMap<>();
        directionMap.put('N', new Node(0, 1));
        directionMap.put('S', new Node(0, -1));
        directionMap.put('E', new Node(1, 0));
        directionMap.put('W', new Node(-1, 0));
    }

    private void findSolution(int caseNumber, int x, int y, String path) {
        int distance = -1;
        if (x == 0 && y == 0) {
            printDistance(caseNumber, 0);
            return;
        }

        int currentX = x, currentY = y;
        for (int i = 0; i < path.length(); i++) {
            int steps = i + 1;
            Node direction = directionMap.get(path.charAt(i));
            currentX += direction.x;
            currentY += direction.y;

            int currentDistance = Math.abs(currentX) + Math.abs(currentY);
            if (currentDistance <= steps) {
                distance = steps;
                break;
            }
        }
        printDistance(caseNumber, distance);
    }

    private void printDistance(int caseNumber, int distance) {
        if (distance != -1) {
            System.out.println("Case #" + caseNumber + ": " + distance);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}