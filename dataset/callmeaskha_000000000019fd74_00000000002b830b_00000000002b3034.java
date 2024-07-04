import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int wordsNum = Integer.parseInt(br.readLine());
            String firstMax = "";
            String secondMax = "";
            boolean isPossible = true;

            for (int word = 0; word < wordsNum; word++) {
                String s = br.readLine();
                int asterisk = s.indexOf("*");
                String first = s.substring(0, asterisk);
                String second = s.substring(asterisk + 1);

                if (first.length() > firstMax.length()) {
                    if (!first.contains(firstMax)) {
                        isPossible = false;
                    }
                    firstMax = first;
                } else {
                    if (!firstMax.contains(first)) {
                        isPossible = false;
                    }
                }

                if (second.length() > secondMax.length()) {
                    if (!second.contains(secondMax)) {
                        isPossible = false;
                    }
                    secondMax = second;
                } else {
                    if (!secondMax.contains(second)) {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                System.out.println(firstMax + secondMax);
            } else {
                System.out.println("*");
            }

        }
    }
}