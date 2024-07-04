import java.util.*;
import java.io.*;

class Node {
    Long x;
    Long y;
    String path;

    public Node(Long x, Long y, String str) {
        this.x = x;
        this.y = y;
        this.path = str;
    }
}


class Solution {
    public static String pogo(Long x, Long y) {
        if(Math.abs(x) == Math.abs(y)) return "IMPOSSIBLE";


        int dist = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(new Long(0), new Long(1), "N"));
        q.offer(new Node(new Long(-1), new Long(0), "W"));
        q.offer(new Node(new Long(0), new Long(-1), "S"));
        q.offer(new Node(new Long(1), new Long(0), "E"));
        char[] dirc = new char[]{'N', 'E', 'S', 'W'};

        // N, E, S, W
        int[] cardinals = new int[]{0,1,0,-1,0};

        while(!q.isEmpty()) {
            if(dist > 100) return "IMPOSSIBLE";

            int size = q.size();
            Long jmp = (long) Math.pow(2, dist);
            while(size-- > 0) {
                Node curr = q.poll();

                for(int i = 1; i < cardinals.length; i++) {
                    Long new_x = curr.x + cardinals[i-1]*jmp;
                    Long new_y = curr.y + cardinals[i]*jmp;
                    String newPath = curr.path + dirc[i-1];
                    
                    if(x == new_x && y == new_y) {

                        return newPath;
                    } else {
                        q.offer(new Node(new_x, new_y, newPath));
                    }
                }
            }
            dist++;
        }
        

        return "IMPOSSIBLE";
    }
     public static void main(String[] args) throws Exception {
        // File file = new File("./input.txt");
        // Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); //# of testcases

        for (int i = 1; i <= t; ++i) {
            Long X = in.nextLong();
            Long Y = in.nextLong();
          
            System.out.println("Case #" + i + ": " + pogo(X, Y));
        }
        in.close();
    }
}