import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String s=sc.next();
            String res="";

            for(int j=0;j<s.length();j++)
            {
                if(j==0)
                {
                    int c=Character.getNumericValue(s.charAt(j));
                    for(int k=0;k<c;k++)
                    {
                        res='('+res;
                    }
                    res=res+s.charAt(j);
                    if(s.length()==1)
                    {
                        for(int k=0;k<c;k++)
                        {
                            res=res+')';
                        }
                    }
                }
                else
                {
                    int diff=Character.getNumericValue(s.charAt(j-1))-Character.getNumericValue(s.charAt(j));
                    if(diff<0)
                    {
                        for(int k=0;k<Math.abs(diff);k++)
                        {
                            res=res+'(';
                        }
                    }
                    else if(diff>0)
                    {
                        for(int k=0;k<Math.abs(diff);k++)
                        {
                            res=res+')';
                        }
                    }
                    res=res+s.charAt(j);

                    if(j==s.length()-1) {
                    int c=Character.getNumericValue(s.charAt(j));
                    for(int k=0;k<c;k++)
                    {
                        res=res+')';
                    }
                   }
                }
            }
            System.out.println("Case #"+(i+1)+": "+res);
        }

    }
}
