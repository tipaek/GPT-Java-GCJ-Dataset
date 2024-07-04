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
            System.out.println("Case #" + i + ": " + s);
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
            int j = pattern.lastIndexOf("*");
            if(i == 0 && j==0){
                suffix.add(pattern);
            }else if(i == pattern.length()-1 && j == pattern.length()-1){
                prefix.add(pattern);
            }else{
                prefix.add(pattern.substring(0,i+1));
                suffix.add(pattern.substring(j,pattern.length()));
                middle.add(pattern.substring(i,j+1));
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
//        System.out.println(prefixS);


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
//        System.out.println(suffixS);

        Collections.sort(suffix, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        String middleS = "";
        for (String m:
             middle) {
            if(middleS == ""){
                middleS = m.replace("*","");
            }else{
                if(!middleS.contains(m.replace("*",""))){
                    middleS+=m.replace("*","");
                }else{
                middleS = m.replace("*","");
                }
            }

        }
//        System.out.println("middle: "+middleS);
//        System.out.println( prefixS+middleS+suffixS);
        String result = prefixS+middleS+suffixS;
        
        return result;
    }

}

