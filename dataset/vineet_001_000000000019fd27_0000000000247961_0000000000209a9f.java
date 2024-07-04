import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++)
        {
            String st=sc.next();
            int len=st.length();
            Stack<Character> s=new Stack<>();
            int arr[]=new int[len];
            for(int i=0;i<len;i++)
            {
                arr[i]=Integer.parseInt(String.valueOf(st.charAt(i)));
            }
            String str="";
            int i=1;
            int temp=arr[0];
            while(temp--!=0)
            {
            s.push('(');
            str+="(";
            }
            str+=st.charAt(0);
            while(i!=arr.length)
            {
              if(arr[i]-arr[i-1]>0)
              {
                  int x=arr[i]-arr[i-1];
                  while(x--!=0)
                  {
                  s.push('(');
                  str+="(";
                  }
              }
              else if(arr[i]-arr[i-1]<0)
              {
                  int y=arr[i-1]-arr[i];
                  while(y--!=0)
                  {
                      s.pop();
                      str+=")";
                  }
              }
              str+=st.charAt(i);
              i++;
                      
            }
            while(s.empty()!=true)
            {
                s.pop();
                str+=")";
            }
            System.out.println("Case #"+k+": "+str);
                
                
                
                
            }
    }
}
