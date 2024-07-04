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
                for(int j = 0; j<26; j++){
                  charMapping[j] = 11;
                }
                int currChar = 0;
                boolean[] foundChar = new boolean[26];
                for(int j = 0; j < 10000; j++){
                
                  st = new StringTokenizer(br.readLine());
                  long m = Integer.parseInt(st.nextToken());
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
                     if(charMapping[initChar - 'A']>firstM){
                        charMapping[initChar - 'A'] = firstM;
                     }
                  }
                }
                String finalString = "";
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
                System.out.println("Case #" + i + ": " + finalString);
            }
        }catch(IOException e){
            return;
        }
    }
    
}