import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        int t = Integer.parseInt(in.next());
        int count = 0;
        while (t-->0) {
            count++;
            s = in.next();
            sub ob = new sub();
            ob.ans(s, count); 
        }
        in.close();
    }
}

class sub{

    int depth;
    ArrayList<Character> list;

    sub(){
        depth = 0;
        list = new ArrayList<Character>();
    }


    public void ans(String s, int count) {
        char[] sarr = s.toCharArray();

        for (int i = 0; i < sarr.length; i++) {
            int c = Integer.parseInt(""+sarr[i]);
            depthControl(c);
            list.add(sarr[i]);
        }
        depthControl(0);
        
       
        System.out.print("Case #"+count+": ");
        for (Character string : list) {
            System.out.print(string);
        }
        System.out.println();
    }

    void depthControl(int d){
        while(depth!=d){
            if(depth<d){
                list.add('(');
                depth++;
            }
            else{
                list.add(')');
                depth--;
            }
        }
    }
}