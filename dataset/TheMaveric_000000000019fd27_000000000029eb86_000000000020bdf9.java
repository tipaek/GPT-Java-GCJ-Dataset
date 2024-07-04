import java.util.*;

public class Solution {
    public boolean cfree(int b,int e,int nb,int ne)
    {
        if(nb>b && nb<e)
            return false;
        else if(ne>b && ne<e)
            return false;
        else
            return true;
        
    }
    public boolean jfree(int b,int e,int nb,int ne)
    {
        if(nb>b && nb<e)
            return false;
        else if(ne>b && ne<e)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cb,ce,jb,je;
        int n=in.nextInt();
        int b=0;
        first:
        while(b!=n)
        {   String s="CJ";
            int a=in.nextInt();
            Solution obj=new Solution();
            int arr[][]=new int[a][2];
            for(int i=0 ; i<a ; i++)
            {
                arr[i][0]=in.nextInt();
                arr[i][1]=in.nextInt();
            }
            cb=arr[0][0];
            ce=arr[0][1];
            jb=arr[1][0];
            je=arr[1][1];
            for(int i=2 ; i<a ; i++)
            {   
                if(obj.cfree(cb,ce,arr[i][0],arr[i][1]))
                {
                    cb=arr[i][0];
                    ce=arr[i][1];
                    s+="C";
                }
                else if(obj.jfree(jb,je,arr[i][0],arr[i][1]))
                {
                    jb=arr[i][0];
                    je=arr[i][1];
                    s+="J";
                }
                else
                {   
                    System.out.println("Case #"+(++b)+": IMPOSSIBLE");
                    continue first;
                }
            }
            System.out.println("Case #"+(++b)+": "+s);
            
        }
    }
}