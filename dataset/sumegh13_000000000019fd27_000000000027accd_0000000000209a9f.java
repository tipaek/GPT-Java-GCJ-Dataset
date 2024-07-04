import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        String str;
        ArrayList<String> ar = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            str = sc.next();
            ar.add(getNestedDepth(str,i));
        }
        for (String s : ar) {
            System.out.println(s);
        }
    }
    public static String getNestedDepth(String str,int n) {
        Stack<Character> s = new Stack<Character>();
        int peek=-1,curr=-1;
        for (int i = 0; i < str.length(); i++) {
            curr=Integer.parseInt(str.charAt(i)+"");
            if(s.isEmpty()){
                peek=Integer.parseInt(str.charAt(i)+"");
                for (int j = 0; j < peek; j++) {
                    s.push('(');
                }
                s.push(str.charAt(i));
            }else{
                peek=Integer.parseInt(s.peek()+"");
                if(peek>curr){
                    for (int j = 0; j < peek-curr; j++) {
                        s.push(')');
                    }
                }else{
                    for (int j = 0; j < curr-peek; j++) {
                        s.push('(');
                    }
                }
                s.push(str.charAt(i));
            }
        }
        for (int i = 0; i < curr; i++) {
            s.push(')');
        }
        StringBuffer sb = new StringBuffer("Case #"+(n+1)+": ");
        for (char cha : s) {
            sb.append(cha);
        }
        return sb.toString();
    }
}