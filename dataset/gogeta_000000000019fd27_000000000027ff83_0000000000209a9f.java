import java.util.*;
class Solution {
    public static void main(String[]args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=1; t<=T; t++) {
            String num = s.next();
            int[]a=new int[num.length()];
            for(int i=0;i<a.length;i++) {
                a[i]=Integer.parseInt(num.substring(i,i+1));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a[0]);
            while(a[0]>0) {
                a[0]--;
                sb.append(")");
                sb.insert(0,"(");
            }
            for(int i=1;i<a.length;i++) {
                int pos = sb.length()-1;
                int count=0;
                while(sb.charAt(pos)==')'&&count<a[i]) {
                    count++;
                    pos--;
                }
                sb.insert(pos+1, a[i]);
                if(count!=a[i]) {
                    count=a[i]-count;
                    while(count>0) {
                        count--;
                        sb.insert(pos+1,"(");
                        sb.insert(pos+3,")");
                        pos++;
                    }
                }
            }    
            
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
           