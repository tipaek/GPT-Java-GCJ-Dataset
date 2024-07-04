import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String S = br.readLine();
            StringBuilder S1 = new StringBuilder();
            int n = S.length();

            if (n > 1) {
                int firstDigit = Character.getNumericValue(S.charAt(0));
                S1.append("(".repeat(firstDigit));

                if (firstDigit != 0 && S.charAt(0) != S.charAt(1)) {
                    S1.append(S.charAt(0));
                }

                for (int i = 0; i < n; i++) {
                    if (i > 0) {
                        int currentDigit = Character.getNumericValue(S.charAt(i));
                        int previousDigit = Character.getNumericValue(S.charAt(i - 1));

                        if (S.charAt(i) == '0' && previousDigit != '0' && i == 1) {
                            S1.append(")".repeat(previousDigit));
                        }

                        if (currentDigit != 0 && previousDigit != 0) {
                            if (currentDigit == previousDigit) {
                                S1.append(currentDigit);
                            } else if (currentDigit > previousDigit) {
                                S1.append("(".repeat(currentDigit - previousDigit)).append(currentDigit);
                            } else {
                                S1.append(")".repeat(previousDigit - currentDigit));
                                if (i == 1) {
                                    S1.append(S.charAt(1));
                                }
                            }
                        }

                        if (S.charAt(i) == '0') {
                            S1.append("0");
                        }

                        if (i > 0 && currentDigit != 0 && previousDigit == '0') {
                            S1.append("(".repeat(currentDigit)).append(S.charAt(i));
                        }

                        if (i < n - 1 && currentDigit != 0 && S.charAt(i + 1) == '0') {
                            if (i > 0 && previousDigit != '0') {
                                S1.append(S.charAt(i));
                            }
                            S1.append(")".repeat(currentDigit));
                        }
                    }
                }

                S1.append(")".repeat(Character.getNumericValue(S.charAt(n - 1))));
            }

            if (n == 1) {
                int singleDigit = Integer.parseInt(S);
                S1.append("(".repeat(singleDigit)).append(S).append(")".repeat(singleDigit));
            }

            int zeroCount = (int) S.chars().filter(ch -> ch == '0').count();
            if (zeroCount != n) {
                System.out.println("Case #" + t + ": " + S1);
            } else {
                System.out.println("Case #" + t + ": " + S);
            }
        }
    }
}