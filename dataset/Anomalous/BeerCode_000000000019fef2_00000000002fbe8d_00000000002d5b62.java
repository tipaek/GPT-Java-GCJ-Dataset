import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            LinkedList<Step> queue = new LinkedList<>();
            queue.add(new Step("", 0, 0, 0));
            String result = "IMPOSSIBLE";
            
            while (!queue.isEmpty()) {
                Step current = queue.poll();
                if (current.x == targetX && current.y == targetY) {
                    result = current.path;
                    break;
                }
                
                int nextStep = current.lastStep == 0 ? 1 : current.lastStep * 2;
                if (nextStep / 2 > Math.abs(targetX) + Math.abs(targetY)) {
                    break;
                }
                
                queue.add(new Step(current.path + 'E', current.x + nextStep, current.y, nextStep));
                queue.add(new Step(current.path + 'W', current.x - nextStep, current.y, nextStep));
                queue.add(new Step(current.path + 'N', current.x, current.y + nextStep, nextStep));
                queue.add(new Step(current.path + 'S', current.x, current.y - nextStep, nextStep));
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
        scanner.close();
    }
}

class Step {
    String path;
    int x, y, lastStep;
    
    Step(String path, int x, int y, int lastStep) {
        this.path = path;
        this.x = x;
        this.y = y;
        this.lastStep = lastStep;
    }
}