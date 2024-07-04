import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        String temp = "";

        input.nextLine();
        for (int i=1; i<=cases; i++)
        {
            boolean impossible = false;
            int a = input.nextInt();
            int[] start = new int[a];
            int[] end = new int[a];
            String[] p = new String[a];
            for (int k=0; k<a; k++)
            {
                input.nextLine();
                start[k]=input.nextInt();
                end[k]=input.nextInt();
                p[k]= "X";
            }
            p[0]="C";

            if (i==6) {
                int xx=1;
            }
            first:
            for (int j=1; j<a; j++)
            {
                for (int k=1; k<=j; k++)
                {
                    if (overlapping(start[k-1],end[k-1],start[j],end[j]))
                    {
                        temp="";
                        if (p[k-1].equals("C"))  temp ="J";
                        if (p[k-1].equals("J"))  temp ="C"; 
                        if (p[k-1].equals("O"))  temp ="O";
                        if (p[j].equals("X") || p[j].equals("O")  ) p[j] = temp;

                        if (!p[j].equals("O") && !temp.equals("O")) {
                            if ( !p[j].equals(temp) )  {
                                impossible = true;
                                break first; 
                            }
                        }
                    }
                    else {
                        if (p[j].equals("X")) p[j] = "O";
                    }
                }
            }
            
            if (!impossible) {
                second:
                for (int jj=0; jj<a; jj++)
                {
                    if (p[jj].equals("O")) {
    
                        for (int kk=0; kk<a; kk++)
                        {
                            if (jj!=kk) 
                            {
                                if (overlapping(start[kk],end[kk],start[jj],end[jj]))
                                {
                                    temp="";
                                    if (p[kk].equals("C"))  temp ="J";
                                    if (p[kk].equals("J"))  temp ="C"; 
                                    if (p[kk].equals("O"))  temp ="O"; 
                                    if (p[jj].equals("X") || p[jj].equals("O")  ) p[jj] = temp;
            
                                    if (!p[jj].equals("O") && !temp.equals("O")) {
                                        if ( !p[jj].equals(temp) )  {
                                            impossible = true;
                                            break second; 
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            String output = "";
            if (!impossible ) {
                for (String k: p)
                    output +=k.replace('O', 'C');
            } else {
                output = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + output);
        }
        input.close();
    }

    public static boolean overlapping(int s1, int e1, int s2, int e2)
    {
        return (s2<e1 && e2>s1);
    }

}