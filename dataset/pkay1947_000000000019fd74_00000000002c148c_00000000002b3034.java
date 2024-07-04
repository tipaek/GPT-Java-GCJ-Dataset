import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        for (int z=1; z<=T; z++) {
            int n=in.nextInt();
            String[] ar=new String[n], br=new String[n];
            String[] str; String bf="", af="";
            for (int i=0; i<n; i++) {                
                str=in.next().split("\\*");
                //System.out.println(" -> " + Arrays.toString(str));
                ar[i]=str[0]; br[i]=(str.length>1)?str[1]:null;                
                if (str[0].length() > bf.length()) bf=str[0];
                if (str.length>1 && str[1].length() > af.length()) af=str[1];
            }
            //System.out.println(" to find " + bf + " + " + af);
            String ans=bf+af;
            for (int i=0; i<n; i++) {
                if (ar[i] != null && !ans.startsWith(ar[i])) {
                    ans="*"; break;
                }
                if (br[i] != null && !ans.endsWith(br[i])) {
                    ans="*"; break;
                }
            }
            System.out.println("Case #" + z + ": " + ans);
        }
    }
}
