import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for(int x = 0; x < t; x++){
            String n = in.next();

            String ans = "";
            if(n.charAt(0)==1) ans += "(";
            ans+= n.charAt(0);
            for(int i = 1; i < n.length(); i++){
                if(n.charAt(i-1)==1 && n.charAt(i)==0)
                    ans+=")";
                if(n.charAt(i-1)==0 && n.charAt(i)==1)
                    ans+="(";
                ans+= ""+n.charAt(i);
            }
            if(n.charAt(n.length()-1)==1) ans += "(";

            System.out.println("Case #"+(x+1)+": "+ans);
        }

    }
}