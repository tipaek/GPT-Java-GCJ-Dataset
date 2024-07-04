import java.util.*;

public class Solution{
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
         String[] s =new String[50];
        for(int i=0;i<test;i++)
        {
            int n = scan.nextInt();
           
            int flag=0;
            String min="sdfghjklkjhgfdsdfghjklkjhgfdfghjkkjhgfdfghkkjhgfdfghjkjhgf";
            String max="";
            HashMap<Integer,String> hm=new HashMap<Integer,String>();
            for(int j=0;j<n;j++)
            {
                s[j]=scan.next();
                if(s[j].substring(1).length()<min.length())
                {
                    min=s[j].substring(1);;
                }
                //System.out.println(min);
                if(s[j].substring(1).length()>max.length())
                {
                	max=s[j].substring(1);
                }
                for(int k=0;k<j-1;k++)
                {
                    if(s[k].substring(1).contains(min))
                    {
                        flag=1;
                    }
                    else
                    {
                        flag=0;
                        break;
                    }
                }
                //System.out.println("flag:"+flag);
            }
            if(flag==0)
            {
            System.out.println("Case #"+(i+1)+": "+"*");
            }
            else
            {
            	 System.out.println("Case #"+(i+1)+": "+max);
            }
        }
        
        
    }
}