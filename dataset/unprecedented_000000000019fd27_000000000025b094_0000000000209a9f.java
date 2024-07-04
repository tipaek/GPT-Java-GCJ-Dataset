import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int x = 0;
        while (x++ < T){
            String s = scanner.next();
            int n = s.length();
            String result = "";
            int last = 0;
            List<Character> list = new ArrayList<>();
            Stack<Character> close = new Stack<>();
            for (int i=0; i<n; i++){
                int currChar = s.charAt(i) - 48;
                int diff = currChar - last;
                if (currChar > last){
                    for (int j=0; j<Math.abs(diff); j++){
                        list.add('(');
                        close.push(')');
                    }
                }
                else if ( currChar < last){
                    for (int j=0; j<Math.abs(diff); j++){
                        list.add(close.pop());
                    }
                }
                //System.out.println("List: " + list.toString());
                //System.out.println("Close: " + close.toString());
                list.add((char) (currChar+ '0'));
                last = currChar;
            }
            for (int i=0; i < close.size(); i++){
                list.add(')');
            }
            for (Character c : list)
                result += c;
            System.out.println("Case #"+ x +": "+ result);
        }
    }
}
/*
4
0000
101
111000
1

4
021
312
4
221
 */