import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static StringBuilder solve(String numString) {
        StringBuilder ansString = new StringBuilder();
        int prevNo, nextNo, currentNo;

        if (numString.length() > 1) {
            for (int i = 0; i < numString.length(); i++) {
                currentNo = Character.getNumericValue(numString.charAt(i));
                if (i == 0) {
                    nextNo = Character.getNumericValue(numString.charAt(i + 1));
                    ansString.append(addOpen(currentNo));
                    ansString.append(currentNo);
                } else if (i == numString.length() - 1) {
                    prevNo = Character.getNumericValue(numString.charAt(i - 1));
                    if (currentNo - prevNo < 0) {
                        ansString.append(addClose(prevNo - currentNo));
                    } else if (currentNo - prevNo > 0) {
                        ansString.append(addOpen(currentNo - prevNo));
                    }
                    ansString.append(currentNo);
                    ansString.append(addClose(currentNo));
                } else {
                    prevNo = Character.getNumericValue(numString.charAt(i - 1));
                    if (currentNo - prevNo < 0) {
                        ansString.append(addClose(prevNo - currentNo));
                    } else if (currentNo - prevNo > 0) {
                        ansString.append(addOpen(currentNo - prevNo));
                    }
                    ansString.append(currentNo);
                }
            }
        } else if (numString.length() == 1) {
            currentNo = Character.getNumericValue(numString.charAt(0));
            ansString.append(addOpen(currentNo));
            ansString.append(currentNo);
            ansString.append(addClose(currentNo));
        }
        return ansString;
    }

    public static StringBuilder addOpen(int num) {
        StringBuilder paraOpen = new StringBuilder();
        for (int i = 0; i < num; i++) {
            paraOpen.append("(");
        }
        return paraOpen;
    }

    public static StringBuilder addClose(int num) {
        StringBuilder paraClose = new StringBuilder();
        for (int i = 0; i < num; i++) {
            paraClose.append(")");
        }
        return paraClose;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNo = stdin.nextInt();
        stdin.nextLine();
        
        for (int k = 1; k <= caseNo; k++) {
            String numString = stdin.nextLine();
            System.out.println("Case #" + k + ": " + solve(numString));
        }
    }
}