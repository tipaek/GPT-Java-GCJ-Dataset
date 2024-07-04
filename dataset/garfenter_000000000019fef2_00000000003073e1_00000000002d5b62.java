import java.util.*;
import java.io.*;

public class Solution {

    private static final double maxI = Math.sqrt(Long.MAX_VALUE);

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            Long endX = in.nextLong();
            Long endY = in.nextLong();
            String route = goToPoint(0l, 0l, 1l, endX, endY);
            System.out.println("Case #" + c + ": " + (route == null ? "IMPOSSIBLE" : route));
        }
    }

    private static String goToPoint(Long endX, Long endY, Long i, Long resultX, Long resultY) {
        if (endX == resultX && endY == resultY) {
            return "";
        }
        if (i > maxI) {
            return null;
        }
        Long nextPower = i + 1;
        long movement = (long) Math.pow(2, i - 1);
        //GO NORTH
        String foundN = goToPoint(endX, endY + movement, nextPower, resultX, resultY);
        foundN = foundN == null ? null : "N" + foundN;
        //GO SOUTH
        String foundS = goToPoint(endX, endY - movement, nextPower, resultX, resultY);
        foundS = foundS == null ? null : "S" + foundS;

        //GO WEST
        String foundW = goToPoint(endX + movement, endY, nextPower, resultX, resultY);
        foundW = foundW == null ? null : "E" + foundW;
        // GO EAST
        String foundE = goToPoint(endX - movement, endY, nextPower, resultX, resultY);
        foundE = foundE == null ? null : "W" + foundE;
        List<String> results = new ArrayList<>();
        if (foundN != null) {
            results.add(foundN);
        }
        if (foundS != null) {
            results.add(foundS);
        }
        if (foundE != null) {
            results.add(foundE);
        }
        if (foundW != null) {
            results.add(foundW);
        }
        if (results.isEmpty()) {
            return null;
        }
        Collections.sort(results, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return results.get(0);

    }

}
