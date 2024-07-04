import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=1;i<=t;i++)
        {
            int u=sc.nextInt();
            HashMap<Integer, ArrayList<String>> a=new HashMap<>(1000000);
            for(int j=1;j<=10000;j++)
            {
                long a=sc.nextInt();
                if(a>100)
                continue;
                int b=(int)a;
                String s=sc.next();
                ArrayList<String> temp;
                if(a.containsKey(b))
                {
                    temp=a.get(b);
                    temp.add(s);
                }
                else
                {
                    temp=new ArrayList<>(1000);
                    temp.add(s);
                }
                a.put(b,temp);
            }
            char ans[]=new char[10];
            HashMap<Character,Boolean> used=new HashMap(15);
            for(int j=1;j<=9;j++)
            {
                ArrayList<String> temp=a.get(j);
                for (String s:temp)
                {
                    char c=s.charAt(0);
                    if(!used.containsKey(c))
                    {
                        ans[j]=c;
                        used.put(c,true);
                        break;
                    }
                }
            }
            for (String s:a.get(10))
            {
                if(s.length()==2)
                {
                    ans[0]=s.charAt(1);
                    break;
                }
            }
            System.out.print("Case #"+i+": ");
            for (char j:ans)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
