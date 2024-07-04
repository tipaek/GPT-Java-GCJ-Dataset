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
            int flagis1=0;
            
            for(int i=0;i<st.length();i++)    
            {
                if(st.charAt(i)=='0')
                {
                    if(flagis1==0)
                    {
                        stnew=stnew+st.charAt(i); 
                        flagis1=0;
                    }
                    else
                    {
                        stnew=stnew+")"+st.charAt(i); 
                        flagis1=0;
                    }
                } 
                else
                {
                    if(flagis1==0)
                    {
                        stnew=stnew+"("+st.charAt(i); 
                        flagis1=1;
                    }
                    else
                    {
                        stnew=stnew+st.charAt(i); 
                        flagis1=1;
                    }
                }
            }
            if(flagis1==1)
            	 stnew=stnew+")"; 
        System.out.println("Case #"+cas+": "+stnew);
        t--;  
        cas ++;
        }
        
    }
}