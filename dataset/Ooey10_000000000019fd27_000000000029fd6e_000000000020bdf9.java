import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String [] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        
        int repeat = input.nextInt();
        input.nextLine();
        for(int x = 0; x < repeat; x++)
        {
            int events = input.nextInt();
            int[][] listf = new int[events][2];
            int[][] list = new int[events][2];
            for(int i = 0; i < events; i++)
            {
                input.nextLine();
                for(int y = 0; y < 2; y++)
                {
                    listf[i][y] = list[i][y] = input.nextInt();
                }
            }
            int temp;
            int[] temp2;
            int min;
            for(int i = 0; i < events; i++)
            {
                min = list[i][0];
                temp = i;
                for(int k = i + 1; k < events; k++)
                {
                    if(list[k][0] < min)
                    {
                        min = list[k][0];
                        temp = k;
                    }
                }
                if(min != list[i][0])
                {
                    temp2 = list[i];
                    list[i] = list[temp];
                    list[temp] = temp2;
                }
            }
            String str = "C";
            int latest;
            int latestnotpos;
            boolean pos; 
            int a;
            Outer:
            for(int i = 1; i < events; i++)
            {
                latest = -1;
                latestnotpos = -1;
                pos = false;
                a = 0;
                Inner:
                for(int k = 0; k < i; k++)
                {
                    if(list[i][0] >= list[k][1])
                    {
                        pos = true;
                        if(latest == -1 || list[k][1] > list[latest][1])
                        {
                            latest = k;
                        }
                    }
                    else if(list[i][0] < list[k][1])
                    {
                        if(i == 1)
                        {
                            str += "J";
                            pos = false;
                            break Inner;
                        }
                        if(i != 1)
                        {
                            latestnotpos = k;
                            if(str.substring(latestnotpos, latestnotpos+1).equals("J") && (a == 4 || a == 1 || a == 2))
                            {
                                a = 1;
                            }
                            else if(str.substring(latestnotpos, latestnotpos+1).equals("C") && (a == 3 || a == 1 || a == 2))
                            {
                                a = 2;
                            }
                            else if(str.substring(latestnotpos, latestnotpos+1).equals("J"))
                            {
                                a = 3;
                            }
                            else if(str.substring(latestnotpos, latestnotpos+1).equals("C"))
                            {
                                a = 4;
                            }
                        }
                    }
                }
                if(pos && (a == 0 || a == 3 || a == 4))
                {
                    if(a == 0)
                        str += str.substring(latest, latest+1);
                    if(a == 3)
                        str += "C";
                    if(a == 4)
                        str += "J";
                }
                else if(i + 1 == str.length())
                {}
                else
                {
                    str = "IMPOSSIBLE";
                }
            }
            String str2 = "";
            int val = 0;
            if(!(str.equals("IMPOSSIBLE")))
            {
                for(int i = 0; i < events; i++)
                {
                    for(int k = 0; k < events; k++)
                    {
                        if(listf[i][0] == list[k][0] && listf[i][1] == list[k][1])
                        {
                            val = k;
                        }
                    }
                    str2 += str.substring(val,val+1);
                }
            }
            else
            {
                str2 = "IMPOSSIBLE";
            }

            System.out.println("Case #" + (x+1) + ": " + str2);
        }
        input.close();
    }
}