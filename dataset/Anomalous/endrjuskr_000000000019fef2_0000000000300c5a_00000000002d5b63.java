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

        for (int t = 0; t < testCases; t++) {
            int x = 0;
            int y = mid;

            while (true) {
                System.out.printf("%d %d\n", x, y);
                String response = scanner.next();

                if (response.equals("MISS")) {
                    y--;
                } else if (response.equals("CENTER")) {
                    break;
                } else {
                    int offset = 1;

                    while (true) {
                        System.out.printf("%d %d\n", x - offset, y);
                        String leftResponse = scanner.next();
                        System.out.printf("%d %d\n", x + offset, y);
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
                        y -= A;
                    } else if (offset < 0) {
                        y++;
                        x--;
                        while (true) {
                            System.out.printf("%d %d\n", x, y);
                            response = scanner.next();

                            if (response.equals("MISS")) {
                                x++;
                            } else {
                                System.out.printf("%d %d\n", x - 1, y);
                                response = scanner.next();

                                if (response.equals("MISS")) {
                                    y -= A;
                                    break;
                                } else {
                                    y++;
                                    x--;
                                }
                            }
                        }
                    } else {
                        y++;
                        x++;
                        while (true) {
                            System.out.printf("%d %d\n", x, y);
                            response = scanner.next();

                            if (response.equals("MISS")) {
                                x++;
                            } else {
                                System.out.printf("%d %d\n", x + 1, y);
                                response = scanner.next();

                                if (response.equals("MISS")) {
                                    y -= A;
                                    break;
                                } else {
                                    y++;
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