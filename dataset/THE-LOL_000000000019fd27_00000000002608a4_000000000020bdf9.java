
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int testCases = 0;
        int N = 0;
        String input = "";
        String output = "";
        Set<Point> overlap = new HashSet<>();
        Set<Integer> cameron = new HashSet<>();
        Set<Integer> jamie = new HashSet<>();
        List<Integer> all = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCases = in.nextInt();
        for(int t = 0; t < testCases; t++){//testCases
            N = in.nextInt();
            Point[] tasks = new Point[N];
            for(int i = 0; i < N; i++){
                int start = in.nextInt();
                int end = in.nextInt();
                Point task = new Point(start, end);
                tasks[i] = task;
            }
            for(int i = 0; i < tasks.length; i++){
                all.add(i);
                cameron.add(i);
                for(int j = 0; j < tasks.length; j++){
                    if((tasks[j].x > tasks[i].x && tasks[j].x < tasks[i].y) || (tasks[j].x > tasks[i].x && tasks[j].y > tasks[i].y)){
                        Point lap = new Point(i,j);
                        overlap.add(lap);
                    }
                }
            }
            for(int i = 0; i < all.size(); i++){
                for(int j = i; j < all.size(); j++){
                    Point p1 = new Point(i,j);
                    Point p2 = new Point(j,i);
                    if(overlap.contains(p1) || overlap.contains(p2)){
                        cameron.remove(j);
                        all.remove(j);
                        jamie.add(j);
                    }
                }
            }
            if(overlap.size() == N) output = "IMPOSSIBLE";
            else{
                for(int a = 0; a < N; a++){
                    if(cameron.contains(a)) output += "C";
                    else output += "J";
                }
            }
            System.out.print("Case #"+(t+1) +": "+output + "\n");
            output = "";
            cameron.clear();
            jamie.clear();
            overlap.clear();
        }
    }
}

