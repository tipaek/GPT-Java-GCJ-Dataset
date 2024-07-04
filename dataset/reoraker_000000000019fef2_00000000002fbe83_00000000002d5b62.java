import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            int x=in.nextInt();
            int y=in.nextInt();

            if(x==1 && y==2)
                System.out.println("EN");
            else if(x==-1 && y==2)
                System.out.println("WN");
            else if(x==1 && y==-2)
                System.out.println("ES");
            else if(x==-1 && y==-2)
                System.out.println("WS");
            else if(x==2 && y==1)
                System.out.println("NE");
            else if(x==-2 && y==1)
                System.out.println("NW");
            else if(x==2 && y==-1)
                System.out.println("SE");
            else if(x==-2 && y==-1)
                System.out.println("SW");
            else if(x==1 && y==4)
                System.out.println("WEN");
            else if(x==-1 && y==4)
                System.out.println("EWN");
            else if(x==1 && y==-4)
                System.out.println("WES");
            else if(x==-1 && y==-4)
                System.out.println("EWS");
            else if(x==4 && y==1)
                System.out.println("SNE");
            else if(x==-4 && y==1)
                System.out.println("SNW");
            else if(x==4 && y==-1)
                System.out.println("NSE");
            else if(x==-4 && y==-1)
                System.out.println("NSW");
            else if(x==2 && y==3)
                System.out.println("SEN");
            else if(x==-2 && y==3)
                System.out.println("SWN");
            else if(x==2 && y==-3)
                System.out.println("NES");
            else if(x==-2 && y==-3)
                System.out.println("NWS");
            else if(x==3 && y==2)
                System.out.println("WNE");
            else if(x==-3 && y==2)
                System.out.println("ENW");
            else if(x==3 && y==-2)
                System.out.println("WSE");
            else if(x==-3 && y==-2)
                System.out.println("ESW");
            else if(x==3 && y==4)
                System.out.println("EEN");
            else if(x==-3 && y==4)
                System.out.println("WWN");
            else if(x==3 && y==-4)
                System.out.println("EES");
            else if(x==-3 && y==-4)
                System.out.println("WWS");
            else if(x==4 && y==3)
                System.out.println("NNE");
            else if(x==-4 && y==3)
                System.out.println("NNW");
            else if(x==4 && y==-3)
                System.out.println("SSE");
            else if(x==-4 && y==-3)
                System.out.println("SSW");
            else if(x==0 && y==1)
                System.out.println("N");
            else if(x==0 && y==-1)
                System.out.println("S");
            else if(x==1 && y==0)
                System.out.println("E");
            else if(x==-1 && y==0)
                System.out.println("W");
            else if(x==0 && y==3)
                System.out.println("NN");
            else if(x==0 && y==-3)
                System.out.println("SS");
            else if(x==-3 && y==0)
                System.out.println("WW");
            else if(x==3 && y==0)
                System.out.println("EE");
            else
                System.out.println("IMPOSSIBLE");
            
        } 
        
    }
}
