import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner scr = new Scanner(System.in);
        int T = scr.nextInt();
        
        if(T<1 || T>100)
            return;
        

        
        for(int i=0;i<T;i++)
        {

            String open_paranthesis = "";
            String output_str = "";
            String closing_paranthesis = "";
            String S = scr.next();
            
            char str[] = S.toCharArray();
            
            int prev_no = 0,next_no=0;
            
            int balance = 0;
            
            for(int j=0;j<str.length;j++)
            {
                open_paranthesis = "";
                closing_paranthesis = "";
                prev_no = Character.getNumericValue(str[j]);
                String extra_open_paranthesis = "";
                for(int k=0;k<prev_no;k++)
                {
                    if(balance < prev_no){
                        open_paranthesis += "(";
                        balance++;      
                    }
                }
                
                if(j==str.length-1)
                {
                    for(int a=0;a<balance;a++)
                    {
                        closing_paranthesis +=")";
                    }
                    
                }

                else
                {
                    next_no = Character.getNumericValue(str[j+1]);
                    if(next_no<=prev_no)
                    {
                        int temp = prev_no - next_no;
                        for(int z=0;z<temp;z++)
                        {
                            closing_paranthesis+=")";
                            balance --;
                        }
                        
                    }
                    
                    else if(next_no > prev_no)
                    {
                        int temp = next_no - prev_no;
                        for(int z=0;z<temp;z++)
                        {
                           extra_open_paranthesis += "(";
                           balance++;
                        }
                    }
                    
                } 
                output_str+= open_paranthesis+str[j]+extra_open_paranthesis+closing_paranthesis;
            }

        System.out.println("Case #"+(i+1)+": "+output_str);
        }
    }
}