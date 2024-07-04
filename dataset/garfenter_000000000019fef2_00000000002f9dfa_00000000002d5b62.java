import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int endX = in.nextInt();
            int endY = in.nextInt();
            String route = goToPoint(0, 0, 1, endX, endY);
            System.out.println("Case #" + c + ": " + (route == null ? "IMPOSSIBLE" : route));
        }
    }

    private static String goToPoint(int endX, int endY, int i, int resultX, int resultY) {
        if (endX == resultX && endY == resultY) {
            return "";
        }
        if (i > 46340) {
            return null;
        }
        int nextPower = i == 1 ? 2 : i * i;
        //GO NORTH
        String foundN = goToPoint(endX, endY + i, nextPower, resultX, resultY);
        foundN = foundN == null ? null : "N" + foundN;
        //GO SOUTH
        String foundS = goToPoint(endX, endY - i, nextPower, resultX, resultY);
        foundS = foundS == null ? null : "S" + foundS;

        //GO WEST
        String foundW = goToPoint(endX + i, endY, nextPower, resultX, resultY);
        foundW = foundW == null ? null : "E" + foundW;
        // GO EAST
        String foundE = goToPoint(endX - i, endY, nextPower, resultX, resultY);
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
