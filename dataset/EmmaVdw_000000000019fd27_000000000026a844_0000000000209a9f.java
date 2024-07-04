import java.util.*;
import java.io.*;

public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                String n = in.nextLine();
                StringBuffer str = new StringBuffer(n);
                int open = 0;
                int closed = 0;
                int index;
                int nextindex = 0;
                for (int j = 0; j < n.length(); ++j) {
                    index=nextindex;
                    char character = n.charAt(j);
                    if (Character.isDigit(character)) {
                        int num = Character.getNumericValue(character);
                        if (open < num) {
                            int x = num-open;
                            for (int k = 0; k < x; ++k) {
                                str.insert(index, '(');
                                index+=1;
                                nextindex+=1;
                                open += 1;
                                closed -=1;
                            }
                        }
                        if((j+1)<n.length()){
                            char nextCharacter=n.charAt(j+1);
                            if (Character.isDigit(nextCharacter)) {
                                int nextNum = Character.getNumericValue(nextCharacter);
                                if(nextNum<num){
                                    nextindex=index;
                                    for(int k=0; k<(num-nextNum); ++k){
                                        str.insert(index+1, ')');
                                        nextindex+=1;
                                        closed+=1;
                                        open-=1;
                                    }
                                }
                            }
                        }
                        if(j==n.length()-1){
                            for(int k=0; k<(num-closed); ++k){
                                str.append(')');
                                closed+=1;
                            }
                        }
                        nextindex+=1;
                    }
                }
                System.out.println("Case #" + i+": "+str);
            }
        }
}

