import sun.applet.AppletResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;
        while(t-- > 0){
            char ch[] = br.readLine().toCharArray();
            long nestLevel = 0L;
            int prev = 0;
            String output = "";
            for(int i = 0; i < ch.length; i++){
                int current = ch[i] - '0';
                if(current == 0){
                    while(nestLevel > 0){
                        output += ")";
                        nestLevel--;
                    }
                    output += "0";
                    prev = current;
                    continue;
                }
                if(current == nestLevel) {
                    output += current;
                    prev = current;
                    continue;
                }
                else{
                  int diff = current - prev;
                  if(diff == 0){
                      output += ch[i];
                      continue;
                  }
                  if(diff > 0){
                      while(diff > 0){
                          output += "(";
                          nestLevel++;
                          diff--;
                      }
                      output += ch[i];
                      prev = current;
                      continue;
                  }
                  if(diff < 0){
                      diff = diff * -1;
                      while(diff > 0){
                          output += ")";
                          nestLevel--;
                          diff --;
                      }
                      output += ch[i];
                      prev = current;
                      continue;
                  }

                }

            }
            while(nestLevel > 0){
                output += ")";
                nestLevel--;
            }
            System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
        }
    }
}
