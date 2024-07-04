import java.io.*;
import java.util.*;
public class Solution
{
    static long power[];
    static boolean ans;
    static int num=100;
    static int k=1;
    static int o;
    static ArrayList<Character> A;
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j;
        int T=sc.nextInt();
        power=new long[32];
        power[0]=1;
        for(i=1;i<32;i++)
        power[i]=2*power[i-1];
        while(T-- >0)
        {
            long X=sc.nextLong();
            long Y=sc.nextLong();
            ans=false;
            A=new ArrayList<>();
            o=Integer.MAX_VALUE;
            ArrayList<Character> al=new ArrayList<>();
            DFS(0,0,X,Y,0,al);
            if(!ans)
            System.out.println("Case #"+k+": IMPOSSIBLE");
            else
            {
                System.out.print("Case #"+k+": ");
                for(i=0;i<A.size();i++)
                System.out.print(A.get(i));
                System.out.println();
            }
            k++;
        }
    }
    
    public static void DFS(long a,long b,long X,long Y,int id,ArrayList<Character> al)
    {
        if(a==X&&b==Y)
        {
            if(o>al.size())
            {
                ans=true;
                A.clear();
                for(int i=0;i<al.size();i++)
                A.add(al.get(i));
                o=al.size();
            }
            return;
        }
        if(a>num||b>num||a<(-1*num)||b<(-1*num)||id>=32)
        {
            return;
        }
                al.add('E');
                DFS(a+power[id],b,X,Y,id+1,al);
                al.remove(al.size()-1);
                
                al.add('W');
                DFS(a-power[id],b,X,Y,id+1,al);
                al.remove(al.size()-1);
                
                al.add('S');
                DFS(a,b-power[id],X,Y,id+1,al);
                al.remove(al.size()-1);
                
                al.add('N');
                DFS(a,b+power[id],X,Y,id+1,al);
                al.remove(al.size()-1);
        
    }
}