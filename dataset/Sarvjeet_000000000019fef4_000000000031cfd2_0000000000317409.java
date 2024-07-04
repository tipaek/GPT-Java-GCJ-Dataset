import java.util.*;

public class Solution {

    public static int find(int xs,int ys,String s)
    {
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)=='N')    ys+=1;
            else if(s.charAt(i)=='S')    ys-=1;
            else if(s.charAt(i)=='E')    xs+=1;
            else if(s.charAt(i)=='W')    xs-=1;

            if((Math.abs(xs)+Math.abs(ys))<=(i+1)) return i+1;
            i++;

        }
        return -1;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {
            int xs=sc.nextInt();
            int ys=sc.nextInt();
            String s=sc.next();

           int t1=find(xs,ys,s);
           if(t1==-1){
               System.out.println("Case #"+(ii+1)+": IMPOSSIBLE");
           }
           else System.out.println("Case #"+(ii+1)+": "+t1);

        }


    }
}