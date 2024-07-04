import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
           	           static List<String> l = new ArrayList<>();
           static Queue<Character> q = new LinkedList<>();

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int k=0; k<T; k++) {
            int N = in.nextInt();
            l.clear();
            q.clear();
            for(int i=0; i<N; i++) {
                l.add(in.nextInt()+"s");
                l.add(in.nextInt()+"d");
            }
            Collections.sort(l, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
              Integer a1 = Integer.valueOf(s1.substring(0, s1.length() - 1));
              Integer a2 = Integer.valueOf(s2.substring(0, s2.length() - 1));
                if(a1-a2 == 0) {
                 if(s1.endsWith("d") && s2.endsWith("s"))
                 return -1;
                 if(s2.endsWith("d") && s1.endsWith("s"))
                 return 1;
                 return 0;
                }
                return a1-a2;
            }
            });
            q.add('C');
            q.add('J');
            StringBuilder sb = new StringBuilder();
            int p=0,flag=1;
            for(String str: l) {
            if(str.endsWith("s")) {
            if(p>=2) {
             System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
             flag=0;
             break;
            }
             p++;
             sb.append(q.poll());
            } else {
             p--;
             char ch;
             if(q.size()==0) {
            	q.add('C');
            	q.add('J');
             } else {
             	q.add('C');
             }
            }
            }
             if(flag==1)
                        System.out.println("Case #"+(k+1)+": "+sb.toString());
        }
    }
}