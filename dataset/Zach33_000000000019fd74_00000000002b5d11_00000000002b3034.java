import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++) {
            int numWords = scan.nextInt();
            ArrayList<String> words = new ArrayList<>();
            for(int j = 0; j < numWords; j++) {
                words.add(scan.next());
            }
            String word = "";
            while(true) {
                String add = getMax(words);
                if(add.equals("!")) {
                    word = "*";
                    break;
                }
                word += add;
                int numEnded = 0;
                for(int j = 0; j < numWords; j++) {
                    String str = words.get(j);
                    int toa = str.indexOf("*");
                    if(toa==-1) {
                        str = "";
                        numEnded++;
                    } else {
                        if(toa==0) {
                            str = str.substring(toa + 1);
                        } else {
                            str = str.substring(toa);
                        }
                        words.set(j,str);
                    }
                }
                if(numEnded==numWords) {
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n",i+1,word);
        }
    }

    public static String getMax(ArrayList<String> strs) {
        String max = "";
        for(String str : strs) {
            int toa = str.indexOf("*");
            if(toa==-1)toa=str.length();
            String sub = str.substring(0,toa);
            if(sub.length()>max.length()) {
                if(!sub.contains(max))return "!";
                max = sub;
            } else {
                if(!max.contains(sub))return "!";
            }
        }
        return max;
    }
}
