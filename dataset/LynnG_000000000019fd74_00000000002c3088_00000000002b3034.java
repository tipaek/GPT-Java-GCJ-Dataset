


import java.util.*;
import java.io.*;
//import java.util.regex.*;  

public class Solution {
  public static void main(String[] args) {
    
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));    
    int t = in.nextInt(); //number of tests
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt(); //number of patterns
        in.nextLine();
        String[] p = new String[n];
        //String[][] p = new String[n][50];
        int longIndex = 0;
        String output = "";
        String input ="";
        for(int j = 0; j <n; j++){
            p[j] = in.nextLine();
            if (p[j].length() > p[longIndex].length()){
                longIndex = j;
            }
            //System.out.println("longIndex is " + ": "+ longIndex);
        }
        
        //in simple case, use longest and check that each is a subset
        output = p[longIndex].substring(1);
        //System.out.println(output);
        for(int j = 0; j <n; j++){
            //System.out.println(p[longIndex].indexOf(p[j].substring(1)));
            //System.out.println(p[longIndex].length()-p[j].length());
            if(!output.endsWith(p[j].substring(1))){
                output = "*";
                j = n;
                //System.out.println(output + " "+ j);
            }
            
        }
        
        System.out.println("Case #" + i +": " + output);

    }
  } 
}
