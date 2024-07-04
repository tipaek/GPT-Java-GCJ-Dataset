import java.util.*;
public class Solution
{
    public static void main(String[] args) {
        int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            Stack<Character> st=new Stack<>();
            String res="";
            char a[]=sc.next().toCharArray();
            st.push(a[0]); 
            for(int i=1;i<a.length;i++)
            {
                if(a[i]==(Character)st.peek())
                {
                    st.push(a[i]);
                }
                else
                {
                    int x=(int)((Character)st.peek())-48;
                    for(int b=0;b<x;b++)
                    {
                        res+="(";
                    }
                    while(!st.isEmpty())
                    res+=String.valueOf(st.pop());
                    for(int b=0;b<x;b++)
                    {
                        res+=")";
                    }
                    st.push(a[i]);
                }
            }
            int x=(int)((Character)st.peek())-48;
            for(int b=0;b<x;b++)
            {
                res+="(";
            }
            while(!st.isEmpty())
            res+=String.valueOf(st.pop());
            for(int b=0;b<x;b++)
            {
                res+=")";
            }
            System.out.println("Case #"+(k+1)+": "+res);
        }
    }
}