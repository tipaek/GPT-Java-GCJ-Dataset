import java.util.*;
public class Solution {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int testcase = 1 ;
        while(t--!=0){
            String s  = in.next();
            if(s.isEmpty()){
                System.out.println("Case #"+testcase+": "+s);
                testcase++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int count = 1;
            for(int k=1;k<n;++k ){
                if(s.charAt(k)==s.charAt(k-1)){
                    count++;
                }else{
                    if(s.charAt(k-1)=='0'){
                        for(int i=0;i<count;++i)sb.append("0");
                    }else{
                        int depth = s.charAt(k-1)-'0';
                        for(int i=0;i<depth;++i)sb.append("(");
                        for(int i=0;i<count;++i)sb.append(depth);
                        for(int i=0;i<depth;++i)sb.append(")");
                    }
                    count = 1;
                }
            }
            if(count!=0){
                if(s.charAt(n-1)=='0'){
                    for(int i=0;i<count;++i)sb.append("0");
                }else{
                    int depth = s.charAt(n-1)-'0';
                    for(int i=0;i<depth;++i)sb.append("(");
                    for(int i=0;i<count;++i)sb.append(depth);
                    for(int i=0;i<depth;++i)sb.append(")");
                }
            }
            System.out.println("Case #"+testcase+": "+  sb.toString());
            testcase++;
        }
    }
}
