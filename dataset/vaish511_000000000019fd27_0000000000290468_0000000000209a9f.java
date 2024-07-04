import java.util.*;
 class Solution {
    public static void main(String[] args) {
        int T;
        Scanner scan = new Scanner(System.in);
        T= scan.nextInt();
        for(int i=1;i<=T;i++){
            String S;
            StringBuilder S1 = new StringBuilder();
            S = scan.next();
            int len, count=0, countClose=0;
            len = S.length();
            int j,k,l;
            for(j=0;j<len;j++){
                int num;
                num = Integer.parseInt(S.charAt(j)+"");
                if(num>count){
                    num = num-count;
                    count++;
                    for(k=0;k<num;k++)
                    S1.append("(");
                }
                else if(num<count){
                    l=count-num;
                    count-=l;
                    countClose+=l;
                    for(k=0;k<l;k++)
                        S1.append(")");
                    
                }
            S1=S1.append(S.charAt(j));
        }
           for(k=0;k<count;k++)
            S1.append(")");
            System.out.println("Case #"+i+": "+S1);
        }
    }
}