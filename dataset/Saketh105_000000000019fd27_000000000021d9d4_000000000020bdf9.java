import java.io.*;
import java.util.*;
import java.util.Map.Entry;

 class entry {

    public int start;
    public int end;
    public int index;

    public entry(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Group implements Comparator<entry> {

    public int compare(entry a, entry b) {
        return a.start - b.start;
    }
}
 class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            PriorityQueue<entry> p = new PriorityQueue<>(new Group());
            for (int k = 0; k < n; k++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                entry a = new entry(start, end, k);
                p.add(a);
            }

            String sol = solve(p);
            System.out.println("Case #" + (i + 1) + ": " + sol);
        }
    }

    public static String solve(PriorityQueue<entry> p) {
        String sol = "";
        //StringBuilder sol = new StringBuilder(1000);
        String[] arr = new String[p.size()];
        boolean isJoccupied = false;
        boolean isCoccupied = false;
        String next = "J";
        int startJ = 0;
        int endJ = 0;
        int startC = 0;
        int endC = 0;
        while (!p.isEmpty()) {
            //Entry<Integer, Integer> e = t.pollFirstEntry();
            entry e = p.poll();
            if (endC <= e.start && endC <= e.end) {
                isCoccupied = false;
            }
            if (endJ <= e.start && endJ <= e.end) {
                isJoccupied = false;
            }
            if (isJoccupied && isCoccupied) {
                return "IMPOSSIBLE";
            } else {
                if (!isJoccupied) {
                    startJ = e.start;
                    endJ = e.end;
                    isJoccupied = true;
                    arr[e.index] = "J";
                    //sol.insert(e.index, "J");// += "J";
                } else if (!isCoccupied) {
                    startC = e.start;
                    endC = e.end;
                    isCoccupied = true;
                    arr[e.index] = "C";
                    //sol.insert(e.index, "C");// += "C";
                }
            }
        }
        for(String s: arr){
        sol+=s;
        }
        return sol;
    }
}