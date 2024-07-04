import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int k = 0; k < t; k++) {
            String s = in.nextLine();
            String sp = s;
            int[] sInt = new int[s.length()];

            for (int i = 0; i < s.length(); i++) {
                sInt[i] = Character.getNumericValue(s.charAt(i));
            }

            for (int i = 9; i > 0; i--) {
                for (int j = 0; j < sInt.length; j++) {
                    int o;
                    for (o = 0; j+o < sInt.length && sInt[j+o] >= i; o++);
                    if (o == 0) continue;
                    //put everything from j to j+o inclusive inside parentheses
                    sp = sp.substring(0,newIndex(j,sp))+"("+sp.substring(newIndex(j,sp), newIndex(j+o-1,sp)+1)+")"+sp.substring(newIndex(j+o-1,sp)+1);
                    j += o;
                }
            }

            System.out.println("Case #" + (k+1) + ": " + sp);
        }
    }
    static int newIndex(int index, String sp) {
        int ret;
        for (ret = 0; index >= 0; ret++) {
            if (sp.charAt(ret) == ')' || sp.charAt(ret) == '(') {
                continue;
            }
            index--;
        }
        return ret-1;
    }
}