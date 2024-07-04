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
                String response = scanner.next();

                if (response.equals("MISS")) {
                    y++;
                } else if (response.equals("CENTER")) {
                    break;
                } else {
                    System.out.println((x - 1) + " " + y);
                    String left = scanner.next();
                    System.out.println((x + 1) + " " + y);
                    String right = scanner.next();

                    if (left.equals("MISS") && right.equals("MISS")) {
                        y -= A;
                    } else if (left.equals("MISS")) {
                        y--;
                        x++;
                        while (true) {
                            System.out.println(x + " " + y);
                            response = scanner.next();
                            if (response.equals("MISS")) {
                                x++;
                            } else {
                                System.out.println((x + 1) + " " + y);
                                response = scanner.next();
                                if (response.equals("MISS")) {
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
                            response = scanner.next();
                            if (response.equals("MISS")) {
                                x--;
                            } else {
                                System.out.println((x - 1) + " " + y);
                                response = scanner.next();
                                if (response.equals("MISS")) {
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