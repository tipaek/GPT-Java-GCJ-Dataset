import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner cin=new Scanner(System.in);
        int test=cin.nextInt();
        String s;
        int digit;
        for(int t=1;t<=test;t++)
        {
            Stack<Character> stk=new Stack<>();
            ArrayList<Character> arr=new ArrayList<>();
            s=cin.next();
            for(char ch:s.toCharArray())
            {
                digit=((int)ch)-48;
                if(stk.size()==digit)
                {
                    arr.add(ch);
                }
                else if(stk.size()>digit)
                {
                    while(stk.size()!=digit)
                    {
                        arr.add(stk.peek());
                        stk.pop();
                    }
                    arr.add(ch);
                }
                else
                {
                    while(stk.size()!=digit)
                    {
                        arr.add('(');
                        stk.push(')');
                    }
                    arr.add(ch);
                }
            }
            while(!stk.empty())
            {
                arr.add(stk.peek());
                stk.pop();
            }
            System.out.print("Case #"+t+": ");
            for(int i=0;i<arr.size();i++)
            {
                System.out.print(arr.get(i));
            }
            System.out.println();
        }
    }
}