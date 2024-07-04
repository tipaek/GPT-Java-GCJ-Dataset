import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(in.readLine());
        
        for (int _t = 0; _t < t; _t++) {
            int n = Integer.parseInt(in.readLine());
            String[] arr = new String[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = in.readLine();
            }
            
            String prefix = "";
            String suffix = "";
            boolean valid = true;
            
            for (String s : arr) {
                int index = s.indexOf('*');
                if (index != -1) {
                    String tempPrefix = s.substring(0, index);
                    String tempSuffix = s.substring(index + 1);
                    
                    if (prefix.isEmpty() || tempPrefix.length() > prefix.length()) {
                        prefix = tempPrefix;
                    }
                    
                    if (suffix.isEmpty() || tempSuffix.length() > suffix.length()) {
                        suffix = tempSuffix;
                    }
                }
            }

            for (String s : arr) {
                int index = s.indexOf('*');
                String a = s.substring(0, index);
                String b = s.substring(index + 1);
                
                if (!prefix.startsWith(a) || !suffix.endsWith(b)) {
                    valid = false;
                    break;
                }
            }

            System.out.print("Case #" + (_t + 1) + ": ");
            if (valid) {
                System.out.println(prefix + suffix);
            } else {
                System.out.println("*");
            }
        }
        
        in.close();
    }
}