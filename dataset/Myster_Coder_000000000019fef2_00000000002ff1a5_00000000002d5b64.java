import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t, r, s;
        t = Integer.parseInt(in.readLine());
        for (int a = 0; a < t; a++) {
            String str[] = in.readLine().split(" ");
            r = Integer.parseInt(str[0]);
            s = Integer.parseInt(str[1]);
            ArrayList<Point> deck = new ArrayList<>();
            for (int b = 1; b <= s; b++) {
                for (int c = 1; c <= r; c++) {
                    Point point = new Point(c, b);
                    deck.add(point);
                }
            }
            ArrayList<Point> seperations = new ArrayList<>();
            int pos = (r * s) - 1;
            int turn=0;
            while (pos != 0) {
                if (deck.get(pos).x == deck.get(pos - 1).x) {
                    pos--;
                    continue;
                }
                int lastPos = -1;
                if (turn % 2 == 1) {
                    for (int b = pos - 1; b >= 0; b--) {
                        if (deck.get(b).x == deck.get(pos).x) {
                            lastPos = b;
                            List<Point> listA = deck.subList(0, lastPos + 1);
                            List<Point> listB = deck.subList(lastPos + 1, pos);
                            List<Point> oldList = deck.subList(pos, deck.size());
                            deck = new ArrayList<>();
                            deck.addAll(listB);
                            deck.addAll(listA);
                            deck.addAll(oldList);
                            seperations.add(new Point(listA.size(), listB.size()));
                            pos--;
                            break;
                        }
                    }
                } else {
                    for (int b = 0; b < pos; b++) {
                        if (deck.get(b).x == deck.get(pos).x) {
                            lastPos = b;
                            List<Point> listA = deck.subList(0, lastPos + 1);
                            List<Point> listB = deck.subList(lastPos + 1, pos);
                            List<Point> oldList = deck.subList(pos, deck.size());
                            deck = new ArrayList<>();
                            deck.addAll(listB);
                            deck.addAll(listA);
                            deck.addAll(oldList);
                            seperations.add(new Point(listA.size(), listB.size()));
                            pos--;
                            break;
                        }
                    }
                }
                turn++;
                if (lastPos == -1)
                    pos--;
            }
            out.println("Case #" + (a + 1) + ": " + seperations.size());
            for (Point point :
                    seperations) {
                out.println(point.x + " " + point.y);
            }
        }
        out.close();
    }
}