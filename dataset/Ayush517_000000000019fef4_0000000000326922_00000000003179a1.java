import java.math.*;
import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args)throws IOException {
        Scanner ob = new Scanner(System.in);
        //File file = new File("in.txt");
        //ob = new Scanner(file);
        int testcases = ob.nextInt();
        for (int test = 1; test<=testcases; test++) {
            int u=ob.nextInt();
            char[] ch = new char[10];
            Arrays.fill(ch, '?');
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=1;i<=10000;i++) {
                String num = ""+ob.nextLong();
                //System.out.println(num);
                String s = ob.next();
                //System.out.println("s "+s+ " _ num "+num);
                if(s.length()==1 ) {
                    map.putIfAbsent(s.charAt(0), 10);
                } else {

                    int ind = map.getOrDefault(s.charAt(0), 10);
                    ind = Math.min(ind, num.charAt(0)-'0');
                    map.put(s.charAt(0), ind);
                    for(int j=1;j<s.length();j++) {
                        ind = map.getOrDefault(s.charAt(j), 10);
                        map.put(s.charAt(j), ind);
                    }
                }
            }
            for(Character c : map.keySet()) {
                if(map.get(c)!=10)
                    ch[map.get(c)]=c;
            }
            for(Character c : map.keySet()) {
                if(map.get(c)==10)
                    for(int i=0;i<10;i++)
                        if(ch[i]=='?') {
                            ch[i]=c;
                            break;
                        }
            }
            System.out.println("Case #"+test+": "+new String(ch));
        }
    }
}