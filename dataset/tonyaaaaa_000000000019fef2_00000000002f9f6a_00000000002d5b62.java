import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            Map<String, String> paths = new HashMap<>();
            List<String> queue = new ArrayList<>();
            queue.add("0,0");
            paths.put("0,0", "");
            List<String> nextQueue = new ArrayList<>();
            int pow = 0;
            boolean found = false;
            while (!queue.isEmpty() && !found) {
                for (String point : queue) {
                    String[] split = point.split("\\,");
                    int i = Integer.parseInt(split[0]);
                    int j = Integer.parseInt(split[1]);
                    if (i == x && y == j) {
                        System.out.println("Case #" + test + ": " + paths.get(point));
                        found = true;
                        break;
                    }
                    int step = (int) Math.pow(2, pow);
                    String eKey = "" + (i + step)+ "," + j;
                    if (i + step < Math.abs(x*2) & !paths.containsKey(eKey)) {
                        paths.put(eKey, paths.get(i + "," + j) + "E");
                        nextQueue.add(eKey);
                    }
                    String wKey = "" + (i - step)+ "," + j;
                    if (i - step > -Math.abs(x*2) & !paths.containsKey(wKey)) {
                        paths.put(wKey, paths.get(i + "," + j) + "W");
                        nextQueue.add(wKey);
                    }
                    String nKey = i + "," + (j + step);
                    if (j + step < Math.abs(y*2) & !paths.containsKey(nKey)) {
                        paths.put(nKey, paths.get(i + "," + j) + "N");
                        nextQueue.add(nKey);
                    }
                    String sKey = i + "," + (j - step);
                    if (j - step > -Math.abs(y*2) & !paths.containsKey(sKey)) {
                        paths.put(sKey, paths.get(i + "," + j) + "S");
                        nextQueue.add(sKey);
                    }
                }
                queue = nextQueue;
                nextQueue = new ArrayList<>();
                pow++;
            }
            if (!found)
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
        }
    }
}
