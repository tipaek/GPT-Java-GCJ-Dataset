import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();sc.nextLine();
        for(int t=1;t<=T;t++)
        {
            
            String s=sc.nextLine();
            String sol="";
            int[] a=new int[s.length()];
            
            for(int i=0;i<s.length();i++){ a[i]=Character.getNumericValue(s.charAt(i)); }
            
            for(int i=0;i<a[0];i++)
            {
                sol+="(";
            }
            sol+=s.charAt(0);
            int count=a[0];
            for(int i=1;i<s.length();i++)
            {
                if(a[i-1]==a[i]) sol+=s.charAt(i);
                
                else if(a[i-1]>a[i])
                {
                    for(int j=0;j<(a[i-1]-a[i]);j++)
                        {
                            sol+=")";
                        }
                    sol+=s.charAt(i);
                    count-=a[i-1]-a[i];
                }
                else
                {
                    for(int j=0;j<(a[i]-a[i-1]);j++)
                        {
                            sol+="(";
                        }
                    sol+=s.charAt(i);
                    count+=a[i]-a[i-1];
                }
            }
            
            for(int j=0;j<count;j++)
                        {
                            sol+=")";
                        }
            System.out.println("Case #"+t+": "+sol);
        }
    }
}