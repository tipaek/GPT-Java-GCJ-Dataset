import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int n = scanner.nextInt();
                String[] strings = new String[n];
                String result = "";
                outer:
                for (int i = 0; i < strings.length; i++) {
                    strings[i] = scanner.next();
                    String t = strings[i].replaceAll("\\*", "");
                    if (result.isEmpty())
                        result = t;
                    else if (t.length() > result.length()) {
                        if (!t.contains(result)) {
                            for (int j = 0; j < result.length(); j++) {
                                if (t.contains(result.charAt(j) + "")) {
                                    result = "*";
                                    break outer;
                                }
                            }
                            result += t;
                        } else
                            result = t;
                    } else {
                        if (!result.contains(t)) {
                            for (int j = 0; j < t.length(); j++) {
                                if (result.contains(t.charAt(j) + "")) {
                                    result = "*";
                                    break outer;
                                }
                            }
                            result += t;
                        }
                    }
                }
                
                System.out.println("Case #" + (idx+1) + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}