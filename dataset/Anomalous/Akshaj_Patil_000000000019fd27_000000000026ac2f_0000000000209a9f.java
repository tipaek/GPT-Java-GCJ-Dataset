import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = sc.nextInt();
        sc.nextLine();
        int caseNo = 1;
        
        while (testCases-- > 0) {
            String[] input = sc.nextLine().split("");
            int[] inputDigits = new int[input.length];
            int[] bracesCount = new int[input.length];
            StringBuilder ip = new StringBuilder();
            StringBuilder ans = new StringBuilder();
            
            for (int i = 0; i < input.length; i++) {
                inputDigits[i] = Integer.parseInt(input[i]);
                ip.append(input[i]);
                ans.append(input[i]);
            }
            
            Arrays.sort(input);
            
            for (String digit : input) {
                int index = ip.indexOf(digit);
                int left = index, right = index;
                
                while (left > 0 && inputDigits[left - 1] >= inputDigits[index]) left--;
                while (right < inputDigits.length - 1 && inputDigits[right + 1] >= inputDigits[index]) right++;
                
                ip.setCharAt(index, '.');
                
                StringBuilder subStr = new StringBuilder();
                for (int j = left; j <= right; j++) {
                    if (inputDigits[index] != 0 && bracesCount[index] < inputDigits[index]) {
                        subStr.append(inputDigits[j]);
                    }
                }
                
                if (inputDigits[index] != 0 && bracesCount[index] < inputDigits[index]) {
                    ans = new StringBuilder(ans.toString().replaceFirst(subStr.toString(), "(" + subStr + ")"));
                    
                    for (int j = left; j <= right; j++) {
                        bracesCount[j]++;
                    }
                    
                    if (bracesCount[index] < inputDigits[index]) {
                        String sstr = subStr.toString();
                        int remainingBraces = inputDigits[index] - bracesCount[index];
                        
                        for (int k = 0; k < remainingBraces; k++) {
                            sstr = "(" + sstr + ")";
                        }
                        
                        ans = new StringBuilder(ans.toString().replaceFirst(subStr.toString(), sstr));
                        Arrays.fill(bracesCount, left, right + 1, inputDigits[index]);
                    }
                }
                
                ans = new StringBuilder(ans.toString().replaceFirst(digit, "."));
            }
            
            StringBuilder finalAns = new StringBuilder();
            int temp = 0;
            
            for (int k = 0; k < ans.length(); k++) {
                if (ans.charAt(k) == '.') {
                    finalAns.append(inputDigits[temp++]);
                } else {
                    finalAns.append(ans.charAt(k));
                }
            }
            
            System.out.println("Case #" + caseNo + ": " + finalAns);
            caseNo++;
        }
    }
}