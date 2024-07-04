import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {


    public static void main (String[] args) {

        int[] dx = {0, 0 , 1, -1};
        int[] dy = {1, -1 , 0, 0};

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int tests = 0;

        while(total-- > 0) {
            tests++;
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String path = scanner.next();

            int len = Math.max(x+path.length(), y+path.length());

            int[][] visited = new int[len*2][len*2];
            for(int i = 0; i < visited.length; i++) {
                Arrays.fill(visited[i], 1000000);
            }

            Queue<Node> queue = new LinkedList<>();
            visited[len][len] = Math.min(visited[len][len], 0);
            int solution = 1000000000;
            queue.add(new Node(len, len, 0));

            while(!queue.isEmpty()) {
                Node n = queue.poll();

                for(int ii = 0; ii < dx.length; ii++) {
                    int newX = n.x+dx[ii];
                    int newY = n.y+dy[ii];
                    if (newX < visited.length && newY < visited[0].length && newX >= 0 && newY >= 0 && visited[newX][newY]== 1000000) {
                        queue.add(new Node(newX, newY, n.idx+1));
                        visited[newX][newY] = n.idx+1;
                    }
                }
            }

            int i = (len)-y;
            int j = (len)+x;

            int idx = 0;
            if(visited[i][j] <= idx){
                solution = Math.min(idx, solution);
            }

            while(idx < path.length()) {
                //N, E, S or W
                switch (path.charAt(idx)) {
                    case 'N': i--; break;
                    case 'E': j++; break;
                    case 'S': i++; break;
                    case 'W': j--; break;
                }
                idx++;
                if(visited[i][j] <= idx){
                    solution = Math.min(idx, solution);
                }
            }

            if (solution != 1000000000) {
                System.out.println("Case #" + tests + ": " + solution);
            } else {
                System.out.println("Case #" + tests + ": IMPOSSIBLE");
            }
        }
    }
    public static class Node {
        int x;
        int y;
        int idx;
        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
