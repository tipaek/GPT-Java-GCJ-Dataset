import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i<t ; i++){
            String s = in.nextLine();
            System.out.println("Case #" + (i+1) +": " + getResult(s));
        }
    }

    public static String getResult(String s){
        String res = "";
        int depth = 0;
        for(int i = 0; i < s.length(); i++){
            int num = Character.getNumericValue(s.charAt(i));
            if( num > depth){
                int diff = num - depth;
                while(diff >0){
                    res += "(";
                    diff--;
                    depth+=1;
                }
            }
            if( num < depth){
                int diff = depth - num;
                while(diff > 0){
                    res += ")";
                    diff--;
                    depth-=1;
                }
            }
            res += s.charAt(i);
        }
        return res;
    }

}


    