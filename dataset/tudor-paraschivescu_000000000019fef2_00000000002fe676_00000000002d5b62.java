import javax.imageio.ImageTranscoder;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testNr = 1; testNr <= t; testNr++) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            List<Integer> stepsX = toBinary(Math.abs(x));
            List<Integer> stepsY = toBinary(Math.abs(y));

            char posDirX = x > 0 ? 'E' : 'W';
            char posDirY = y > 0 ? 'N' : 'S';
            char negDirX = getOpposite(posDirX);
            char negDirY = getOpposite(posDirY);

            int nIter = Math.min(stepsX.size(), stepsY.size());

            for (int i = 0; i < nIter; i++) {
                if ((stepsX.get(i) == 0 && stepsY.get(i) == 0)
                        || !stepsX.get(i).equals(stepsY.get(i))) {
                    // All good so far, but this might change in the future
                    continue;
                }

                if (stepsY.size() == i + 1) {
                    stepsY.add(0);
                }
                stepsY.set(i + 1, 1);

                int numberToReduce = (int) Math.abs(Math.pow(2, i) - Math.abs(y));
                List<Integer> binToReduce = toBinary(numberToReduce);
                for (int j = 0; j < binToReduce.size(); j++) {
                    stepsY.set(j, -binToReduce.get(j));
                }
                for (int j = binToReduce.size(); j <= i; j++) {
                    stepsY.set(j, 0);
                }
            }

//            System.out.println(stepsX);
//            System.out.println(stepsY);

            nIter = Math.min(stepsX.size(), stepsY.size());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < nIter; i++) {
                if (Math.abs(stepsX.get(i)) == Math.abs(stepsY.get(i))) {
                    sb = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (stepsX.get(i) != 0) {
                    sb.append(stepsX.get(i) > 0 ? posDirX : negDirX);
                } else {
                    sb.append(stepsY.get(i) > 0 ? posDirY : negDirY);
                }
            }

            List<Integer> restOfSteps = stepsX.size() > stepsY.size() ? stepsX : stepsY;
            if (stepsX.size() != stepsY.size()) {
                for (int i = nIter; i < restOfSteps.size(); i++) {
                    if (restOfSteps == stepsX) {
                        sb.append(stepsX.get(i) > 0 ? posDirX : negDirX);
                    } else {
                        sb.append(stepsY.get(i) > 0 ? posDirY : negDirY);
                    }
                }
            }

            if (!checkNumber(stepsX, Math.abs(x)) || !checkNumber(stepsY, Math.abs(y))) {
                sb = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testNr + ": " + sb.toString());
        }
    }

    private static List<Integer> toBinary(int num) {
        List<Integer> lst = new ArrayList<>(32);
        while (num != 0) {
            lst.add(num % 2);
            num /= 2;
        }
        return lst;
    }

    private static char getOpposite(char dir) {
        if (dir == 'W') {
            return 'E';
        } else if (dir == 'E') {
            return 'W';
        } else if (dir == 'N') {
            return 'S';
        }
        return 'N';
    }

    private static boolean checkNumber(List<Integer> binRepr, int num) {
        int number = 0;
        for (int i = 0; i < binRepr.size(); i++) {
            number += binRepr.get(i) * Math.pow(2, i);
        }
        return number == num;
    }

}
