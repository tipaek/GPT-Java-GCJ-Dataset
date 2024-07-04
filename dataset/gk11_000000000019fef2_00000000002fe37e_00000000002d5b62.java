import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t=1; t<=T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int d0 = abs(X)+abs(Y);
        int steps = pow2Above(d0);
        List<Point> q = new LinkedList<>();
        q.add(new Point(X,Y,1<<(steps-1),new LinkedList<>()));
        while (q.size() != 0) {
            Point a = q.get(0); q.remove(0);
            if (a.x==0 && a.y==0) {
                StringBuilder sb = new StringBuilder();
                for (Character c : a.revpath) {
                    sb.append(c);
                }
                System.out.println("Case #"+t+": "+sb.toString());
                return;
            }
            Point N = new Point(a.x,a.y+a.jump, a.jump /2,new LinkedList<>(a.revpath));
            Point E = new Point(a.x+a.jump, a.y, a.jump/2,new LinkedList<>(a.revpath));
            Point S = new Point(a.x, a.y-a.jump, a.jump/2,new LinkedList<>(a.revpath));
            Point W = new Point(a.x-a.jump, a.y, a.jump/2,new LinkedList<>(a.revpath));
            N.revpath.add(0, 'S');
            E.revpath.add(0, 'W');
            S.revpath.add(0, 'N');
            W.revpath.add(0, 'E');
            if (withinReach(N)) q.add(N);
            if (withinReach(E)) q.add(E);
            if (withinReach(S)) q.add(S);
            if (withinReach(W)) q.add(W);
        }
        System.out.println("Case #"+t+": IMPOSSIBLE");
    }

    public static boolean withinReach(Point a) {
        if (a.x==0 && a.y==0)
            return true;
        return abs(a.x)+abs(a.y) <= 2*a.jump-1;
    }

    public static int pow2Above(int x) {
        int s=0;
        while ((1<<s) < x) {
            s++;
        }
        return s;
    }
}

class Point {
    int x,y;
    int jump;
    List<Character> revpath;
    Point(int x,int y, int jump, List<Character> revpath){
        this.x=x;this.y=y;this.jump=jump;
        this.revpath=revpath;
    }
};
