import java.util.*;

class Solution{
    public static void main(String[] srgs){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i=1;i<=t;i++){
            String s = input.next();
            StringBuilder res = new StringBuilder();
            int count = 0;
            for(int j=0;j<s.length();j++){
                int val = s.charAt(j)-'0';
                if(count<val){
                    count += val;
                    res.append('(');
                }
                else if(count>val){
                    while(count>val){
                        res.append(')');
                        count--;
                    }
                }
                res.append(val);
            }
            while(count>0){
                res.append(')');
                count--;
            }
            System.out.println("Case #"+i+": "+res);
        }
    }
    
}