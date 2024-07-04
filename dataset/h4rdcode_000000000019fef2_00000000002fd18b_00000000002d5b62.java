import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long x = in.nextLong();
            long y = in.nextLong();

            String answer = "IMPOSSIBLE";

            if ((Math.abs(x) % 2) == (Math.abs(y) % 2)) {
                answer = "IMPOSSIBLE";
            } else {

                boolean signX = (x == Math.abs(x));
                boolean signY = (y == Math.abs(y));

                x = Math.abs(x);
                y = Math.abs(y);

                if (x % 2 == 0) {
                    if ((x & (y - 1)) == 0) {
                        answer = signY ? "S" : "N";
                        for (int j = 1; j < 32; j++) {
                            if (((1 << j) & x) == (1 << j)) {
                                if (signX) {
                                    answer += "E";
                                } else {
                                    answer += "W";
                                }
                            } else if (((1 << j) & (y - 1)) == (1 << j)) {
                                if (signY) {
                                    answer += "N";
                                } else {
                                    answer += "S";
                                }
                            }
                        }
                    } else if ((x & (y + 1)) == 0) {
                        answer = signY ? "N" : "S";
                        for (int j = 1; j < 32; j++) {
                            if (((1 << j) & x) == (1 << j)) {
                                if (signX) {
                                    answer += "E";
                                } else {
                                    answer += "W";
                                }
                            }  else if (((1 << j) & (y + 1)) == (1 << j)) {
                                if (signY) {
                                    answer += "N";
                                } else {
                                    answer += "S";
                                }
                            }
                        }
                    }
                } else {
                    if ((y & (x - 1)) == 0) {
                        answer = signX ? "W" : "E";
                        for (int j = 1; j < 32; j++) {
                            if (((1 << j) & y) == (1 << j)) {
                                if (signY) {
                                    answer += "N";
                                } else {
                                    answer += "S";
                                }
                            } else if (((1 << j) & (x - 1)) == (1 << j)) {
                                if (signY) {
                                    answer += "E";
                                } else {
                                    answer += "W";
                                }
                            }
                        }
                    } else if ((y & (x + 1)) == 0) {
                        answer = signX ? "E" : "W";
                        for (int j = 1; j < 32; j++) {
                            if (((1 << j) & y) == (1 << j)) {
                                if (signX) {
                                    answer += "N";
                                } else {
                                    answer += "S";
                                }
                            }  else if (((1 << j) & (x + 1)) == (1 << j)) {
                                if (signY) {
                                    answer += "E";
                                } else {
                                    answer += "W";
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(String.format("Case #%d: %s", i + 1, answer));
        }
    }
}
