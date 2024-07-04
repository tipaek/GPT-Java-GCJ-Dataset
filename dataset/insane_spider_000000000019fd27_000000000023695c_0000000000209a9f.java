import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        int cas=1;
        while(t!=0)
        {
            String st= s.nextLine();
            String stnew="";
            //Stack stk= new Stack();
            int bracket=0;
            
            for(int i=0;i<st.length();i++)    
            {
                if(((int)st.charAt(i)-48)>bracket)
                {
                    while(bracket!=((int)st.charAt(i)-48))
                    {
                        stnew=stnew+"(";
                        bracket++;
                    }
                    stnew=stnew+st.charAt(i); 
                }
                else if(((int)st.charAt(i)-48)<bracket)
                {
                    while(bracket!=((int)st.charAt(i)-48))
                    {
                        stnew=stnew+")";
                        bracket--;
                    }
                    stnew=stnew+st.charAt(i);
                }
                else
                    stnew=stnew+st.charAt(i);
            }
            while(bracket>0)
                    {
                        stnew=stnew+")";
                        bracket--;
                    }
        System.out.println("Case #"+cas+": "+stnew);
        t--;  
        cas ++;
        }
        
    }
}