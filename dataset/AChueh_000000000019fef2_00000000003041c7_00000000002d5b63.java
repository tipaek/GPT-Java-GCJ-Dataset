import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        int A = in.nextInt();
        int B = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            boolean result = processInput(in, A, B);
            if(!result) {
//                System.err.println("FAIL");
                System.exit(0);
//            } else {
//                System.err.println("SUCCESS");
            }
        }
    }

    static boolean processInput(Scanner input, int MIN_R, int MAX_R) {
        int[] answer = new int[2];
        int L = Integer.MIN_VALUE;
        int T = Integer.MIN_VALUE;
        int R = Integer.MIN_VALUE;
        int B = Integer.MIN_VALUE;
        // [MISS, HIT]
        int[] possibleL = {-1000000000, +1000000000};
        int[] possibleT = {+1000000000, -1000000000};
        int[] possibleR = {+1000000000, -1000000000};
        int[] possibleB = {-1000000000, +1000000000};
        for(int i = 0; i < 299; ++i) {
            if(L == Integer.MIN_VALUE) {
                String result = guess(input, (possibleL[0]+possibleL[1])/2, 0);
                if(result.equals("MISS")) {
                    possibleL[0] = (possibleL[0]+possibleL[1])/2;
                } else if(result.equals("HIT")) {
                    possibleL[1] = (possibleL[0]+possibleL[1])/2;
                } else {
//                    System.err.println("RETURN"+42);
                    return result.equals("CENTER");
                }
                if(possibleL[1] - possibleL[0] == 1) {
                    if(possibleL[0] == -1000000000) {
                        ++i;
                        L = guess(input, possibleL[0], 0).equals("HIT")?possibleL[0]:possibleL[1];
                    } else {
                        L = possibleL[1];
                    }
//                    possibleR[0] = L + MAX_R + 1;
                    possibleR[1] = L;
                }
            } else if(R == Integer.MIN_VALUE) {
                String result = guess(input, (possibleR[0]+possibleR[1])/2, 0);
                if(result.equals("MISS")) {
                    possibleR[0] = (possibleR[0]+possibleR[1])/2;
                } else if(result.equals("HIT")) {
                    possibleR[1] = (possibleR[0]+possibleR[1])/2;
                } else {
//                    System.err.println("RETURN"+62);
                    return result.equals("CENTER");
                }
                if(possibleR[1] - possibleR[0] == -1) {
                    if(possibleR[0] == 1000000000) {
                        ++i;
                        R = guess(input, possibleR[0], 0).equals("HIT")?possibleR[0]:possibleR[1];
                    } else {
                        R = possibleR[1];
                    }
                    answer[0] = (L + R)/2;
                }
            } else if(T == Integer.MIN_VALUE) {
                String result = guess(input, answer[0], (possibleT[0]+possibleT[1])/2);
                if(result.equals("MISS")) {
                    possibleT[0] = (possibleT[0]+possibleT[1])/2;
                } else if(result.equals("HIT")) {
                    possibleT[1] = (possibleT[0]+possibleT[1])/2;
                } else {
//                    System.err.println("RETURN"+81);
                    return result.equals("CENTER");
                }
                if(possibleT[1] - possibleT[0] == -1) {
                    if(possibleT[0] == 1000000000) {
                        ++i;
                        T = guess(input, answer[0], possibleT[0]).equals("HIT")?possibleT[0]:possibleT[1];
                    } else {
                        T = possibleT[1];
                    }
//                    possibleB[0] = T - MAX_R - 1;
                    possibleB[1] = T;
                }
            } else if(B == Integer.MIN_VALUE) {
                String result = guess(input, answer[0], (possibleB[0]+possibleB[1])/2);
                if(result.equals("MISS")) {
                    possibleB[0] = (possibleB[0]+possibleB[1])/2;
                } else if(result.equals("HIT")) {
                    possibleB[1] = (possibleB[0]+possibleB[1])/2;
                } else {
//                    System.err.println("RETURN"+101);
                    return result.equals("CENTER");
                }
                if(possibleB[1] - possibleB[0] == 1) {
                    if(possibleB[0] == -1000000000) {
                        ++i;
                        B = guess(input, answer[0], possibleB[0]).equals("HIT")?possibleB[0]:possibleB[1];
                    } else {
                        B = possibleB[1];
                    }
                    answer[1] = (T + B)/2;
                }
            } else {
                answer[0] = (L + R)/2;
                answer[1] = (T + B)/2;
                break;
            }
        }
//        System.err.println("ANSWER: "+ L +" " + R +" " + T + " " + B);
//        System.err.println("ANSWER: "+ answer[0]+" "+answer[1]);
        return guess(input, answer[0], answer[1]).equals("CENTER");
    }

    static String guess(Scanner input, int x, int y) {
        System.out.println(x+" "+y);
        System.out.flush();
        String next = input.next();
        return next;
    }
}