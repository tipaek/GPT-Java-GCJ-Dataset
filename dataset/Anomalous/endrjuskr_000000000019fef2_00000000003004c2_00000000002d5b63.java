import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int distanceA = scanner.nextInt();
        int distanceB = scanner.nextInt();
        int initialX = 1000000000;

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = initialX;
            int y = 0;

            while (true) {
                System.out.println(x + " " + y);
                String response = scanner.next();

                if (response.equals("MISS")) {
                    y++;
                } else if (response.equals("CENTER")) {
                    break;
                } else {
                    int offset = 1;

                    while (true) {
                        System.out.println((x - offset) + " " + y);
                        String leftResponse = scanner.next();
                        System.out.println((x + offset) + " " + y);
                        String rightResponse = scanner.next();

                        if (leftResponse.equals("MISS") && rightResponse.equals("MISS")) {
                            offset = 0;
                            break;
                        }
                        if (leftResponse.equals("HIT") && rightResponse.equals("HIT")) {
                            offset++;
                        } else if (leftResponse.equals("HIT")) {
                            offset = -offset;
                            break;
                        } else {
                            break;
                        }
                    }

                    if (offset == 0) {
                        y += distanceA;
                    } else if (offset < 0) {
                        y--;
                        x--;
                        while (true) {
                            System.out.println(x + " " + y);
                            response = scanner.next();
                            if (response.equals("MISS")) {
                                x++;
                            } else {
                                System.out.println((x - 1) + " " + y);
                                response = scanner.next();
                                if (response.equals("MISS")) {
                                    y += distanceA;
                                    break;
                                } else {
                                    y--;
                                    x--;
                                }
                            }
                        }
                    } else {
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
                                    y += distanceA;
                                    break;
                                } else {
                                    y--;
                                    x++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}