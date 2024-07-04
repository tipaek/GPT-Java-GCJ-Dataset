import java.util.*;
import java.io.*;

class Path {
    int r, c;
    String path;
    
    Path(int r, int c, String path) {
        this.r = r;
        this.c = c;
        this.path = path;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String res = "IMPOSSIBLE";
            
            if ((x + y) % 2 != 0) {
                Queue<Path> queue = new LinkedList<>();
                queue.add(new Path(0, 0, ""));
                int level = 0;

                while (!queue.isEmpty()) {
                    if (level > 32) break;
                    
                    int step = (1 << level);
                    int size = queue.size();
                    
                    for (int i = 0; i < size; i++) {
                        Path current = queue.poll();
                        
                        if (current.c == x && current.r == y) {
                            res = current.path;
                            queue.clear();
                            break;
                        }
                        
                        if (Math.abs(current.c + step - x) <= (1 << (32 - level))) {
                            queue.add(new Path(current.r, current.c + step, current.path + "E"));
                        }
                        if (Math.abs(current.c - step - x) <= (1 << (32 - level))) {
                            queue.add(new Path(current.r, current.c - step, current.path + "W"));
                        }
                        if (Math.abs(current.r + step - y) <= (1 << (32 - level))) {
                            queue.add(new Path(current.r + step, current.c, current.path + "N"));
                        }
                        if (Math.abs(current.r - step - y) <= (1 << (32 - level))) {
                            queue.add(new Path(current.r - step, current.c, current.path + "S"));
                        }
                    }
                    
                    level++;
                }
            }
            
            System.out.println("Case #" + k + ": " + res);
        }
    }
}