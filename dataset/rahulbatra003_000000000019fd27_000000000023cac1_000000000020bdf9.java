import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
           	          	           static List<String> l = new ArrayList<>();
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int k=0; k<T; k++) {
            int N = in.nextInt();
            l.clear();
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
            char ch = 'C';
            StringBuilder sb = new StringBuilder();
            int p=0,flag=1;
            int count = 1;
            int busy = 1;
            for(String str: l) {
            if(str.endsWith("s")) {
            if(p>=2) {
             System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
             flag=0;
             break;
            }
                       p++;
             	if(busy ==1 || count == 2){
	             	if(ch=='C') {
		          		ch='J';
		          	} else {
		          		ch='C';
		          	}
		          	count = 0;
             	} else {
             		busy = 1;
             	}
             	sb.append(ch);
             	if (ch == sb.toString().charAt(sb.length()-1)) {
             		count++;
             	}
            } else {
            	busy=0;
             p--;
            }
            }
                                    System.out.println("Case #"+(k+1)+": "+Arrays.toString(l.toArray()));

             if(flag==1)
                        System.out.println("Case #"+(k+1)+": "+sb.toString());
        }
    }
}