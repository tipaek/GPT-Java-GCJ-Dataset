import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tsize = scanner.nextInt();
        
        for (int t = 0; t < tsize; t++) {
            String line = scanner.next();
            String result = "";
            if (line.length() > 1) {
                for (int k = 0; k < line.charAt(0) - '0'; k++) {
                    result += "(";
                }
                result += line.charAt(0);
                int prev = 0;
                int n = 0;
                for (int k = 1; k < line.length(); k++) {
                    n = line.charAt(k) - '0';
                    prev = line.charAt(k-1) - '0';
                    if (n == 0) {
                        for (int i = 0; i < prev; i++) {
                            result += ")";
                        }
                        result += n;
                    } else {
                        if (n < prev) {
                            for (int i = 0; i < n; i++) {
                                result += "(";
                            }
                            result += n;
                        } else if (n > prev) {
                            for (int i = 0; i < n; i++) {
                                result += "(";
                            }
                            result += n;
                            for (int i = 0; i < n; i++) {
                                result += ")";
                            }
                        } else {
                            result += n;
                        }
                    }
                }
            } else {
                int lastIndex = line.length() - 1;
                int b = line.charAt(lastIndex) - '0';
                for (int i = 0; i < b; i++) {
                    result += "(";
                }
                result += line.charAt(lastIndex);
                for (int i = 0; i < b; i++) {
                    result += ")";
                }
            }
            
            System.out.println("Case #"+(t+1)+": "+result);
        }
        
    }
}