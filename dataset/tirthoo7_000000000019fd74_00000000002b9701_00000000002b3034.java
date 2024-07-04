/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;

/**
 *
 * @author EliteBook
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        new Solution().getResult();
    }

    public void getResult() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            StringBuilder[] pat = new StringBuilder[n];
            int maxLengthStringIndex = -1;
            int maxLengthString = 0;
            int secondMaxLengthStringIndex = -1;
            int secondMaxLengthString = 0;
            
            for (int i = 0; i < n; i++) {
                pat[i] = new StringBuilder(br.readLine().trim());
                if (pat[i].length() > maxLengthString) {
                    secondMaxLengthString=maxLengthString;
                    secondMaxLengthStringIndex=maxLengthStringIndex;
                    maxLengthString = pat[i].length();
                    maxLengthStringIndex = i;
                }
                else if(pat[i].length()>secondMaxLengthString && pat[i].length()<maxLengthString){
                    secondMaxLengthString=pat[i].length();
                    secondMaxLengthStringIndex=i;
                }
            }
            
//            System.out.println("max"+pat[maxLengthStringIndex]);
//            System.out.println("sec max"+pat[secondMaxLengthStringIndex]);
            int astIndexMaxLengthString=pat[maxLengthStringIndex].indexOf("*");
            int astIndexSecMaxLengthString=pat[secondMaxLengthStringIndex].indexOf("*");
//            System.out.println(astIndexMaxLengthString);
//            System.out.println(astIndexSecMaxLengthString);
            StringBuilder name=new StringBuilder();
            if(astIndexMaxLengthString==0 && astIndexSecMaxLengthString==pat[secondMaxLengthStringIndex].length()-1){
                name.append(pat[secondMaxLengthStringIndex]);
                name.deleteCharAt(name.indexOf("*"));
                name.append(pat[maxLengthStringIndex]);
                name.deleteCharAt(name.indexOf("*"));
            }
            else if(astIndexSecMaxLengthString==0 && astIndexMaxLengthString==pat[maxLengthStringIndex].length()-1){
                name.append(pat[maxLengthStringIndex]);
                name.deleteCharAt(name.indexOf("*"));
                name.append(pat[secondMaxLengthStringIndex]);
                name.deleteCharAt(name.indexOf("*"));
            }
            else{
                name = pat[maxLengthStringIndex];
                name.replace(astIndexMaxLengthString, astIndexMaxLengthString+1, "");
            }
            
            
            
//            System.out.println(name);
            boolean res=true;
            for(int i=0;i<n;i++){
                
                if(!match(pat[i].toString(),name.toString())){
                    res=false;
                    
                }
            }
            if(res){
                System.out.println("Case #"+t+": "+name);
            }
            else{
                System.out.println("Case #"+t+": *");
            }

        }

    }

    public boolean match(String first, String second) {

        // If we reach at the end of both strings,  
        // we are done 
        if (first.length() == 0 && second.length() == 0) {
            return true;
        }

        // Make sure that the characters after '*'  
        // are present in second string.  
        // This function assumes that the first 
        // string will not contain two consecutive '*' 
        if (first.length() > 1 && first.charAt(0) == '*'
                && second.length() == 0) {
            return false;
        }

        // If the first string contains '?',  
        // or current characters of both strings match 
        if ((first.length() > 1 && first.charAt(0) == '?')
                || (first.length() != 0 && second.length() != 0
                && first.charAt(0) == second.charAt(0))) {
            return match(first.substring(1),
                    second.substring(1));
        }

        // If there is *, then there are two possibilities 
        // a) We consider current character of second string 
        // b) We ignore current character of second string. 
        if (first.length() > 0 && first.charAt(0) == '*') {
            return match(first.substring(1), second)
                    || match(first, second.substring(1));
        }
        return false;
    }


}
