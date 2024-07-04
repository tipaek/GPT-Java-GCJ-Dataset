import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++)
        {
            int n = in.nextInt();
            String a[] = new String[n];
            int max=0;
            int ind = 0;
            for(int j=0; j<n; j++)
            {
                String s = in.next();
                if(s.length()>max)
                {
                    max = s.length();
                    ind = j;
                }
                a[j] = s;
            }
            
            System.out.println("Case #"+(i+1)+": "+RetuSt(a, max, ind));
        }
    }
    static String RetuSt(String a[], int max, int ind)
    {
        for(int l=0; l<a.length; l++)
        {
            if(ind==l)
                continue;
            String s[] = a[l].split("\\*");
            if(!a[ind].contains(s[1]))
            {
                return "*";
            }
            else
            {
                
                int i = (a[ind].length()-1) - (a[ind].indexOf(s[1])-1);
                if(i != a[l].length()-1)
                {
                    return "*";
                }
            }
        }
        return a[ind].substring(1,a[ind].length());
    }
}