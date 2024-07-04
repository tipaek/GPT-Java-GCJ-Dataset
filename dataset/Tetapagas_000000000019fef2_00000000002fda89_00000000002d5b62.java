import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int cases = in.nextInt();

		for(int n=0; n<cases; n++) {
			solveCase(n+1);
		}
    }

    private static void solveCase(int nth) {
        int targetX = in.nextInt();
        int targetY = in.nextInt();

        if(targetX % 2 != 0 && targetY % 2 != 0) {
            System.out.println("Case #" + nth + ": IMPOSSIBLE");
            return;
        }

        if(targetX % 2 == 0 && targetY % 2 == 0) {
            System.out.println("Case #" + nth + ": IMPOSSIBLE");
            return;
        }

        int step = 0;
        List<Path> paths = new LinkedList<>();
        paths.add(new Path(0, 0, new StringBuilder()));

        Path solution = null;
        while(solution == null) {
            List<Path> nextPaths = new LinkedList<>();
            for(Path path : paths) {
                if(path.x == targetX && path.y == targetY) {
                    solution = path;
                    break;
                }

                String ans = path.sb.toString();
                StringBuilder sb = new StringBuilder(ans);
                sb.append('W');
                nextPaths.add(new Path(path.x-(int)Math.pow(2,step), path.y, sb));
                sb = new StringBuilder(ans);
                sb.append('E');
                nextPaths.add(new Path(path.x+(int)Math.pow(2,step), path.y, sb));
                sb = new StringBuilder(ans);
                sb.append('S');
                nextPaths.add(new Path(path.x, path.y-(int)Math.pow(2,step), sb));
                sb = new StringBuilder(ans);
                sb.append('N');
                nextPaths.add(new Path(path.x, path.y+(int)Math.pow(2,step), sb));

                path.sb.delete(0, path.sb.length());
            }
            paths = nextPaths;
            step++;
        }

        System.out.println("Case #" + nth + ": " + solution.sb.toString());
    }

    static class Path {
        int step;
        int x;
        int y;
        StringBuilder sb;

        public Path(int x, int y, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.sb = sb;
        }
    }
}