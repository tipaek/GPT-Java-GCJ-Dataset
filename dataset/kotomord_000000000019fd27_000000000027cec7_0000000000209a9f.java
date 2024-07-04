import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int _ = 0; _<t; ++_){
            String s = scan.next();
            List<Integer> ls = new ArrayList<>();
            for(int j = 0; j<s.length(); ++j)
                ls.add(s.charAt(j)-'0');
            System.out.print("Case #" + _ + ": ");    
            procList(ls, 0);
            System.out.println();
        }

    }

    private static void procList(List<Integer> ls, int add) {
        if (ls.size() == 0) {
            return;
        }
        if (ls.get(0).intValue() == 0) {
            System.out.print(add);
            procList(ls.subList(1, ls.size()), add);
            return;
        }
        int k = ls.size();
        for(int i = 0; i<k; ++i){
            if(ls.get(i).intValue() == 0){
                k = i;
                break;
            }
        }
        for(int i = 0; i<k; ++i){
            ls.set(i, ls.get(i)-1);
        }
        System.out.print("(");
        procList(ls.subList(0, k), add+1);
        System.out.print(")");
        if (k!=ls.size()){
            procList(ls.subList(k, ls.size()), add);
        }

    }
}
