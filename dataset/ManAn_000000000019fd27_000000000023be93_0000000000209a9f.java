import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        int t = Integer.parseInt(in.next());
        int count = 0;
        while (t-->0) {
            count++;
            s = in.next();

            char[] sarr = s.toCharArray();

            ArrayList<Character> list = new ArrayList<Character>();
            char c;
            char p = sarr[0];
            if(p=='0'){
                list.add(p);
            }
            else if(p=='1'){
                list.add('(');
                list.add(p);
            }
            for (int i = 1; i < sarr.length; i++) {
                c = sarr[i];
                if(p=='0'){
                    if(c=='0'){
                        list.add(c);
                    }
                    else if(c=='1'){
                        list.add('(');
                        list.add(c);
                    }
                }
                else if(p=='1'){
                    if(c=='0'){
                        list.add(')');
                        list.add(c);
                    }
                    else if(c=='1'){
                        list.add(c);
                    }
                }
                p = c;
            }
            if(p=='1'){
                list.add(')');
            }
            System.out.print("Case #"+count+": ");
            for (Character string : list) {
                System.out.print(string);
            }
            System.out.println();
        }
        in.close();
    }
}