import java.util.*;

public class Main {
    public boolean cfree(int b,int e,int nb,int ne)
    {
        if(nb<b && ne<=b)
            return true;
        else if(ne>e && nb>=e)
            return true;
        else
            return false;
        
    }
    public boolean jfree(int b,int e,int nb,int ne)
    {
        if(nb<b && ne<=b)
            return true;
        else if(ne>e && nb>=e)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cb,ce,jb,je;
        int n=in.nextInt();
        String s;
        int b=0;
        first:
        while(b!=n)
        {   
            int a=in.nextInt();
            Main obj=new Main();
            int arr[][]=new int[a][2];
            for(int i=0 ; i<a ; i++)
            {
                arr[i][0]=in.nextInt();
                arr[i][1]=in.nextInt();
            }
            if(a>2)
            {
                s="CJ";
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
            }
            else{
                s="C";
            cb=arr[0][0];
            ce=arr[0][1];
            if(obj.cfree(cb,ce,arr[1][0],arr[1][1]))
                {
                    cb=arr[1][0];
                    ce=arr[1][1];
                    s+="C";
                }
                else
                {
                    jb=arr[1][0];
                    je=arr[1][1];
                    s+="J";
                }
            }
            System.out.println("Case #"+(++b)+": "+s);
            
        }
    }
}