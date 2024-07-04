import java.util.HashMap;
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

        int maxLen = 1000;
        HashMap<String, Integer> visited2 = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        visited2.put(0 + "-" + 0, 0);
        queue.add(new Node(0,0, 0));

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            for(int ii = 0; ii < dx.length; ii++) {
                int newX = n.x+dx[ii];
                int newY = n.y+dy[ii];
                if (Math.abs(newX) <= maxLen && Math.abs(newY) <= maxLen && !visited2.containsKey(newX + "-" + newY)){
                    queue.add(new Node(newX, newY, n.idx+1));
                    visited2.put(newX + "-" + newY, n.idx+1);
                }
            }
        }


        while(total-- > 0) {
            int solution = 1000000000;

            tests++;
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String path = scanner.next();

            int i = 0-y;
            int j = x;

            int idx = 0;
            if(visited2.containsKey(i + "-" + j) && visited2.get(i + "-" + j) <= idx){
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
                if(visited2.containsKey(i + "-" + j) && visited2.get(i + "-" + j) <= idx){
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
