import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int[] N = new int[30];
    private static int[] C = new int[30];
    private static HashMap<Integer, Integer> C_MAP = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        //in = new Scanner(Expogo.class.getResourceAsStream("file.in"));

        for (int i = 1; i < 30; i++) {
            N[i] = (int) Math.pow(2, i - 1);
            C[i] = C[i - 1] + N[i];
            C_MAP.put(C[i], i);
        }
//
//        System.out.println(Arrays.toString(N));
//        System.out.println(Arrays.toString(C));
//        System.out.println(C_MAP.toString());

        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            if (in.hasNext()) {
                in.nextLine();
            }

            if ((Math.abs(X) % 2 == 0 && Math.abs(Y) % 2 == 0) || (Math.abs(X) % 2 == 1 && Math.abs(Y) % 2 == 1)) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else if (X == 0) {
                if (C_MAP.containsKey(Math.abs(Y))) {
                    if (Y < 0) {
                        System.out.println("Case #" + t + ": " + loop("S", C_MAP.get(Math.abs(Y))));
                    } else {
                        System.out.println("Case #" + t + ": " + loop("N", C_MAP.get(Math.abs(Y))));
                    }
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            } else if (Y == 0) {
                if (C_MAP.containsKey(Math.abs(X))) {
                    if (X < 0) {
                        System.out.println("Case #" + t + ": " + loop("W", C_MAP.get(Math.abs(X))));
                    } else {
                        System.out.println("Case #" + t + ": " + loop("E", C_MAP.get(Math.abs(X))));
                    }
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            } else {
                int even = Math.abs(X % 2 == 0 ? X : Y);
                int numJustToEven = -1;
                int used[] = new int[30];
                int posOfJustToEven = -1;
                for (int i = 1; i < 30; i++) {
                    if (N[i] == even) {
                        numJustToEven = N[i];
                        used[i] = 2;
                        posOfJustToEven = i;
                        break;
                    } else if (N[i] > even) {
                        numJustToEven = N[i - 1];
                        used[i - 1] = 2;
                        posOfJustToEven = i - 1;
                        break;
                    }
                }
                int total = numJustToEven;
                for (int i = posOfJustToEven - 1; i > 1; i++) {
                    if (total + N[i] <= even) {
                        total += N[i];
                        used[i] = 2;
                    }
                    if (total == even) {
                        break;
                    }
                }
                int odd = Math.abs(X % 2 == 0 ? Y : X);
                int oddTotal = -1;
                used[1] = 1;
                for (int i = 2; i < 30; i++) {
                    if (used[i] == 0) {
                        oddTotal += N[i];
                        used[i] = 1;
                        if (oddTotal >= odd) {
                            break;
                        }
                    }
                }
                if (oddTotal == odd) {
                    String result;
                    if (X % 2 == 1) {
                        result = X > 0 ? "W" : "E";
                    } else {
                        result = Y > 0 ? "S" : "N";
                    }
                    for (int i = 2; i < 30; i++) {
                        if (used[i] == 0) {
                            break;
                        } else if (used[i] == 1) {
                            if (X % 2 == 1) {
                                result += X > 0 ? "E" : "W";
                            } else {
                                result += Y > 0 ? "N" : "S";
                            }
                        } else {
                            if (X % 2 == 0) {
                                result += X > 0 ? "E" : "W";
                            } else {
                                result += Y > 0 ? "N" : "S";
                            }
                        }
                    }
                    System.out.println("Case #" + t + ": " + result);
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }

            }
        }
    }

    private static String loop(String s, int count) {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sB.append(s);
        }
        return sB.toString();
    }

}
