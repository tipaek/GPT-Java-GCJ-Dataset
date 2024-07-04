import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int cases = Integer.parseInt(input.readLine());

        for(int z =0; z<cases; z++){
            int N = Integer.parseInt(input.readLine());
            String ans = "";
            boolean printed = false;
            for(int i = 0; i<N; i++){
                String a = input.readLine();
                String b = ans;
                ArrayList<Integer> ai = new ArrayList<Integer>();
                ArrayList<Integer> bi = new ArrayList<Integer>();
                for(int A = 0; A<a.length(); A++){
                    if(a.charAt(A) == '*'){
                        ai.add(A);
                    }
                }
                for(int A = 0; A<a.length(); A++){
                    if(b.charAt(A) == '*'){
                        ai.add(A);
                    }
                }
                if(ai.size() == 1 && bi.size() == 1){
                    String ab = a.substring(0, ai.get(0)); //a before
                    String bb = b.substring(0, bi.get(0));
                    String aa = a.substring(ai.get(0), a.length()); //a after
                    String ba = b.substring(bi.get(0), b.length());
                    int X = Math.min(ab.length(), bb.length());
                    boolean b = true;
                    for(int x = 0; x<X; x++){
                        if(ab.charAt(x)!=bb.charAt(x)){
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        if(ab.length()>bb.length()) ans+=ab;
                        else ans+=bb;
                    }
                    else{
                        output.println("*");
                        printed = true;
                        break;
                    }

                    b = true;
                    X = Math.min(aa.length(), ba.length());
                    for(int x = X; x>=0; x--){
                        if(aa.charAt(x)!=ba.charAt(x)){
                            b = false;
                            break;
                        }
                    }
                    if(b){
                        if(aa.length()>ba.length()) ans+=aa;
                        else ans+=ba;
                    }
                    else{
                        output.println("*");
                        printed = true;
                        break;
                    }
                }
            }
            if(!printed)
                output.println(ans);

        }
        output.flush();
        output.close();
    }
}