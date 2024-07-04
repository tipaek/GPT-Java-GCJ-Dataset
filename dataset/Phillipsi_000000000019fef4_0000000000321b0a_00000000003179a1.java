import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        try{
        
		      //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for(int i = 1; i<=t; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                long[] charMapping = new long[26];
                int currentFound = 0;
                int[] occurrences = new int[26];
                for(int j = 0; j<26; j++){
                  charMapping[j] = 11;
                  occurrences[j] = 0;
                }
                int currChar = 0;
                boolean[] foundChar = new boolean[26];
                boolean set3 = true;
                for(int j = 0; j < 10000; j++){
                
                  st = new StringTokenizer(br.readLine());
                  long m = Long.parseLong(st.nextToken());
                  String val = st.nextToken();
                  char initChar = val.charAt(0);
                  
                  if(currentFound < 10){
                     for(int k = 0; k<val.length(); k++){
                        if(!foundChar[val.charAt(k)- 'A']){
                           foundChar[val.charAt(k)- 'A'] = true;
                           currentFound++;
                        }
                     }
                  }
                  long firstM = m / ((long)(Math.pow(10, val.length()-1)));
                  if(firstM > 0){
                     set3 = false;
                     if(charMapping[initChar - 'A']>firstM){
                        charMapping[initChar - 'A'] = firstM;
                     }
                  }
                  if(m == -1 && val.length()==u){
                     occurrences[initChar - 'A']++;
                  }
                }
                String finalString = "";
                if(!set3){
                   for(int j = 1; j<10; j++){
                     for(int k = 0; k<26; k++){
                        if(charMapping[k] == j){
                           finalString = finalString+((char)('A'+k));
                        }
                     }
                   }
                   for(int j = 0; j<26; j++){
                     if(charMapping[j]==11 && foundChar[j]){
                        finalString = ((char)('A'+j))+finalString;
                     }
                   }
                }else{
                  int[] greaterTable = new int[9];
                  for(int j = 0; j<26; j++){
                     int greaterThan = 0;
                     if(j >0){
                        for(int k = 0; k<26; k++){
                           if(occurrences[j]>0 && occurrences[k]>0){
                              if(occurrences[k]>occurrences[k]){
                                 greaterThan++;
                              }
                           }
                        }
                        greaterTable[greaterThan] = j;
                     }
                   }
                   for(int j = 0; j<9; j++){
                      finalString = ((char)('A'+greaterTable[j]))+finalString;
                   }
                   for(int j = 0; j<26; j++){
                     if(occurrences[j]==0 && foundChar[j]){
                        finalString = ((char)('A'+j))+finalString;
                     }
                   }
                }
                System.out.println("Case #" + i + ": " + finalString);
            }
        }catch(IOException e){
            return;
        }
    }
    
}