import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for (int counter = 1; counter <= T; counter++) {
            String S = br.readLine().trim();
            HashMap<Integer, Integer> posO = new HashMap<>();
            HashMap<Integer, Integer> posC = new HashMap<>();
            char[] SS = S.toCharArray();
            int nums = SS.length, min = 58;
            int index = 0, sI = 0;
            
            while (nums != 0) {
                nums = 0;
                index = 0;
                sI = 0;
                while (index < SS.length) {
                    if (SS[index] == '0' && sI != index) {
                        posO.put(sI, posO.getOrDefault(sI, 0) + (min - '0'));
                        posC.put(index, posC.getOrDefault(index, 0) + (min - '0'));
                        update(sI, index, SS, min);
                        min = 60;
                        sI = index + 1;
                    } else if (SS[index] != '0') {
                        min = Math.min(min, SS[index]);
                        nums++;
                    } else {
                        sI = index + 1;
                    }
                    index++;
                }
                
                if (min != 60) {
                    posO.put(sI, posO.getOrDefault(sI, 0) + (min - '0'));
                    posC.put(index, posC.getOrDefault(index, 0) + (min - '0'));
                    update(sI, index, SS, min);
                    min = 60;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                if (posC.containsKey(i)) {
                    appendChars(sb, ')', posC.get(i));
                }
                if (posO.containsKey(i)) {
                    appendChars(sb, '(', posO.get(i));
                }
                sb.append(S.charAt(i));
            }
            
            if (posC.containsKey(S.length())) {
                appendChars(sb, ')', posC.get(S.length()));
            }
            
            bw.write("Case #" + counter + ": " + sb.toString() + "\n");
            bw.flush();
        }
        
        bw.close();
        br.close();
    }
    
    private static void update(int i, int j, char[] SS, int min) {
        for (int k = i; k < j; k++) {
            SS[k] -= (min - '0');
        }
    }
    
    private static void appendChars(StringBuilder sb, char ch, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
    }
}