import java.util.*;
public class Solution{

     public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            String s=sc.next();
			int j=1;
            String res="";
            Stack<Character> stack=new Stack<>();
            for(int i=0;i<s.length();i++)
            {
               // System.out.println(i);
               //System.out.println(stack.size()+" "+Integer.parseInt(""+s.charAt(i))+" "+(Integer.parseInt(""+s.charAt(i))<stack.size()));
                if(i-1>=0&&stack.size()!=0&&Integer.parseInt(""+s.charAt(i))>stack.size())
                {
                    int len=Integer.parseInt(""+s.charAt(i))-stack.size();
                    for(j=1;j<=len;++j)
                    {
                        //System.out.println("j "+j);
                        stack.push('(');
                        res=res+'(';
                    }
					//System.out.println("j out "+j);
                    res=res+s.charAt(i);
                }
                else if(i-1>=0&&stack.size()!=0&&Integer.parseInt(""+s.charAt(i))<stack.size())
                {
                    //System.out.println("closing"+" "+(Integer.parseInt(""+s.charAt(i))<stack.size()));
                    while(stack.size()!=Integer.parseInt(""+s.charAt(i)))
                    {
                        //System.out.println("closing");
                        stack.pop();
                        res=res+')';
                    }
                    res=res+s.charAt(i);
                }
                else if(Integer.parseInt(""+s.charAt(i))==stack.size()){
                    res=res+s.charAt(i);
                }
                else if(stack.isEmpty())
                {
                    for(j=1;j<=Integer.parseInt(""+s.charAt(i));j++)
                    {
                        stack.push('(');
                        res=res+'(';
                    }
                    res=res+s.charAt(i);
                }
            }
            while(stack.size()!=0)
            {
                stack.pop();
                res=res+")";
            }
            System.out.println("Case #"+k+": "+res);
        }
     }
}