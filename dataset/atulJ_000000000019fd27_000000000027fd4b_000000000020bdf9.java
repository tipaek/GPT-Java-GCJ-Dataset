
import java.io.*;
import java.util.*;

class news
{
    public static void main(String[] args) 
    {
        Scanner in= new Scanner(System.in)    ;

        int t=in.nextInt();
        int n=in.nextInt();
    for (int x=0;x<t ;x++ ) {
        
    
        int task[][]= new int[n][2];

        for(int i=0;i<n;i++)
        {
            String s= in.nextLine();
            String p[]= s.split(" ");

            task[i][0]=Integer.parseInt(p[0]);
            task[i][1]=Integer.parseInt(p[1]);

        }

        String d="C";
        int pc=0,pj=0;

        for (int i=1;i<n ;i++ ) 
        {
            if(task[i-1][0]<=task[i][0] )
            {
                if ( (pj!=0 &&(task[pj][0]<=task[i][0]||task[i][1]<=task[pj][1] ) )||( task[pc][0]<=task[i][0] || task[i][1]<=task[pc][1]))
                {
                    System.out.println("Case #"+x+1+": "+"IMPOSSIBLE")    ;
                    break;
                }
                d+="J";
                pj=i;

            }
            else
            {

                d+="C";
                pc=i;
            }
        }
        System.out.println("Case #"+x+1+": "+d);

    }
    }
}