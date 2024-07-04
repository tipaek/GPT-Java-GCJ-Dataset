import java.util.Scanner;

/**
 *
 * @author Yadav's
 */
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int t1 = 1; t1<=t;t1++){
            String s = in.next();
            int l = s.length();
            String ans = "";
            int y = 0;
            for(int i = 0; i<l;i++){
                int a = s.charAt(i) - '0';
                if(i==0){
                    for(int i1 = 0; i1<a;i1++){
                        ans+= "(";
                    }
                    ans+=a;
                    y=a;
                }
                else{
                    if(y>a){
                        for(int i1 = 0; i1<y-a;i1++){
                        ans+= ")";
                    }
                    ans+=a;
                    y=a;
                    }
                    else{
                        for(int i1 = 0; i1<a-y;i1++){
                        ans+= "(";
                    }
                    ans+=a;
                    y=a;
                    }
                }
                if (i==l-1){
                    for(int i1 = 0; i1<a;i1++){
                        ans+= ")";
                    }
                    y=a;
                }
            }
            System.out.println("Case #"+t1+": "+ans);
        }
    }
}
