import java.util.Scanner;

public class Solution {
    //    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int T = input.nextInt();
//        for(int cs=1; cs<=T; cs++) {
//            int n = input.nextInt();
//            int[][] times = new int[n][2];
//            for(int i=0; i<n; i++) {
//                for(int j=0; j<2; j++) {
//                    times[i][j] = input.nextInt();
//                }
//            }
//
//            StringBuilder newS = new StringBuilder();
//            boolean isC = true;
//            int prevEnd = 0;
//            for (int i = 0; i < n; i++) {
//                int start = times[i][0];
//                int end = times[i][1];
//                if (start < prevEnd) {
//                    isC = !isC;
//                    if(i > 1) {
//                        int lastlastEnd = times[i - 2][1];
//                        if(start < lastlastEnd && (newS.charAt(i-2) == 'C') == isC) {
//                            newS = new StringBuilder("IMPOSSIBLE");
//                            break;
//                        }
//                    }
//                }
//
//                if (isC) {
//                    newS.append("C");
//                } else {
//                    newS.append("J");
//                }
//
//                prevEnd = end;
//            }
//            System.out.println("Case #" + cs + ": " + newS);
//        }
//    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int n = input.nextInt();
            int[][] times = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    times[i][j] = input.nextInt();
                }
            }

            StringBuilder newS = new StringBuilder();
            boolean isC = true;
            boolean isImpossible = false;
            int prevEnd = 0;
            for (int i = 0; i < n; i++) {
                int start = times[i][0];
                int end = times[i][1];
                if (start < prevEnd) {
                    isC = !isC;
                    int numberOverlapped = 0;
                    for(int j=i-1; j>=0; j--) {
                        if(overlaps(start,end,times[j][0],times[j][1])) {
                            numberOverlapped++;
                        }
                        if(numberOverlapped > 1) {
                            newS = new StringBuilder("IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if(isImpossible) {
                    break;
                }

                if (isC) {
                    newS.append("C");
                } else {
                    newS.append("J");
                }

                prevEnd = end;
            }
            System.out.println("Case #" + cs + ": " + newS);
        }
    }

    public static boolean overlaps(int start1, int end1, int start2, int end2) {
        return start1 < end2 && end1 > start2;
    }
}