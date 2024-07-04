import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            final String solution = solveCase(in);
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static String solveCase(Scanner in) {
        final int startX = in.nextInt();
        final int startY = in.nextInt();
        final String pathString = in.next();

        List<PathElement> pathElements = new ArrayList<>();

        final String[] path = pathString.split("");

        int currentX = startX;
        int currentY = startY;
        int moment = 0;

        pathElements.add(new PathElement(currentX,currentY,moment));

        for(String letter: path) {
            switch(letter) {

                case "N": currentY++;
                break;

                case "S": currentY--;
                break;

                case "W": currentX--;
                break;

                case "E": currentX++;
                break;
            }
            moment++;
            pathElements.add(new PathElement(currentX,currentY,moment));

        }

        pathElements = pathElements.stream().filter(e -> (Math.abs(e.x)+Math.abs(e.y))<=e.moment).collect(Collectors.toList());
        if(pathElements.isEmpty()) {
            return "IMPOSSIBLE";
        }

        pathElements.sort(Comparator.comparing((PathElement x) -> x.moment));

        return Integer.toString(pathElements.get(0).moment);
    }
}

class PathElement {
    int x;
    int y;
    int moment;

    public PathElement(int x, int y, int moment) {
        this.x = x;
        this.y = y;
        this.moment = moment;
    }
}