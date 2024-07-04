import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Character,Integer> v=new HashMap<>(4);
        v.put('S',-1);
        v.put('N',1);
        v.put('E',1);
        v.put('W',-1);
        int t=sc.nextInt();
        for (int i=1;i<=t;i++)
        {
            int f=-1;
            int x=sc.nextInt();
            int y=sc.nextInt();
            String p=sc.next();
            for (int j=0;j<p.length();j++)
            {
                char c=p.charAt(j);
                if(c=='N'||c=='S')
                    y+=v.get(c);
                else x+=v.get(c);
                int d=Math.abs(x)+Math.abs(y);
                if(d<=(j+1)) {
                    f = j + 1;
                    break;
                }
            }
            System.out.print("Case #"+i+": ");
            if(f==-1)
                System.out.println("IMPOSSIBLE");
            else System.out.println(f);
        }
    }
}
