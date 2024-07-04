import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public class State {

        int starx;
        int stary;
        int time;
        int currentx;
        int currenty;
        String tourPathRem;
        String pathTaken;

        public State(int starx, int stary, int time, int currentx, int currenty, String tourPathRem, String pathTaken) {
            this.starx = starx;
            this.stary = stary;
            this.time = time;
            this.currentx = currentx;
            this.currenty = currenty;
            this.tourPathRem = tourPathRem;
            this.pathTaken = pathTaken;
        }
    }

    public void shortestRoute(int caseno, int x, int y, String route) {
        bfs(caseno, -1 * x, y, 0, 0, 0, route, "");
    }

    public void bfs(int caseno, int x, int y, int i, int cx, int cy, String route, String currentPath) {
        Queue<State> queue = new LinkedList();
        queue.add(new State(x, y, i, cx, cy, route, currentPath));

        while (!queue.isEmpty()) {
            State current = queue.remove();
            if (current.starx == current.currentx && current.stary == current.currenty) {
                System.out.format("Case #%d: %d", caseno, current.time);
                System.out.println();
                return;
            } else if (!current.tourPathRem.isEmpty()) {
                int[] newCordinatesStar = newCoordinates(current.starx, current.stary, current.tourPathRem.charAt(0));

                //east
                int[] newCordinateOfPerson = newCoordinates(current.currentx, current.currenty, 'E');
                State east = new State(newCordinatesStar[0], newCordinatesStar[1], current.time + 1,
                        newCordinateOfPerson[0], newCordinateOfPerson[1], current.tourPathRem.substring(1), current.pathTaken.concat("E"));
                // north
                newCordinateOfPerson = newCoordinates(current.currentx, current.currenty, 'N');
                State north = new State(newCordinatesStar[0], newCordinatesStar[1], current.time + 1,
                        newCordinateOfPerson[0], newCordinateOfPerson[1], current.tourPathRem.substring(1), current.pathTaken.concat("N"));
                //south
                newCordinateOfPerson = newCoordinates(current.currentx, current.currenty, 'S');
                State south = new State(newCordinatesStar[0], newCordinatesStar[1], current.time + 1,
                        newCordinateOfPerson[0], newCordinateOfPerson[1], current.tourPathRem.substring(1), current.pathTaken.concat("S"));

                // wait
                State wait = new State(newCordinatesStar[0], newCordinatesStar[1], current.time + 1,
                        current.currentx, current.currenty, current.tourPathRem.substring(1), current.pathTaken);

                queue.add(east);
                queue.add(north);
                queue.add(south);
                queue.add(wait);
            }
        }
        System.out.format("Case #%d: %s", caseno, "IMPOSSIBLE");
        System.out.println();
    }

    public int[] newCoordinates(int x, int y, char dir) {
        int newx = x;
        int newy = y;
        if (dir == 'S') {
            newy--;
        } else if (dir == 'N') {
            newy++;
        } else if (dir == 'E') {
            newx--;
        } else if (dir == 'W') {
            newx++;
        }
        return new int[]{newx, newy};
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution v = new Solution();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String path = sc.nextLine().trim();
            v.shortestRoute(t, x, y, path);
        }
    }
}
