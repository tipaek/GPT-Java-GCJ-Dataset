import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


class Pair {
    int x;
    int y;
    String s;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
        s = new String();
    }

    public Pair(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }

    ArrayList<Pair> getChildren() {

        int term = (int) Math.pow(2, s.length());


        ArrayList<Pair> list = new ArrayList<>();


        list.add(new Pair(x + term, y, s + "E"));
        list.add(new Pair(x - term, y, s + "W"));
        list.add(new Pair(x, y + term, s + "N"));
        list.add(new Pair(x, y - term, s + "S"));
        return list;
    }
}

public class Solution {

    static boolean contains(ArrayList<Pair> list, Pair pair) {
        for(Pair p: list) {
            if((p.x == pair.x && p.y == pair.y) || (p.x == -pair.x && p.y == -pair.y)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {

            //input
            int x = sc.nextInt();
            int y = sc.nextInt();


            StringBuilder sb = new StringBuilder();
            String out = new String("hello");

            ArrayList<Pair> visited = new ArrayList<>();

            Stack<Pair> s = new Stack<>();


            s.push(new Pair(0,0));
            //int term = 1;

            boolean goal = false;

            while(!s.empty()) {

                Pair parent = s.pop();
                visited.add(parent);

                //System.out.println(parent.x + ", " + parent.y);

                ArrayList<Pair> children = parent.getChildren();

                for(Pair p: children) {


                    if(!contains(visited, p) && (Math.abs(p.x) <= Math.abs(x) && Math.abs(p.y) <= Math.abs(y))) {

                        //System.out.println(p.x + ", " + p.y);
                        //check if goal
                        if((p.x == x && p.y == y)) {
                            //build string
                            out = p.s;
                            goal = true;
                            break;
                        }
                        else if(p.x == -x && p.y == -y) {

                            char[] chars = p.s.toCharArray();


                            for(char c: chars) {
                                if(c == 'N') {
                                    sb.append('S');
                                }
                                else if(c == 'E') {
                                    sb.append('W');
                                }
                                else if(c == 'W') {
                                    sb.append('E');
                                }
                                else if(c == 'S') {
                                    sb.append('N');
                                }
                            }

                            out = sb.toString();

                            goal = true;

                            break;
                        }

                        else {
                            //not goal and within range
                            s.push(p);
                        }


                    }
                }

                if(goal) {
                    break;
                }
                //term = term * 2;
            }





            if(!goal) {
                out = "IMPOSSIBLE";
            }
            //if both even or both odd, impossible

            //else, jump one in odd direction to start

            //output
            System.out.println("Case #" + (i+1) + ": " + out);



        }
    }
}
