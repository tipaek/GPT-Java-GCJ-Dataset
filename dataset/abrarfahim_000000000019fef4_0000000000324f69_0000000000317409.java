import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {



    static boolean contains(ArrayList<Node> list, Node a) {

        for(Node temp: list) {
            if(temp.mx == a.mx && temp.my == a.my && !a.stay) {
                return true;
            }

        }

        return false;
    }


    public static void main(String[] args) {


        int t;

        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            String m = sc.next();


            ArrayList<Node> visited = new ArrayList<>();

            LinkedList<Node> q = new LinkedList<>();


            Node root = new Node(0,0,x,y);
            root.time = 0;

            q.add(root);
            int px = x;
            int py = y;

            int time = -1;
            //boolean failed = false;


            while(!q.isEmpty()) {


                Node parent = q.poll();
                if(parent.stay) {
                    if(parent.mx == x && parent.mx == y) {
                        break;
                    }
                    else {
                        continue;
                    }
                }

                ArrayList<Node> children = parent.getChildren();

                for(Node child: children) {
                    px = x;
                    py = y;

                    if(contains(visited, child)) {
                        continue;
                    }
                    child.time = parent.time + 1;

                    if(child.time > m.length()) {
                        continue;
                    }

                    for(int j = 0; j < child.time; j++) {
                        switch(m.charAt(j)) {
                            case 'N':
                                py++;
                                break;
                            case 'S':
                                py--;
                                break;
                            case 'E':
                                px++;
                                break;
                            case 'W':
                                px--;
                                break;
                            default:
                                System.out.println("Default reached!!");
                        }
                    }

                    if(Math.abs(child.mx - px) > 2 * (m.length() - child.time)) {
                        continue;
                    }
                    if(Math.abs(child.my - py) > 2 * (m.length() - child.time)) {
                        continue;
                    }
                    if(child.mx == px && child.my == py) {
                        //goal found
                        time = child.time;
                        //System.out.println("found");
                        break;
                    }


                    //child.time = child.time + 1;
                    visited.add(child);
//                    for(Node n: visited) {
//                        System.out.println(n.mx + ", " + n.my + ";  ");
//                    }
                    q.add(child);

                }

                if(time > 0) {
                    break;
                }

            }


            //out

            System.out.println("Case #" + (i+1) + ": " + (time < 0 ? "IMPOSSIBLE": time));


        }


    }
}


class Node {
    int mx;
    int my;
    int px;
    int py;
    int pdx;
    int pdy;
    int time;
    boolean stay = false;

    public Node(int mx, int my, int px, int py, int pdx, int pdy, int time) {
        this.mx = mx;
        this.my = my;
        this.px = px;
        this.py = py;
        this.pdx = pdx;
        this.pdy = pdy;
        this.time = time;
    }

    public Node(int mx, int my, int px, int py) {
        this.mx = mx;
        this.my = my;
        this.px = px;
        this.py = py;
    }

    public Node(int mx, int my, boolean stay) {
        this.mx = mx;
        this.my = my;
        this.stay = stay;
    }

    ArrayList<Node> getChildren() {
        ArrayList<Node> list = new ArrayList<>();

        list.add(new Node(mx, my, true));
        list.add(new Node(mx + 1, my, false));
        list.add(new Node(mx - 1, my, false));
        list.add(new Node(mx, my + 1, false));
        list.add(new Node(mx, my - 1, false));

        return list;
    }
}
