

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int cases = in.nextInt();
            for (int t = 1; t <= cases; t++) {
                String str = in.next();
                StringBuilder sb = new StringBuilder();
                String[] strArray = str.split("");
                for (int i = 0; i < strArray.length; i++) {
                    int num = Integer.parseInt(strArray[i]);
                    if (i == 0) {
                        if (num == 0) {
                            sb.append(num);
                        }
                        if (num > 0) {
                            for (int j = 0; j < num; j++) {
                                sb.append("(");
                            }
                            sb.append(num);
                        }
                    } else {
                        int prevNum = Integer.parseInt(strArray[i - 1]);
                        int diff = num - prevNum;
                        if (diff == 0) {
                            sb.append(num);
                        } else if (diff > 0) {
                            for (int j = 0; j < diff; j++) {
                                sb.append("(");
                            }
                            sb.append(num);
                        } else if (diff < 0) {
                            diff = Math.abs(diff);
                            for (int j = 0; j < diff; j++) {
                                sb.append(")");
                            }
                            sb.append(num);
                        }
                    }
                    if (i == strArray.length - 1) {
                        for (int j = 0; j < num; j++) {
                            sb.append(")");
                        }
                    }
                }

                System.out.println("Case #" + t + ": " + sb.toString());
            }
        } finally {
            in.close();
        }
    }

}
