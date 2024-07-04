import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static class Point {
        private int x;
        private int y;
        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
        public int distance(Point p)
        {
            return Math.abs(x - p.getX()) + Math.abs(y - p.getY());
        }
    }

    public static Point actualizarPunto(Point p, String str)
    {
        char c = str.charAt(0);

        switch (c) {
            case 'S': return new Point(p.x, p.y - 1);
            case 'N': return new Point(p.x, p.y + 1);
            case 'E': return new Point(p.x + 1, p.y);
            case 'W': return new Point(p.x - 1, p.y);
            default: return (null);
        }
    }

    public static Integer solveProblem(Point inicial, Point x, String pila, int pasosDados)
    {
        int distance = x.distance(new Point(0, 0));
        if (distance <= pasosDados)
            return (pasosDados);
        else if (pila.length() == 0)
            return (null);
        else {
            Point nuevoX = actualizarPunto(x, pila);
            pila = pila.substring(1, pila.length());
            return solveProblem(inicial, nuevoX, pila, pasosDados + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cases; i++) {
            String[] strtab = scan.nextLine().split(" ");
            Point inicial = new Point(Integer.parseInt(strtab[0]), Integer.parseInt(strtab[1]));
            Point variable = new Point(Integer.parseInt(strtab[0]), Integer.parseInt(strtab[1]));
            Integer res = solveProblem(inicial, variable, strtab[2], 0);
            System.out.println("Case #" + (i + 1) + ": " + ((res == null) ? "IMPOSSIBLE" : res));
        }

    }
}
