import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i = 1; i <= t; i++){
            String line = in.next();
            String answer = "";
            int openParantheses = 0;
            for(int pos = 0; pos < line.length(); pos++) {
                int nr = Character.getNumericValue(line.charAt(pos));
                if(pos == 0 && pos == line.length() - 1){
                    answer += insertOpenParentheses(nr);
                    openParantheses += nr;
                    answer += nr;
                    answer += insertClosedParentheses(nr);
                    openParantheses -= nr;
                } else if(pos == 0){
                    answer += insertOpenParentheses(nr);
                    openParantheses += nr;
                    answer += nr;
                } else {
                    int lastNr = Character.getNumericValue(line.charAt(pos - 1));
                    if(nr > lastNr){
                        answer += insertOpenParentheses(nr - lastNr);
                        openParantheses += nr;
                        answer += nr;
                    } else if(nr < lastNr){
                        answer += insertClosedParentheses(lastNr - nr);
                        openParantheses -= nr;
                        answer += nr;
                    } else if (nr == lastNr){
                        answer += nr;
                    }
                }
            }
            if(openParantheses != 0){
                answer += insertClosedParentheses(openParantheses);
            }
            System.out.println("Case #" + i + ": " + answer);
        }
    }

    private static String insertOpenParentheses(int nr){
        String s = "";
        for(int i = 0; i < nr; i++){
            s += "(";
        }
        return s;
    }
    private static String insertClosedParentheses(int nr){
        String s = "";
        for(int i = 0; i < nr; i++){
            s += ")";
        }
        return s;
    }
}
