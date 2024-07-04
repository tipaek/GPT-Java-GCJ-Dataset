
//python interactive_runner.py python testing_tool.py 0 -- java com.crazystudio.code.jam2020.round1b.blind.Solution
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, a, b, scanner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static String output = "%d %d";
    public static int unit = 1000000000;
    public void getAnswer(int caseNum, int a, int b, Scanner scanner) {
        int x = -unit;
        int y = -unit;
        int count = 0;
        boolean hit = false;
        int step = a / 2;
        while (count < 300 && !hit) {
            x += step;
            if (x > unit) {
                x = -unit;
                y += step;
                continue;
            }
            if (y > unit) {
                return;
            }
            System.out.println(String.format(output, x, y));
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
            System.err.println(count);
            System.err.flush();

            int maxX = x;
            int tr = a;
            while (count < 300 && tr > 0) {
                System.out.println(String.format(output,Math.min(maxX + tr, unit), y));
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
            System.err.println(count);
            System.err.flush();

            int minX = x;
            tr = a;
            while (count < 300 && tr > 0) {
                System.out.println(String.format(output,Math.max(minX - tr, -unit), y));
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
            System.err.println(count);
            System.err.flush();
            x = (minX + maxX ) / 2;

            int maxY = y;
            tr = a;
            boolean conty = true;
            while (count < 300 && tr > 0  && conty) {
                int t =  Math.min(unit, maxY + tr);
                System.out.println(String.format(output,x, Math.min(unit, maxY + tr)));
                System.out.flush();
                String result = scanner.next();
                switch (result) {
                    case "MISS":
                        tr /= 2;
                        break;
                    case "HIT":
                        if (t == unit) {
                            conty = false;
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
            System.err.println(count);
            System.err.flush();

            int minY = y;
            tr = a;
            conty = true;
            while (count < 300 && tr > 0 && conty) {
                int t = Math.max(minY - tr, -unit);
                System.out.println(String.format(output,x, t));
                System.out.flush();
                String result = scanner.next();
                switch (result) {
                    case "MISS":
                        tr /= 2;
                        break;
                    case "HIT":
                        if (t == -unit) {
                            conty = false;
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
            System.err.println(count);
            System.err.flush();

            y = (maxY + minY)/2;
            System.err.println(String.format(output, x, y));
            System.err.flush();
            System.out.println(String.format(output, x, y));
            System.out.flush();
            String result = scanner.next();
            switch (result) {
                case "CENTER":
                    return;
                default:
                    System.exit(-1);
            }
            ++count;
        }




    }
}