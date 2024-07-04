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
            int a; 
            Outer:
            for(int i = 1; i < events; i++)
            {
                a = 0; 
                    if(i != 1 && str.substring(str.length() - 2,str.length()).equals("JJ"))
                    {
                        a = 3; //SPECIAL CASE
                    }
                    else if(i != 1 && str.substring(str.length() - 2,str.length()).equals("CC"))
                    {
                        a = 2; //SPECIAL CASE
                    }
                    else if(i == 1 && list[i][0] >= list[0][1])
                    {
                        a = 1;
                    }
                    else if(i == 1 && list[i][0] < list[0][1])
                    {
                        a = 2;
                    }
                    else if(list[i][0] >= list[i-1][1] && list[i][0] >= list[i-2][1])
                    {
                        a = 3;
                    }
                    else if(list[i][0] >= list[i-1][1] && list[i][0] < list[i-2][1])
                    {
                        a = 4;
                    }
                    else if(list[i][0] < list[i-1][1] && list[i][0] >= list[i-2][1])
                    {
                        a = 5;
                    }
                    else
                    {
                        str = "IMPOSSIBLE";
                        break Outer;
                    }
                if(a == 1)
                {
                    str += str.substring(0,1);
                }
                else if(a == 2)
                {
                    str += "J";
                }
                else if(a == 3)
                {
                    str += "C";
                }
                else if(a == 4)
                {
                    str += str.substring(str.length()-1, str.length());
                }
                else if(a == 5)
                {
                    str += str.substring(str.length()-2, str.length()-1);
                }
                else
                {}
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