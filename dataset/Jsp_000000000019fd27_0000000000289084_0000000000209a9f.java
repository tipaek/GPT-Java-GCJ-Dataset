import java.util.*;
import java.io.*;
class Solution
{
public static void main(String as[])
{
     Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int mat[][];
    String[] result;
    int cases=0;   
    int max=0;
    String s=new String(),tmp=new String(),op;
    cases=scan.nextInt();
    result=new String[cases];
    
    s=scan.nextLine();
    for(int p=0;p<cases;p++)
    {
          op=new String();
       s=scan.nextLine();
    //    System.out.println(s);
char[] xd=new char[s.length()];
xd=s.toCharArray();
int openC=0;
        for(int x=0;x<xd.length;x++)
        {
          
            // System.out.println("In For MAin");
            int z=xd[x]-'0';
        int po=0;
                if(openC>z)
                {
                    // System.out.println("In greater For");
                    for(po=0;po<openC-z;po++)
                    {
                        // System.out.println("In grat clos For");
                        op+=')';
                        
                    }
                    openC-=po;
                    op+=xd[x];
                }
                else if(openC<z)
                {
                    // System.out.println("In less  For"+z);
                     for( po=0;po<z-openC;po++)
                    {
                        //  System.out.println("In less op For"+z);
                        op+='(';
                      
                    }
                    // System.out.println("OP"+po+" open"+openC);
                    openC+=po;
                    op+=xd[x];
                }
                else if(openC==z)
                {
                    // System.out.println("In eql For");
                     op+=xd[x];
                         
                }           
        }

                    for(int po=0;po<openC;po++)
                    {
                        // System.out.println("In out if clos For");

                        op+=')';
                        // openC--;
                    }
                    result[p]=op;
                    // System.out.println("Output"+op);
    }
   int cn=1;
    for(String asd:result)
    {
        System.out.println("Case #"+cn+": "+asd);
        cn++;
    }
    
}
}