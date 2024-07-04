import java.util.*;

class Par {
    int x, y, no, r;
}

class SortByX implements Comparator<Par> {
    public int compare(Par a, Par b) {
        int x = a.x - b.x;
        if (x != 0)
            return x;
        else
            return a.y - b.y;
    }
}

class SortByNo implements Comparator<Par> {
    public int compare(Par a, Par b) {
        return a.no - b.no;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int q = 1; q <= t; q++) {
            System.out.print("Case #" + q + ": ");
            int n = sc.nextInt();
            List<Par> arr = new ArrayList<>();

            for (int k = 0; k < n; k++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Par s = new Par();
                s.x = x;
                s.y = y;
                s.no = k;
                s.r = 0;
                arr.add(s);
            }

            Collections.sort(arr, new SortByX());
            int aEnd = 0, bEnd = 0;
            boolean isPossible = true;

            for (Par p : arr) {
                if (p.x >= aEnd) {
                    aEnd = p.y;
                    p.r = 1;
                } else if (p.x >= bEnd) {
                    bEnd = p.y;
                    p.r = 2;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Impossible");
            } else {
                Collections.sort(arr, new SortByNo());
                StringBuilder result = new StringBuilder();
                for (Par p : arr) {
                    result.append(p.r == 1 ? "C" : "J");
                }
                System.out.println(result);
            }
        }
    }
}