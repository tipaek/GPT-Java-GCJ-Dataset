import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int n = in.nextInt();
            String[] strings = new String[n];
            int[] starpos = new int[n];
            for(int i = 0; i < n; i++){
                strings[i] = in.next();
                starpos[i] = strings[i].indexOf('*');
            }
            String ans = strings[0];
            int anspos = starpos[0];
            boolean possible = true;
            for(int i = 1; i < n; i++){
                String ansfront = ans.substring(0,anspos);
                String ansback = ans.substring(anspos+1,ans.length());
                String strfront = strings[i].substring(0,starpos[i]);
                String strback = strings[i].substring(starpos[i]+1, strings[i].length());
                //System.out.println(ansback+", "+ strback+": "+frontsubset(ansfront,strfront)+", "+backsubset(ansback, strback));
                if(backsubset(ansback, strback) && frontsubset(ansfront,strfront)){
                    ans = combine(ansfront, ansback, strfront, strback);
                    anspos = ans.indexOf('*');
                } else {
                    possible = false;
                    break;
                }
            }

            if(possible) System.out.println("Case #" + (x + 1) + ": " + ans.substring(0,anspos)+ans.substring(anspos+1,ans.length()));
            else System.out.println("Case #" + (x + 1) + ": *");
        }
    }

    public static String combine(String afront, String aback, String bfront, String bback){
        String front = "";
        String back = "";
        if(afront.length()>bfront.length()) front = afront;
        else front = bfront;

        if(aback.length()>bback.length()) back = aback;
        else back = bback;
        return front+"*"+back;
    }

    public static boolean backsubset(String a, String b){
        String x = "";
        String y = "";
        if(a.length()<b.length()){
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        for(int i = 0; i < x.length(); i++){
            //System.out.println(y.charAt(y.length()-i-1)+", "+x.charAt(x.length()-i-1));
            if(y.charAt(y.length()-i-1)!=x.charAt(x.length()-i-1)) return false;
        }
        return true;
    }

    public static boolean frontsubset(String a, String b){
        String x = "";
        String y = "";
        if(a.length()<b.length()){
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        for(int i = 0; i < x.length(); i++){
            //System.out.println(y.charAt(y.length()-i-1)+", "+x.charAt(x.length()-i-1));
            if(y.charAt(i)!=x.charAt(i)) return false;
        }
        return true;
    }


}

