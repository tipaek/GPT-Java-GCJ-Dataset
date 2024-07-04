
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int total = Integer.parseInt(in.nextLine());

        for(int i=1; i<=total; i++){
            String[] words = new String[Integer.parseInt(in.nextLine())];

            for(int j=0; j<words.length; j++){
                words[j] =  in.nextLine();
            }
            System.out.printf("Case #%d: %s",i,foundMatchingPattern(words));
        }
    }

    private static String foundMatchingPattern(String[] words) {
        String finalPattern = "*";
        String longString = words[0];
        int maxLength = Integer.MIN_VALUE;
        int asterisk[] = new int[words.length];
       List<String> tracker =new ArrayList<>();
        int maxAsterick = maxNumberOfAsterick(words);
        int countAsterisk = 0;
        String match ="";
        while (countAsterisk < maxAsterick) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int len = beforeNextAsterisk(word, 0, word.length()) + 1;
                asterisk[i] = len;
                String bfA = len == -1 ? word : word.substring(0, len);
                if (bfA.length() > maxLength) {
                    longString = bfA;
                    maxLength = bfA.length();
                }
            }
            match += longString.replace("*", "");

            boolean foundInAll = false;
            for (int w = 0; w < words.length; w++) {
                String stringToMatch = words[w].substring(0, asterisk[w]).replace("*", ".*");
                Pattern pattern = Pattern.compile(stringToMatch);
                Matcher matcher = pattern.matcher(match);


                if (matcher.matches()) {
                    words[w] = (asterisk[w] != -1 || asterisk[w] + 1 < words.length - 1) ? words[w].substring(asterisk[w], words[w].length()) : "";
                } else {
                    match = finalPattern;
                    break;
                }
            }
            countAsterisk++;
        }
            return match;

    }

    private static int beforeNextAsterisk(String word, int start, int end){

        int asterickPos=-1;
         word = word.substring(start,end);
            char[] c = word.toCharArray();
            int count =0;
            for(int i=0; i<c.length; i++){
                if(c[i] == '*' && count ==1){
                    asterickPos = i;
                    count++;
                } else if(i == c.length-1){
                    return i;
                }


            }
            return asterickPos;

    }

    private static int maxNumberOfAsterick(String[] words){
        int max = 0;
        for(String s : words){
            int counting =0;
            for(char c : s.toCharArray()){
                if(c =='*'){
                    counting++;
                }
            }
            max = Integer.max(counting,max);
        }
        return max;
    }
}
