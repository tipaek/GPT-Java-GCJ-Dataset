import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            Solution solution = new Solution();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                solution.getAnswer(caseNum, a, b, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String OUTPUT_FORMAT = "%d %d";
    private static final int UNIT = 1000000000;

    public void getAnswer(int caseNum, int a, int b, Scanner scanner) {
        int x = -UNIT;
        int y = -UNIT;
        int step = a / 2;
        int count = 0;
        boolean hit = false;

        while (count < 300 && !hit) {
            x += step;
            if (x > UNIT) {
                x = -UNIT;
                y += step;
                continue;
            }
            if (y > UNIT) {
                return;
            }
            System.out.printf(OUTPUT_FORMAT, x, y);
            System.out.flush();
            String result = scanner.next();
            switch (result) {
                case "MISS":
                    break;
                case "HIT":
                    hit = true;
                    break;
                case "CENTER":
                    return;
                case "WRONG":
                    System.exit(-1);
            }
            ++count;
        }

        while (count < 300) {
            int maxX = x;
            int tr = a;

            while (count < 300 && tr > 0) {
                System.out.printf(OUTPUT_FORMAT, Math.min(maxX + tr, UNIT), y);
                System.out.flush();
                String result = scanner.next();
                switch (result) {
                    case "MISS":
                        tr /= 2;
                        break;
                    case "HIT":
                        maxX += tr;
                        break;
                    case "CENTER":
                        return;
                    case "WRONG":
                        System.exit(-1);
                }
                ++count;
            }

            int minX = x;
            tr = a;

            while (count < 300 && tr > 0) {
                System.out.printf(OUTPUT_FORMAT, Math.max(minX - tr, -UNIT), y);
                System.out.flush();
                String result = scanner.next();
                switch (result) {
                    case "MISS":
                        tr /= 2;
                        break;
                    case "HIT":
                        minX -= tr;
                        break;
                    case "CENTER":
                        return;
                    case "WRONG":
                        System.exit(-1);
                }
                ++count;
            }

            x = (minX + maxX) / 2;

            int maxY = y;
            tr = a;
            boolean contY = true;

            while (count < 300 && tr > 0 && contY) {
                int t = Math.min(UNIT, maxY + tr);
                System.out.printf(OUTPUT_FORMAT, x, t);
                System.out.flush();
                String result = scanner.next();
                switch (result) {
                    case "MISS":
                        tr /= 2;
                        break;
                    case "HIT":
                        if (t == UNIT) {
                            contY = false;
                        } else {
                            maxY += tr;
                        }
                        break;
                    case "CENTER":
                        return;
                    case "WRONG":
                        System.exit(-1);
                }
                ++count;
            }

            int minY = y;
            tr = a;
            contY = true;

            while (count < 300 && tr > 0 && contY) {
                int t = Math.max(minY - tr, -UNIT);
                System.out.printf(OUTPUT_FORMAT, x, t);
                System.out.flush();
                String result = scanner.next();
                switch (result) {
                    case "MISS":
                        tr /= 2;
                        break;
                    case "HIT":
                        if (t == -UNIT) {
                            contY = false;
                        } else {
                            minY -= tr;
                        }
                        break;
                    case "CENTER":
                        return;
                    case "WRONG":
                        System.exit(-1);
                }
                ++count;
            }

            y = (maxY + minY) / 2;

            System.out.printf(OUTPUT_FORMAT, x, y);
            System.out.flush();
            String result = scanner.next();
            if ("CENTER".equals(result)) {
                return;
            } else {
                System.exit(-1);
            }
            ++count;
        }
    }
}