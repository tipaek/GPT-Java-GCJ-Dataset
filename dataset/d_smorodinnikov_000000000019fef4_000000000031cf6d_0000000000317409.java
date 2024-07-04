import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class Solution {


    static void solve() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            String s = scan.next();
//            int res = scase(n);
//            System.out.println(res);
            solveCase(i, x,y,s);
        }
    }


    static void solveCase(int t, int x, int y, String m) {

        Coord[] catCoord = new Coord[m.length()+1];
        catCoord[0] = new Coord(-x,y);
        for (int i=1;i<=m.length();i++) {
            char ch = m.charAt(i-1);
            if(ch == 'S'){
                catCoord[i] = new Coord(catCoord[i-1].x, catCoord[i-1].y - 1);
            } else if(ch == 'N'){
                catCoord[i] = new Coord(catCoord[i-1].x, catCoord[i-1].y + 1);
            }

        }

        List<Set<Coord>> myCoords = new ArrayList<>();
        Set<Coord> first = new HashSet<>();
        first.add(new Coord(0,0));
        myCoords.add(first);
        for (int i=1;i<=m.length();i++) {
            Set<Coord> set = new HashSet<>();
            for(Coord c: myCoords.get(i-1)) {
                Coord still = new Coord(c.x, c.y);
                Coord south = new Coord(c.x, c.y-1);
                Coord north = new Coord(c.x, c.y+1);
                Coord east = new Coord(c.x-1, c.y);
                Coord west = new Coord(c.x+1, c.y);

                set.add(still);
                set.add(south);
                set.add(north);
                set.add(east);
                set.add(west);
            }
            myCoords.add(set);
        }

        for (int i=1;i<=m.length();i++) {
            Set<Coord> set = myCoords.get(i);
            if(set.contains(catCoord[i])) {
                System.out.println("Case #" + (t+1) + ": " + i);
                return;
            }
        }
        System.out.println("Case #" + (t+1) + ": " + "IMPOSSIBLE");
//        System.out.println("Case #" + (t+1) + ": " + res);
    }



//    static int minSteps(Coord c1, Coord c2) {
//
//    }


    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x &&
                    y == coord.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }



//    static int scase(int n) {
//
//    }

    public static void main(String[] args) {

//
        solve();

        //        Main m = new Main();
        //        Scanner scan = new Scanner(System.in);

        //        long n = scan.nextLong();
        //        long r = scan.nextLong();
        //        List<Long> list = new ArrayList<>();
        ////        int[] arr = new int[n];
        //        for (long i=0;i<n;i++){
        //            list.add(scan.nextLong());
        //        }
//            System.out.println(ch);
        //        solve(n, arr);
        //        scan.close();
    }


//
//    class Counter extends HashMap<Integer, Integer> {
//        public int get(int k) {
//            return containsKey(k) ? super.get(k) : 0;
//        }
//
//        public void add(int k, int v) {
//            put(k, get(k) + v);
//        }
//    }


//    static class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.random = null;
//        }
//    }

//    static class Node {
//        int key;
//        int data;
//        Node next;
//        Node prev;
//
//        Node(int key, int data) {
//            this.key = key;
//            this.data = data;
//        }
//    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
