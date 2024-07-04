import java.util.*;
public class Solution
{
    public static String getAnswer(int n,int s[],int e[],int id[],int case_no)
    {
        String ans = "";int temp=0,max_end=0; 
        String str[] = new String[n];
        ArrayList<String> avai = new ArrayList<String>();
        avai.add("C");
        avai.add("J");
        //Sort acc to s
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(s[j] > s[j+1])
                {
                    temp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = temp;

                    temp = e[j];
                    e[j] = e[j+1];
                    e[j+1] = temp;

                    temp = id[j];
                    id[j] = id[j+1];
                    id[j+1] = temp;
                }
            }
        }
        for(int i=1;i<n;i++)
        {
            max_end = Math.max(e[i],e[i-1]);
        } 
        boolean flag1 = true;
        for(int i=0;i<max_end;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s[j] == i)
                {
                    if (avai.size() <= 0)
                    {
                        flag1 = false;
                        break;
                    }
                    else
                    {
                        str[id[j]] = avai.get(0);
                        avai.remove(0);
                    }
                }
                if (i == e[j])
                {
                    avai.add(str[id[j]]);
                }
            }
            if(!flag1)
            {
                break;
            }
        }
        if(flag1)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i == id[j])
                    {
                        ans += str[j];
                        break;
                    }
                }
            }
        }
        else
        {
            ans = "IMPOSSIBLE";
        }
        return ("Case #"+case_no+": "+ans);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = t;String ans ="";
        while(t!=0)
        {
            int n = sc.nextInt();
            int s[] = new int[n];
            int e[] = new int[n];
            int id[] = new int[n];
            for(int i=0;i<n;i++)
            {
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
                id[i] = i;
            }
            ans += getAnswer(n,s,e,id,(x-t+1))+"\n";
            t--;
        } 
        System.out.print(ans);
    }
}