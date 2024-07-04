import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(); // Number of tasks

            List<Pair> cameron = new ArrayList<>();
            List<Pair> jamie = new ArrayList<>();
            StringBuilder sb = new StringBuilder(n);

            for (int j = 0; j < n; j++){
                int s = in.nextInt();
                int e = in.nextInt();
                Pair newTask = new Pair(s, e);
                boolean cameronCollision = false;
                for (Pair existingTask : cameron){
                    if (isOverlap(existingTask, newTask)){
                        cameronCollision = true;
                        break;
                    }
                }
                if (cameronCollision){
                    boolean jamieCollision = false;
                    for (Pair existingTask : jamie){
                        if (isOverlap(existingTask, newTask)){
                            jamieCollision = true;
                            break;
                        }
                    }
                    if (jamieCollision){
                        sb.setLength(0);
                        sb.append("IMPOSSIBLE");
                        break;
                    }else{
                        jamie.add(newTask);
                        sb.append('J');
                    }
                }else{
                    cameron.add(newTask);
                    sb.append('C');
                }
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    private static boolean isOverlap(Pair p1, Pair p2){
        return p1.e > p2.s && p1.s < p2.e;
    }

    private static class Pair {
        public Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
        int s;
        int e;
    }
}