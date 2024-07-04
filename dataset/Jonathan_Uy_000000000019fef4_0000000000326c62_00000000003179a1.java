import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 1; t <= T; t++){
            int U = Integer.parseInt(br.readLine());
            boolean hard = false;
            
            char[] D = new char[10];
            int[] minVal = new int[26];
            int[] maxVal = new int[26];
            Arrays.fill(maxVal, 9);
            int[] freq = new int[26];
            boolean[] appears = new boolean[26];
            String[] r = new String[10000];
            
            for(int q = 0; q < 10000; q++){
                st = new StringTokenizer(br.readLine());
                String qi = st.nextToken();
                String ri = st.nextToken();
                r[q] = ri;
                
                for(int i = 0; i < ri.length(); i++)
                    freq[(int) (ri.charAt(0) - 'A')]++;
                
                minVal[(int) (ri.charAt(0) - 'A')] = 1;
                for(int i = 0; i < ri.length(); i++)
                    appears[(int) (ri.charAt(i) - 'A')] = true;
                
                if(!qi.equals("-1")){
                    if(qi.length() == ri.length()){
                        maxVal[(int) (ri.charAt(0) - 'A')] = Math.min(maxVal[(int) (ri.charAt(0) - 'A')], (int) (qi.charAt(0) - '0'));
                    }
                } else {
                    hard = true;
                }
            }
            Arrays.sort(r);
            
            for(int i = 0; i < 26; i++){
                if(appears[i] && minVal[i] != 1){
                    D[0] = (char) (i + 'A');
                    maxVal[i] = 0;
                }
            }
            
            for(int i = 1; i <= 9; i++){
                for(int letter = 0; letter < 26; letter++){
                    if(appears[letter] && maxVal[letter] == i){
                        D[i] = (char) (letter + 'A');
                    }
                }
            }
            
            if(hard){
                int zero = -1;
                for(int letter = 0; letter < 26; letter++)
                    if(appears[letter] && minVal[letter] == 0)
                        zero = letter;
                
                D[0] = (char) (zero + 'A');
                freq[zero] = Integer.MAX_VALUE;
                
                for(int i = 1; i <= 9; i++){
                    int least = zero;
                    for(int letter = 0; letter < 26; letter++){
                        if(appears[letter] && freq[letter] < freq[least]){
                            least = letter;
                        }
                    }
                    
                    D[i] = (char) (least + 'A');
                    appears[least] = false;
                }
            }
            
            System.out.printf("Case #%d: ", t);
            for(char c : D) System.out.print(c);
            System.out.println();
        }
    }
}