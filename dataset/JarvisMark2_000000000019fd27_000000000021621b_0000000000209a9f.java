import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    public static ArrayList<String> getDataFromStdIn() {
        ArrayList<String> input = new ArrayList<>();
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = 0;
        if (myReader.hasNextLine()) {
            T = Integer.valueOf(myReader.nextLine());
        }
        for (int i = 0; i < T; i++) {
            if (myReader.hasNextLine()) {
                input.add(myReader.nextLine().replace("\n", "").trim());
            }
        }
        return input;
    }

    public static String findParenString(String inputStr) {
        StringBuffer resBuffer = new StringBuffer();
        int openBracketCnt = 0, currNum = 0, end = 0;
        for (int j = 0; j < inputStr.length(); j++) {
            currNum = Character.getNumericValue(inputStr.charAt(j));
            if (openBracketCnt < currNum) {
                end = currNum - openBracketCnt;
                for (int k = 0; k < end; k++) {
                    openBracketCnt++;
                    resBuffer.append("(");
                }
            }
            else if (openBracketCnt > currNum) {
                end = openBracketCnt - currNum;
                for (int k = 0; k < end; k++) {
                    openBracketCnt--;
                    resBuffer.append(")");
                }
            }
            resBuffer.append(currNum);
        }
        for (int i = 0; i < openBracketCnt; i++) {
            resBuffer.append(")");
        }
        return resBuffer.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> input = getDataFromStdIn();
        for (int i = 0; i < input.size(); i++) {
            System.out.printf("Case #%d: %s\n", i+1, findParenString(input.get(i)));
        }
    }
}