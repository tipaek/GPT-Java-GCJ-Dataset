import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            String[] input = sc.nextLine().split("");
            int[] inputNumbers = new int[input.length];
            int[] countBraces = new int[input.length];
            StringBuilder ip = new StringBuilder();
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < input.length; i++) {
                inputNumbers[i] = Integer.parseInt(input[i]);
                ip.append(input[i]);
                ans.append(input[i]);
            }

            Arrays.sort(input);

            for (String s : input) {
                int index = ip.indexOf(s);
                int left = index, right = index;

                for (int j = index; j >= 0; j--) {
                    if (inputNumbers[j] < inputNumbers[index]) break;
                    left = j;
                }

                for (int j = index; j < input.length; j++) {
                    if (inputNumbers[j] < inputNumbers[index]) break;
                    right = j;
                }

                ip.setCharAt(index, '.');

                StringBuilder subStr = new StringBuilder();
                for (int j = left; j <= right; j++) {
                    if (inputNumbers[index] != 0) countBraces[j]++;
                    subStr.append(inputNumbers[j]);
                }

                if (inputNumbers[index] != 0) {
                    String subStrStr = subStr.toString();
                    ans = new StringBuilder(ans.toString().replaceFirst(subStrStr, "(" + subStrStr + ")"));

                    if (countBraces[index] < inputNumbers[index]) {
                        String sstr = subStrStr;
                        int ct = inputNumbers[index] - countBraces[index];
                        for (int k = 0; k < ct; k++) {
                            sstr = "(" + sstr + ")";
                        }
                        ans = new StringBuilder(ans.toString().replaceFirst(subStrStr, sstr));
                        for (int k = left; k <= right; k++) {
                            countBraces[k] = inputNumbers[index];
                        }
                    }
                }
                ans = new StringBuilder(ans.toString().replaceFirst(s, "."));
            }

            int temp = 0;
            StringBuilder finalAns = new StringBuilder();
            for (int k = 0; k < ans.length(); k++) {
                if (ans.charAt(k) == '.') {
                    finalAns.append(inputNumbers[temp]);
                    temp++;
                } else {
                    finalAns.append(ans.charAt(k));
                }
            }

            System.out.println("#" + caseNo + " " + finalAns);
        }
    }
}