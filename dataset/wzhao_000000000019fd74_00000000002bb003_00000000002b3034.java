import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int cases = Integer.parseInt(input.readLine());

        for(int z =0; z<cases; z++){
            int N = Integer.parseInt(input.readLine());
            String ans = input.readLine();
            boolean printed = false;
            for(int i = 1; i<N; i++){
                String a = input.readLine();
                String b = ans;
                ArrayList<Integer> ai = new ArrayList<Integer>();
                ArrayList<Integer> bi = new ArrayList<Integer>();
                for(int A = 0; A<a.length(); A++){
                    if(a.charAt(A) == '*'){
                        ai.add(A);
                    }
                }
                for(int A = 0; A<b.length(); A++){
                    if(b.charAt(A) == '*'){
                        bi.add(A);
                    }
                }

                if(ai.size() == 1 && bi.size() == 1){
                    //String ab = a.substring(0, ai.get(0)); //a before
                    //String bb = b.substring(0, bi.get(0));
                    String aa = a.substring(ai.get(0)+1, a.length()); //a after
                    String ba = b.substring(bi.get(0)+1, b.length());
                    //int X = Math.min(ab.length(), bb.length());
                    boolean B = true;
                    /*
                    for(int x = 0; x<X; x++){
                        if(ab.charAt(x)!=bb.charAt(x)){
                            B = false;
                            break;
                        }
                    }
                    if(B){
                        if(ab.length()>bb.length()) ans+=ab;
                        else ans+=bb;
                    }
                    else{
                        output.println("*");
                        printed = true;
                        break;
                    }*/

                    B = true;
                    int X = Math.min(aa.length(), ba.length());
                    for(int x = 0; x<X; x++){
                        if(aa.charAt(aa.length()-1-x)!=ba.charAt(ba.length()-1-x)){
                            B = false;
                            break;
                        }
                    }
                    if(B){
                        if(aa.length()>ba.length()){
                            ans+=aa;
                        }
                        //else ans+=ba;
                    }
                    else{
                        output.println("Case #" + (z+1) + ": *");
                        printed = true;
                        break;
                    }
                }
            }
            if(!printed)
                output.println("Case #" + (z+1) + ": ans.substring(1, ans.length())");

        }
        output.flush();
        output.close();
    }
}