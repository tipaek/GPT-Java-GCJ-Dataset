
import java.util.*;

public class Solution
{
   public static String createOpen(int copies)
    {      String s=String
            .join("",Collections.nCopies(copies, "("));
            
            
         return s; 
    }
    
     
    public static String createClose(int copies)
    {       String s=String.join("", Collections.nCopies(copies, ")"));
         return s; 
    }
    public static void main(String[] args) 
    {

     Scanner sc=new Scanner(System.in);
     int count=0;
     int test=sc.nextInt();
       while(test>=0)
        {   String s_line=sc.nextLine();
        
        
            int brac=0;
          
            StringBuilder dept=new StringBuilder("");
            int parathen=0;  
            for(int i=0;i<s_line.length();i++)
            {
                int answer= s_line.charAt(i)-'0';
                if(answer==parathen)
                    dept.append(s_line.charAt(i));

                else if(answer>parathen)
                {   int diff = answer-parathen;
                   
                   dept.append(createOpen(diff))
                    .append(s_line.charAt(i));
                    parathen = parathen+diff;
                }
                else
                {    
                      int diff = parathen-answer;
                    dept.append(createClose(diff))
                    .append(s_line.charAt(i));
                    
                    
                    parathen=parathen-diff;
                }
            }
            
         if(parathen>0) 
           dept.append(createClose(parathen));
           
           if(count>0)
              System.out.println("Case #"+(count)+": "+dept.toString());
        test=test-1;
        
        ++count;
        }
     
    }




}