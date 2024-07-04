/*
	ID: audreylee16
	LANG: JAVA
	TASK: default
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String result = "";
            String[] inputKeys = scanner.nextLine().split("");
            
            for (int index = 0; index < inputKeys.length; index++) {
                int key = Integer.parseInt(inputKeys[index]);
                
                if (key == 0) {
                    result += "0";
                } else {
                    String append = String.valueOf(key);
                    String tempResult = result;

                    for (int count = 0; count < key; count++) {
                        if (tempResult.length() > (count + 1) && tempResult.endsWith(")")) {
                            tempResult = tempResult.substring(0, tempResult.length() - 1);
                            append += ")";
                        } else {
                            append = "(" + append + ")";
                        }
                    }
                    result = tempResult + append;
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}