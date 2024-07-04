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
                for (int i = 0; i < strings.length; i++) {
                    strings[i] = scanner.next();
                    String t = strings[i].replaceAll("\\*", "");
                    if (result.isEmpty())
                        result = t;
                    else if (t.length() > result.length()) {
                        if (!t.contains(result)) {
                            result = "*";
                            break;
                        }
                        result = t;
                    } else {
                        if (!result.contains(t)) {
                            result = "*";
                            break;
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