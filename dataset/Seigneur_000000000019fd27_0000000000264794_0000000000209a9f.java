import java.util.*;
public class Solution{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int z=0;z<t;z++)
    {
        String s= sc.next();
        Character a[]=new Character[s.length()];
        for(int i=0;i<s.length();i++)
        {
        a[i]=s.charAt(i);
        }
        int y=z+1;
        System.out.print("Case #"+y+": ");
        int f,n=a.length;
        ArrayList<Character> al=new ArrayList<>();
       for(int i=0;i<a[0]-48;i++)
            al.add('(');
        al.add(a[0]);
        for(int i=1;i<n;i++)
        {
            //System.out.println(a[i]);
            if(a[i]>a[i-1])
            {
                f=a[i]-a[i-1];
                    for(int j=0;j<f;j++) 
                        al.add('(');
                    al.add(a[i]);
            }
            else if(a[i]<a[i-1])
            {
                f=a[i-1]-a[i];
                    for(int j=0;j<f;j++) 
                        al.add(')');
                    al.add(a[i]);
            }
            else
                al.add(a[i]);
        }
        for(int i=0;i<a[n-1]-48;i++)
            al.add(')');
 
        char e;
        for(int i=0;i<al.size();i++)
        {
            e=al.get(i);
            System.out.print(e);
        }
        System.out.println();
    }
    }
}
