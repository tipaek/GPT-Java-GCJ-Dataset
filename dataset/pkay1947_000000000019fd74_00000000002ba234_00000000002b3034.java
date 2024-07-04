import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=in.nextInt();
        for (int z=1; z<=T; z++) {
            int n=in.nextInt();
            List<String> list = new ArrayList<>();
            for (int i=0; i<n; i++) list.add(in.next());
            Comparator<String> sSort = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
            Collections.sort(list, sSort);
            
            n--;
            String ans=list.get(n).substring(1);
            for (int i=0; i<n; i++) {
                if (!ans.endsWith(list.get(i).substring(1))) {
                    ans="*"; break;
                }
            }
            System.out.println("Case #" + z + ": " + ans);
        }
    }
}
