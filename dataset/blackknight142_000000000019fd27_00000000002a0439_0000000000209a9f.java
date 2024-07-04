import java.util.*;
import java.io.*;

public class ting {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int ll = in.nextInt();
        for (int i = 1; i <= ll; i++) {
            String str = in.next();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                list.add(Integer.parseInt(Character.toString(str.charAt(j))));
            }
            String out = "";
            for (int j = 0; j < s.length(); j++) {
                for (int k = list.get(j); k > 0; k--) {
                    if (out.length() != 0 && out.charAt(out.length() - 1) == ')')
                        out = out.substring(0, out.length() - 1);
                    else
                        out += "(";
                }
                out += list.get(j);
                for (int k = list.get(j); k > 0; k--) {
                    out += ")";
                }
            }
            System.out.println("Case #" + i + ": " + out);
        }
    }
}