import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();
            LinkedList<Info> queue = new LinkedList<>();
            queue.add(new Info("", 0, 0, 0));
            String result = "IMPOSSIBLE";

            while (!queue.isEmpty()) {
                Info current = queue.poll();

                if (current.x == targetX && current.y == targetY) {
                    result = current.path;
                    break;
                }

                int nextStep = current.last == 0 ? 1 : current.last * 2;
                if (nextStep / 4 > Math.abs(targetX) + Math.abs(targetY)) break;

                queue.add(new Info(current.path + 'E', current.x + nextStep, current.y, nextStep));
                queue.add(new Info(current.path + 'W', current.x - nextStep, current.y, nextStep));
                queue.add(new Info(current.path + 'N', current.x, current.y + nextStep, nextStep));
                queue.add(new Info(current.path + 'S', current.x, current.y - nextStep, nextStep));
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}

class Info {
    String path;
    int x, y, last;

    Info(String path, int x, int y, int last) {
        this.path = path;
        this.x = x;
        this.y = y;
        this.last = last;
    }
}