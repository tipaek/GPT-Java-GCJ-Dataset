

import java.util.*;

public class Solution{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int b=1; b<=t; b++){
            String a=s.next();
            int depth=0;
            List<Character> l= new ArrayList<Character>();
            for(int i=0; i<a.length(); i++){
                int sc=Character.getNumericValue(a.charAt(i));
                if(sc==depth){
                    l.add(Character.valueOf(a.charAt(i)));
                }
                else if(sc>depth){
                    while(sc!=depth){
                        l.add('(');
                        depth++;
                    }
                    l.add(Character.valueOf(a.charAt(i)));
                }
                else{
                    while(sc!=depth){
                        l.add(')');
                        depth--;
                    }
                    l.add(Character.valueOf(a.charAt(i)));
                }
            }
            while(depth!=0){
                l.add(')');
                depth--;
            }
            String out=l.toString().substring(1, 3 *l.size() - 1).replaceAll(", ", "");
            System.out.println("Case #"+b+": "+out);
        }
    }
}
