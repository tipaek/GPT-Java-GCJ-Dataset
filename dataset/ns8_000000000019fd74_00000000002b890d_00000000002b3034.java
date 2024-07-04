import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numOfPatterns = in.nextInt();
            List<String> patterns = new ArrayList<>();
            for(int j=0;j<numOfPatterns;j++){
                patterns.add(in.next());
            }
            String s = getString(patterns);
//            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
        }
    }

    private static String getString(List<String> patterns){
        List<String> prefix = new ArrayList<>();
        List<String> suffix = new ArrayList<>();
        List<String> middle = new ArrayList<>();
        for(String pattern:patterns){
            if(pattern.equalsIgnoreCase("*")){
                return pattern;
            }
            int i = pattern.indexOf("*");
            if(i == 0){
                suffix.add(pattern);
            }else if(i == pattern.length()-1){
                prefix.add(pattern);
            }else{
                middle.add(pattern);
            }
        }
        Collections.sort(prefix, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String prefixS = "";
        for(String s:prefix){
            if(prefixS == ""){
                prefixS = s.substring(0,s.length()-1);
            }else{
                if(!s.startsWith(prefixS)){
                    return "*";
                }
                prefixS = s.substring(0,s.length()-1);
            }
        }
        //System.out.println(prefixS);


        Collections.sort(suffix, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        String suffixS = "";
        for(String s:suffix){
            if(suffixS == ""){
                suffixS = s.substring(1);
            }else{
                if(!s.endsWith(suffixS)){
                    return "*";
                }
                suffixS = s.substring(1,s.length());
            }
        }
        //System.out.println(suffixS);
        
        return prefixS+suffixS;
    }

}

