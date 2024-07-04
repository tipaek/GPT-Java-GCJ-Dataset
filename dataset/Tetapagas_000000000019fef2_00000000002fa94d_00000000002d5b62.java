import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static List<String> paths = new LinkedList<>();

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
        paths.add(new Path(0, 0, 0, ""));

        Path solution = null;
        while(solution == null) {
            List<Path> nextPaths = new LinkedList<>();
            for(Path path : paths) {
                if(path.x == targetX && path.y == targetY) {
                    solution = path;
                    break;
                }

                nextPaths.add(new Path(step, path.x-(int)Math.pow(2,step), path.y, path.ans+"W"));
                nextPaths.add(new Path(step, path.x+(int)Math.pow(2,step), path.y, path.ans+"E"));
                nextPaths.add(new Path(step, path.x, path.y-(int)Math.pow(2,step), path.ans+"S"));
                nextPaths.add(new Path(step, path.x, path.y+(int)Math.pow(2,step), path.ans+"N"));
            }
            paths = nextPaths;
            step++;
        }

        System.out.println("Case #" + nth + ": " + solution.ans);
    }

    static class Path {
        int step;
        int x;
        int y;
        String ans;

        public Path(int step, int x, int y, String ans) {
            this.step = step;
            this.x = x;
            this.y = y;
            this.ans = ans;
        }
    }
}