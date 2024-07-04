
import java.util.*;

class Solution {

    private static boolean isAllZero(String s) {
        for(char c : s.toCharArray()) {
            if(c != '0') {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            String str = scanner.next();
            StringBuilder usingStr = new StringBuilder(str);

            List<Integer> outParens = new ArrayList<>();
            List<Integer> inParens = new ArrayList<>();

            for (int j = 0; j < usingStr.length(); j++) {
                outParens.add(j, 0);
                inParens.add(j, 0);
            }
            while (!isAllZero(usingStr.toString())) {
                
                if (!usingStr.toString().contains("0")) {
                    for (int j = 0; j < usingStr.length(); j++) {
                        usingStr.replace(j, j + 1, Integer.valueOf(usingStr.charAt(j) - '0' - 1).toString());
                    }
                    outParens.set(0, outParens.get(0) + 1);
                    inParens.set(usingStr.length() - 1, inParens.get(usingStr.length() - 1) + 1);
                } else {
                    int end, start;
                    end = start = 0;

                    while (true) {
                        if (end == usingStr.length()) {
                            if (start < usingStr.length()) {
                                if (usingStr.charAt(start) != '0') {
                                    outParens.set(start, outParens.get(start) + 1);
                                    inParens.set(end - 1, inParens.get(end - 1) + 1);
                                }
                            }
                            break;
                        }
                        if (usingStr.charAt(end) != '0') {
                            end++;
                        } else {
                            if (usingStr.charAt(start) == '0' && usingStr.charAt(end) == '0') {
                                start += 1;
                                end += 1;
                                continue;
                            }
                            if (usingStr.charAt(start) != '0') {
                                outParens.set(start, outParens.get(start) + 1);
                                inParens.set(end - 1, inParens.get(end - 1) + 1);
                            }
                            start = end;
                        }
                    }
                    for (int j = 0; j < usingStr.length(); j++) {
                        if (usingStr.charAt(j) != '0') {
                            usingStr.replace(j, j + 1, Integer.valueOf(usingStr.charAt(j) - '0' - 1).toString());
                        }
                    }
                }
            }

            System.out.print("Case #" + i + ":" + " ");

            for (int j = 0; j < str.length(); j++) {
                for (int v = 0; v < outParens.get(j); v++) {
                    System.out.print('(');
                }
                System.out.print(str.charAt(j));
                for (int v = 0; v < inParens.get(j); v++) {
                    System.out.print(')');
                }
            }
            System.out.println();
        }
    }
}