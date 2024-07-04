import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CNAME = MethodHandles.lookup().lookupClass().getName();
    private static final Random RAND = new Random();

    private static String join(Collection<?> objs) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = objs.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CNAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String moves = scanner.next();
            int currentX = startX;
            int currentY = startY;
            int resultTime = -1;

            for (int i = 0; i <= moves.length(); i++) {
                if (Math.abs(currentX) + Math.abs(currentY) <= i) {
                    resultTime = i;
                    break;
                }
                if (i < moves.length()) {
                    char move = moves.charAt(i);
                    switch (move) {
                        case 'N':
                            currentY++;
                            break;
                        case 'E':
                            currentX++;
                            break;
                        case 'S':
                            currentY--;
                            break;
                        case 'W':
                            currentX--;
                            break;
                    }
                }
            }

            if (resultTime < 0) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            } else {
                System.out.printf("Case #%d: %d%n", t, resultTime);
            }
        }
        scanner.close();
    }
}