import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ts = Integer.valueOf(sc.nextLine());
        for(int t = 1;t<= ts;t++){
            String ds = sc.nextLine();
            String out = new Solution().addp(ds);
            System.out.println("Case #"+t+": "+out);
        }
    }
    String addp(String ds){//ds: digits
        //boudnary
        //prolbem type: min length, parenthesis BFS,stack?
        /*
        101
        3 1 2 (((3))1(2))
        when push, out the pushed char
        3: while(stack.size()<3) push("("); out("3");
        1: while(stack.size()>1) {out(")");pop()}; while(stack.size()<1) push("("); out("1");
        2: while(stack.size()<2) push("(");out("2");
        while(!stack.isEmpty()){out(")");pop();}
        111000
         */
        StringBuilder ret = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0;i<ds.length();i++){
            int ii = ds.charAt(i)-'0';
            while(stack.size()<ii){
                stack.add('('); ret.append('(');}
            while(stack.size()>ii){
                stack.removeLast(); ret.append(')');}
            ret.append(ds.charAt(i));}
        while(!stack.isEmpty()){
            stack.removeLast();ret.append(')');
        }

        return ret.toString();
    }

}
/*
8
0000
101
111000
1
021
312
4
221

 */