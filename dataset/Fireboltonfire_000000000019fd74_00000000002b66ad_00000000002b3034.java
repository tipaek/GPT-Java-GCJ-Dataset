import java.util.*;
import java.io.*;

public class Solution{
    
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            String s = solve(in);
            System.out.println("Case #" + i + ": " + s);
        }
        in.close();
    }
    
    public static String solve(Scanner in){
        int n = in.nextInt();
        List<String> fp = new ArrayList<>();
        List<String> lp = new ArrayList<>();
        List<String> patterns = new ArrayList<>();
        for(int i=0; i<n; i++){
            String s = "A" + in.next() + "Z";
            patterns.add(s);
            String[] p = s.split("\\*");
            fp.add(p[0]);
            lp.add(p[p.length - 1]);
        }
        int maxFP = 0;
        String maxFPs = "";
        int maxLP = 0;
        String maxLPs = "";
        for(String s : fp){
            if(s.length() > maxFP){
                maxFP = s.length();
                maxFPs = s;
            }
        }
        for(String s : lp){
            if(s.length() > maxLP){
                maxLP = s.length();
                maxLPs = s;
            }
        }
        boolean flag = true;
        for(String s : fp){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) != maxFPs.charAt(i)){
                    flag = false;
                    break;
                }
            }
            // System.out.println(s + " " + String.valueOf(flag));
        }
        for(String s : lp){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(s.length() - i - 1) != maxLPs.charAt(maxLPs.length() - i - 1)){
                    flag = false;
                    break;
                }
            }
            // System.out.println(s + " " + String.valueOf(flag));
        }
        // System.out.println(maxFPs);
        // System.out.println(maxLPs);
        
        if(!flag){
            return "*";
        }
        
        StringBuilder sb = new StringBuilder(maxFPs);
        for(String p : patterns){
            String[] ps = p.split("\\*");
            for(int i = 1; i < ps.length - 1; i++){
                sb.append(ps[i]);
            }
        }
        sb.append(maxLPs);
        String s = sb.toString();
        return s.substring(1,s.length()-1);
    }
    
}