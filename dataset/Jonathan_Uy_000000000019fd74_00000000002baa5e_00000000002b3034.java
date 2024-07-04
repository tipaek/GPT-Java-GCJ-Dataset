import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            
            boolean possible = true;
            String pref = "";
            String suf = "";
            
            String word = br.readLine();
            if(word.charAt(0) == '*')   suf = word.substring(1);
            else if(word.charAt(word.length()-1) == '*')
                pref = word.substring(0, word.length() - 1);
            else {
                int index = word.indexOf("*");
                pref = word.substring(0, index);
                suf = word.substring(index+1);
            }
            
            for(int i = 1; i < N; i++){
                word = br.readLine();
                if(word.charAt(0) == '*'){
                    String thisSuf = word.substring(1);
                    if(thisSuf.length() == suf.length()){
                        possible = thisSuf.equals(suf);
                    } else if(thisSuf.length() > suf.length()){
                        String sub = thisSuf.substring(thisSuf.length()-suf.length());
                        if(sub.equals(suf)){
                            suf = thisSuf;
                        } else {
                            possible = false;
                        }
                    } else {
                        String sub = suf.substring(suf.length()-thisSuf.length());
                        if(sub.equals(thisSuf)){
                            suf = suf;
                        } else {
                            possible = false;
                        }
                    }
                } else if(word.charAt(word.length()-1) == '*'){
                    String thisPref = word.substring(0, word.length() - 1);
                    if(thisPref.length() == pref.length()){
                        possible = thisPref.equals(pref);
                    } else if(thisPref.length() > pref.length()){
                        String sub = thisPref.substring(0, pref.length());
                        if(sub.equals(pref)){
                            pref = thisPref;
                        } else {
                            possible = false;
                        }
                    } else {
                        String sub = pref.substring(0, thisPref.length());
                        if(sub.equals(thisPref)){
                            suf = suf;
                        } else {
                            possible = false;
                        }
                    }
                } else {
                    int index = word.indexOf("*");
                    String thisPref = word.substring(0, index);
                    String thisSuf = word.substring(index+1);
                    
                    if(thisSuf.length() == suf.length()){
                        possible = thisSuf.equals(suf);
                    } else if(thisSuf.length() > suf.length()){
                        String sub = thisSuf.substring(thisSuf.length()-suf.length());
                        if(sub.equals(suf)){
                            suf = thisSuf;
                        } else {
                            possible = false;
                        }
                    } else {
                        String sub = suf.substring(suf.length()-thisSuf.length());
                        if(sub.equals(thisSuf)){
                            suf = suf;
                        } else {
                            possible = false;
                        }
                    }
                    
                    if(thisPref.length() == pref.length()){
                        possible = thisPref.equals(pref);
                    } else if(thisPref.length() > pref.length()){
                        String sub = thisPref.substring(0, pref.length());
                        if(sub.equals(pref)){
                            pref = thisPref;
                        } else {
                            possible = false;
                        }
                    } else {
                        String sub = pref.substring(0, thisPref.length());
                        if(sub.equals(thisPref)){
                            suf = suf;
                        } else {
                            possible = false;
                        }
                    }
                }
            }
            
            if(possible)    System.out.println(pref + suf);
            else            System.out.println("*");
        }
    }
}