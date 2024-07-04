

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t =0; t<T; t++){
            int n = in.nextInt();
            List<String> list = new ArrayList<String>();
            for(int i=0; i<n; i++){
                list.add(in.next());

            }
            String res = findStr(list);
            System.out.println("Case #"+ t +":"+ res);
        }
    }

    public static String findStr(List<String> ps){
        log("find");
        int maxL = 0;
        StringBuilder ans = new StringBuilder();
        boolean finish = false;
        Collections.sort(ps, (a, b) -> b.length() - a.length());
        String tail = "";
        log("while");
        for(int i=0; i<ps.size(); i++){
            String s = ps.get(i);
            if(i==0){
                tail = s.replace("*", "");
                log(tail);
            } else {
                if (tail.endsWith(s.replace("*", "")))
                    continue;
                else
                    return "*";
            }
        }
        return tail;
    }

    public static void log(Object o){
        // System.out.println(o.toString());
    }

    /**
3
3
*12
*212
3212
3
32123
*12
*212
2
1
21
     */
}