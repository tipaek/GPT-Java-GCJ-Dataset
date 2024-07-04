import java.util.*;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        int t = sc.nextInt();
        for (int i=1;i<=t;i++)
        {
            s.append("Case #"+i+": ");
            String str = sc.next();
            char [] ar = str.toCharArray();
            int left =0;
            for (char c:ar) {
                int right= c-'0';
                if(right>left)
                {
                    for(int j=0;j<right-left;j++)
                    {
                        s.append("(");
                    }
                    s.append(right);
                }
                else if(left>right) {
                    for (int j = 0; j < left-right; j++) {
                        s.append(")");
                    }
                    s.append(right);
                }
                else
                {
                    s.append(right);
                }
                left=right;
            }
            while(left-->0)
            {
                s.append(")");
            }
            s.append("\n");
        }
        System.out.println(s);
    }
}
