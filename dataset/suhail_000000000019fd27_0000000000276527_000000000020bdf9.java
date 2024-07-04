import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for(int j=0; j<n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                map.put(start,end);
            }
            int cTime = 0;
            int jTime = 0;
            char[] output = new char[n];
            int sessionValue = 0;
            boolean caseImposible = false;
            for(Map.Entry<Integer, Integer> session : map.entrySet()) {
                if(session.getKey() > cTime) {
                    output[sessionValue] = 'C';
                    cTime = session.getValue();
                } else if(session.getValue() > jTime) {
                    output[sessionValue] = 'J';
                    jTime = session.getValue();
                } else {
                    caseImposible = true;
                   
                    break;
                }
            }
            if(caseImposible) {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            } else {
                System.out.println("Case #"+i+": "+new String(output));
            }
            
        }
    }
}