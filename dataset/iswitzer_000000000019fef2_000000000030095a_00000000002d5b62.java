import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());

        ArrayList<String> answers = new ArrayList<>();
        for(int q=1; q<=cases; q++) {
            String coords = in.nextLine();

            Coord goal = new Coord(coords, "");
            Queue<Coord> steps = new LinkedList<>();
            steps.add(new Coord("0 0",""));
            String final_path = "IMPOSSIBLE";

            if(Math.abs(goal.x) % 2 + Math.abs(goal.y) % 2 == 1) {
                while (!steps.isEmpty()) {
                    Coord curr = steps.remove();
                    String path = curr.path;
                    if (curr.x == goal.x && curr.y == goal.y) {
                        final_path = path;
                        break;
                    }
                    int x;
                    int y;
                    int change = (int) Math.pow(2, path.length());
                    if(change > 1000000000) continue;

                    x = curr.x;
                    y = curr.y + change;
                    steps.add(new Coord(x + " " + y, path + "N"));

                    x = curr.x;
                    y = curr.y - change;
                    steps.add(new Coord(x + " " + y, path + "S"));

                    x = curr.x + change;
                    y = curr.y;
                    steps.add(new Coord(x + " " + y, path + "E"));

                    x = curr.x - change;
                    y = curr.y;
                    steps.add(new Coord(x + " " + y, path + "W"));

                }
            }
            answers.add("Case #" + q + ": " + final_path);
        }

        for(String s : answers) System.out.println(s);
    }

    private static class Coord {
        protected int x;
        protected int y;
        protected String path;

        public Coord(String c, String p) {
            this.x = Integer.parseInt(c.split(" ")[0]);
            this.y = Integer.parseInt(c.split(" ")[1]);
            this.path = p;
        }
    }
}
