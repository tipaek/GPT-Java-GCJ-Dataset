import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for(int i=1;i<=t;i++){
            LinkedList<String> res = new LinkedList<>();
            int op = 0;
            int prev = 0;
            String s = scan.nextLine();
            for(int j=0; j<s.length();j++){
                int cur = Integer.parseInt(s.substring(j,j+1));
                if(prev == cur) res.addLast(Integer.toString(cur));
                else if(op == 0){
                    for(int k=0;k<cur;k++){
                        res.addLast("(");
                        op++;
                    }
                    res.addLast(Integer.toString(cur));
                }else if(prev>cur){
                    for(int k=0;k<prev-cur;k++){
                        res.addLast(")");
                        op--;
                    }
                    res.addLast(Integer.toString(cur));
                }else if(cur>prev){
                    for(int k=0;k<cur-prev;k++){
                        res.addLast("(");
                        op++;
                    }
                    res.addLast(Integer.toString(cur));
                }
                prev = cur;
            }
            for(int j=0;j<op;j++){
                res.addLast(")");
            }
            System.out.printf("Case #%d: ",i);
            for(String el : res){
                System.out.print(el);
            }
            System.out.println();
        }

    }
}
