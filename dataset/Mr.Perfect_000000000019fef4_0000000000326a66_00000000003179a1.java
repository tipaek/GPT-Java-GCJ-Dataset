import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        int c = 0;
        while(c++<t) {
            int u = Integer.parseInt(s.nextLine());
            StringBuilder d = new StringBuilder();
            boolean startChars[] = new boolean[26];
            int charCounts[] = new int[26];
            for(int i = 0; i < 10000; ++i) {
                char r[] = s.nextLine().split(" ")[1].toCharArray();
                int l = r.length;
                startChars[r[0]-'A']=true;
                for(char ch : r) {
                    int chVal = ch-'A';
                    charCounts[chVal]++;
                }
            }
            int zeroChar = -1;
            List<CharCount> list = new ArrayList<>();
            for(int i = 0; i < 26; ++i) {
                if(charCounts[i] > 0) {
                    if(!startChars[i]) {
                        zeroChar = i;
                    } else {
                        list.add(new CharCount((char) (i+'A'), charCounts[i]));
                    }
                }
            }
            Collections.sort(list, Collections.reverseOrder());

            d.append((char)(zeroChar+'A'));
            for(CharCount item : list) {
                d.append(item.ch);
            }
            System.out.println("Case #" + c + ": " + d.toString());
        }
    }

    public static class CharCount implements Comparable<CharCount> {
        char ch;
        Integer count;
        public CharCount(char ch, int count){
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(CharCount charCount) {
            return this.count.compareTo(charCount.count);
        }
    }


}
