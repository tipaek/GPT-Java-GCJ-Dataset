import java.util.*;
class Solution
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            int time=0;
            boolean flag=false;
            String st=sc.next();
            for(int i=0;i<st.length();i++)
            {
                if(st.charAt(i)=='W')
                    x-=1;
                else if(st.charAt(i)=='E')
                    x+=1;
                else if(st.charAt(i)=='N')
                    y+=1;
                else if(st.charAt(i)=='S')
                    y-=1;
                time+=1;
                if(Math.abs(x)+Math.abs(y)<=time)
                    {
                        flag=true;
                        System.out.println("Case #"+k+": "+Math.max(Math.abs(x)+Math.abs(y),time));
                        break;
                    }
        }

        if(!flag)
            System.out.println("Case #"+k+": "+"IMPOSSIBLE");
    }
}
}