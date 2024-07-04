import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static  class Path{
        public int i;
        public int j;
        Path(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public String toString() {
            return "Path - "+this.i+this.j;
        }

    }
    static List<Path> pathList = new ArrayList<>();
    public static void main(String... a) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= t; ++test) {
            int n = in.nextInt();
            int m = in.nextInt();
            String catPath = in.next();
            pathList = new ArrayList<>();
            Path prevPath = new Path(0,n);
            pathList.add(prevPath);
            Path currentPath;
            for(int i=0; i<catPath.length(); i++) {
                switch(catPath.charAt(i)) {
                    case 'S':
                        currentPath = new Path(prevPath.i+1, prevPath.j);
                        break;
                    case 'N':
                        currentPath = new Path(prevPath.i-1, prevPath.j);
                        break;
                    case 'W':
                        currentPath = new Path(prevPath.i, prevPath.j-1);
                        break;
                    case 'E':
                        currentPath = new Path(prevPath.i, prevPath.j+1);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + catPath.charAt(i));
                }
                prevPath = currentPath;
                pathList.add(prevPath);
            }

            //System.out.println(pathList);
            int i =0;
            Path myPos = new Path(m, 0);
            int my_i = m;
            int my_j = 0;
            int ans = -1;
            for(Path path : pathList) {
//                if(path.i > m || path.j >n) {
//                    continue;
//                }
                int steps = Math.abs(my_i - path.i) + Math.abs(path.j - my_j);
                if((i - steps) >= 0) {
                    ans = i;
                    break;
                }
                i++;
            }
            if(ans == -1) {
                System.out.println("Case #"+test+": IMPOSSIBLE");
            }else{
                System.out.println("Case #"+test+": "+ans);
            }
        }
    }
}
