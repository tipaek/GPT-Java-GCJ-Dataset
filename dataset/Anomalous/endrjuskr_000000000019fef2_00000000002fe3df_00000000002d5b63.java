import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int mid = 1000000000;

        for (int t = 1; t <= testCases; t++) {
            int x = mid;
            int y = 0;

            while (true) {
                System.out.println(x + " " + y);
                String result = scanner.next();

                if (result.equals("MISS")) {
                    y++;
                } else if (result.equals("CENTER")) {
                    break;
                } else {
                    System.out.println((x - 1) + " " + y);
                    String leftResult = scanner.next();
                    System.out.println((x + 1) + " " + y);
                    String rightResult = scanner.next();

                    if (leftResult.equals("MISS") && rightResult.equals("MISS")) {
                        y -= A;
                    } else if (leftResult.equals("MISS")) {
                        y--;
                        x++;
                        while (true) {
                            System.out.println(x + " " + y);
                            result = scanner.next();
                            if (result.equals("MISS")) {
                                x++;
                            } else {
                                System.out.println((x + 1) + " " + y);
                                result = scanner.next();
                                if (result.equals("MISS")) {
                                    y -= A;
                                    break;
                                } else {
                                    y--;
                                    x++;
                                }
                            }
                        }
                    } else {
                        y--;
                        x--;
                        while (true) {
                            System.out.println(x + " " + y);
                            result = scanner.next();
                            if (result.equals("MISS")) {
                                x--;
                            } else {
                                System.out.println((x - 1) + " " + y);
                                result = scanner.next();
                                if (result.equals("MISS")) {
                                    y -= A;
                                    break;
                                } else {
                                    y--;
                                    x--;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}