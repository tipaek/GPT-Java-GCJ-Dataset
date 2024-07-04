import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int mid = 1000000000;
        for (int t = 1; t <= T; t++) {
            int x = mid;
            int y = 0;
            int topy = 0;
            while(true) {
                System.out.println(String.format("%d %d", x, y));
                String o = in.next();
                if(o.equals("MISS")) {
                    y++;
                }
                else if(o.equals("CENTER")) {
                    break;
                }
                else {
                    System.out.println(String.format("%d %d", x - 1, y));
                    String left = in.next();
                    System.out.println(String.format("%d %d", x + 1, y));
                    String right = in.next();

                    if(left.equals("MISS") && right.equals("MISS")) {
                        y += A;
                    }
                    else if(left.equals("MISS")) {
                        y--;
                        x++;
                        while (true) {
                            System.out.println(String.format("%d %d", x, y));
                            o = in.next();
                            if(o.equals("MISS")) {
                                x++;
                            } else {
                                System.out.println(String.format("%d %d", x + 1, y));
                                o = in.next();
                                if(o.equals("MISS")) {
                                    y += A;
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
                            System.out.println(String.format("%d %d", x, y));
                            o = in.next();
                            if(o.equals("MISS")) {
                                x--;
                            } else {
                                System.out.println(String.format("%d %d", x - 1, y));
                                o = in.next();
                                if(o.equals("MISS")) {
                                    y += A;
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