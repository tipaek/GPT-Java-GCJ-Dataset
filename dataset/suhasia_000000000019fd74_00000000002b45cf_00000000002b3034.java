import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int n = in.nextInt();
            String[] strings = new String[n];
            String max = "";
            for(int i = 0; i < n; i++){
                strings[i] = in.next();
                if(strings[i].length()>max.length()) max = strings[i];
            }
            boolean possible = true;
            for(int i = 0; i < n; i++){
                //System.out.println(strings[i]+" "+subset(max,strings[i]));
                if(!subset(max, strings[i])){
                    possible = false;
                    break;
                }
            }

            if(possible) System.out.println("Case #" + (x + 1) + ": " + max.substring(1,max.length()));
            else System.out.println("Case #" + (x + 1) + ": *");
        }
    }

    public static boolean subset(String a, String b){
        String x = "";
        String y = "";
        if(a.length()<b.length()){
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        for(int i = 0; i < x.length()-1; i++){
            //System.out.println(y.charAt(y.length()-i-1)+", "+x.charAt(x.length()-i-1));
            if(y.charAt(y.length()-i-1)!=x.charAt(x.length()-i-1)) return false;
        }
        return true;
    }
}

