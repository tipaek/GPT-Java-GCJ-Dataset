import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t = 0; t < T; t ++) {
            int N = in.nextInt();
            in.nextLine();
            String resStart = "";
            String resEnd = "";

            boolean notVald = false;
            for (int i = 0; i < N; i++) {
                String mask = in.nextLine().trim();
//                System.out.println(mask);
//                int astPos = mask.index('*');

                int astPos = -1;
                for (int j = 0; j < mask.length(); j++) {
                    if (mask.charAt(j) == '*') {
                        astPos = j;
                        break;
                    }
                }

                if (astPos != mask.length() - 1) {
                    if (resEnd.length() > mask.length() - astPos - 1) {
                        if(!resEnd.endsWith(mask.substring(1))) {
                            notVald = true;
                            break;
                        }
                    } else {
                        if (!mask.endsWith(resEnd)) {
                            notVald = true;
                            break;
                        }

                        resEnd = mask.substring(astPos + 1);
                    }
                }

                if (astPos != 0) {
                    if (resStart.length() > astPos) {
                        if(!resStart.startsWith(mask.substring(0, astPos))) {
                            notVald = true;
                            break;
                        }
                    } else {
                        if (!mask.startsWith(resStart)) {
                            notVald = true;
                            break;
                        }

                        resStart = mask.substring(0, astPos);
                    }
                }

            }
            if (notVald) {
                System.out.println("*");
            } else {
                System.out.println(resStart + resEnd);
            }
        }
    }
}