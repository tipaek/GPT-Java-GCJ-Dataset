import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {

    private static Scanner scanner;
    private static int count = 0;

    public static void main(String[] args) {

        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int times = scanner.nextInt();
        int bitNum = scanner.nextInt();

        for (int i = 0; i < times; i++) {

            // Determine fixed points
            List<DoublePoint> points = new ArrayList<>();
            DoublePoint same = null;
            DoublePoint dif = null;

            for (int a = 0; a < bitNum / 2; a++) {

                if (count > 0 && count % 10 == 0) {
                    if (dif == null || same == null) {
                        points.forEach(DoublePoint::not);
                    }
                    if (dif != null && same != null) {
                        int change = changeReaction(same, request(same.A), dif, request(dif.A));
                        switch (change) {
                            case 0:
                                break;
                            case 1:
                                points.forEach(DoublePoint::switched);
                                break;
                            case 2:
                                points.forEach(DoublePoint::not);
                                break;
                            case 3:
                                points.forEach(DoublePoint::switched);
                                points.forEach(DoublePoint::not);
                                break;
                        }
                    }
                }

                int alpha = request(a + 1);
                int beta = request(bitNum - a);

                DoublePoint current = new DoublePoint(a + 1, bitNum - a, alpha, beta);
                if (same == null && alpha == beta) {
                    same = current;
                    if (count > 10 && dif != null) {
                        dif.ValA = request(dif.A);
                        dif.ValB = request(dif.B);
                    }
                }
                else if (dif == null && alpha != beta) {
                    dif = current;
                    if (count > 10 && same != null) {
                        same.ValA = request(same.A);
                        same.ValB = same.ValA;
                    }
                }
                points.add(current);
            }

            String result = "";
            for (int j = points.size(); j > 0; j--) {
                DoublePoint current = points.get(j - 1);
                result = current.ValA + result + current.ValB;
            }
            System.out.println(result);
            String ok = scanner.nextLine();
            ok = scanner.nextLine();
            if (ok.equals("N"))
                break;
        }

    }

    private static int request(int pos)
    {
        System.out.println(pos);
        count ++;
        return scanner.nextInt();
    }

    private static class DoublePoint
    {
        int A;
        int B;
        int ValA;
        int ValB;

        DoublePoint(int a, int b, int valA, int valB)
        {
            A = a;
            B = b;
            ValA = valA;
            ValB = valB;
        }

        void not()
        {
            ValA = ValA == 0 ? 1 : 0;
            ValB = ValB == 0 ? 1 : 0;
        }

        void switched()
        {
            int temp = ValA;
            ValA = ValB;
            ValB = temp;
        }
    }

    private static int changeReaction(DoublePoint same, int currentSame, DoublePoint dif, int currentDifA)
    {
        if (same.ValA == currentSame)
        {
            if (dif.ValA == currentDifA)
                // nothing
                return 0;
            else
                // switched around
                return 1;
        }
        else {
            if (dif.ValA == currentDifA)
                // complement
                return 2;
            else
                // both
                return 3;
        }
    }

}