import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;
        
        while (caseNumber <= T) {
            String S = br.readLine().trim();
            Map<Integer, Integer> openPositions = new HashMap<>();
            Map<Integer, Integer> closePositions = new HashMap<>();
            char[] characters = S.toCharArray();
            int length = characters.length;
            int minChar = 60;
            int index = 0, startIndex = 0;
            
            while (length != 0) {
                length = 0;
                index = 0;
                startIndex = 0;
                while (index < characters.length) {
                    if (characters[index] == '0' && startIndex != index) {
                        openPositions.put(startIndex, openPositions.getOrDefault(startIndex, 0) + (minChar - '0'));
                        closePositions.put(index, closePositions.getOrDefault(index, 0) + (minChar - '0'));
                        updateArray(startIndex, index, characters, minChar);
                        minChar = 60;
                        startIndex = index + 1;
                    } else if (characters[index] != '0') {
                        minChar = Math.min(minChar, characters[index]);
                        length++;
                    } else {
                        startIndex = index + 1;
                    }
                    index++;
                }
                
                if (minChar != 60) {
                    openPositions.put(startIndex, openPositions.getOrDefault(startIndex, 0) + (minChar - '0'));
                    closePositions.put(index, closePositions.getOrDefault(index, 0) + (minChar - '0'));
                    updateArray(startIndex, index, characters, minChar);
                    minChar = 60;
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                if (closePositions.containsKey(i)) {
                    appendCharacters(result, ')', closePositions.get(i));
                }
                if (openPositions.containsKey(i)) {
                    appendCharacters(result, '(', openPositions.get(i));
                }
                result.append(S.charAt(i));
            }
            
            if (closePositions.containsKey(S.length())) {
                appendCharacters(result, ')', closePositions.get(S.length()));
            }

            bw.write("Case #" + caseNumber + ": " + result.toString() + "\n");
            bw.flush();
            caseNumber++;
        }
        
        bw.close();
        br.close();
    }
    
    private static void updateArray(int start, int end, char[] array, int minChar) {
        for (int i = start; i < end; i++) {
            array[i] -= (minChar - '0');
        }
    }
    
    private static void appendCharacters(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}