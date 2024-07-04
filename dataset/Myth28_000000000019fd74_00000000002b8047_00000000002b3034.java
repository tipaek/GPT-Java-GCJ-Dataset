import java.util.*;
class Solution
{
    public static void main(String[]args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k=1;
        while(t-->0)
        {
            int n = in.nextInt();
            String h = in.nextLine();
            
            String s="";
            int MAX=0;
            String arr[] = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = in.nextLine();
                int l = arr[i].length();
                if(l>=MAX)
                {MAX=l; s = arr[i];}
                
            }
            //System.out.println(s);
            boolean flag=true;
            for(int i=0;i<n;i++)
            {
                String s1 = arr[i].substring(1);
                int l = s1.length();
                
                int l1 = s.length()-1;
                String s2 = s.substring(l1-l+1,l1+1);
                if(s1.equals(s2))
                continue;
                else
                flag=false;
            }
            if(flag==true)
            System.out.println("Case #"+k+": "+s.substring(1));
            else
            System.out.println("Case #"+k+": *");
            
            k++;
        }
        
    }
}