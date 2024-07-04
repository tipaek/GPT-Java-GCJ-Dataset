import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution
{
    
    public static void main(String[] args) 
    {
        Stack braces=new Stack();
        int top=-1;
        
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        
        int i=0, currentInt, currentmax=0;
        char currentChar;
        boolean open=true;
        
        while(i<T) //Main 
        {
            ArrayList<Character> result = new ArrayList<Character>();
            String exp=scan.next();
            int j=0;    
            
            while(j<exp.length()) //Input String Traversal
            {
                    
                    currentInt=Character.getNumericValue(exp.charAt(j));
                    currentChar=exp.charAt(j);
                    System.out.println(currentInt);

                    if(open==false) // closing brackets
                    {
                            if(currentInt==currentmax)
                            {
                                            result.add(currentChar);
                                         
                            }

                            else if(currentInt<currentmax)
                            {
                                    while(top>(currentInt-1))
                                    {
                                            braces.pop();
                                            top--;
                                            result.add(')');
                                    }
                                    result.add(currentChar);
                                    if(top==-1)
                                    {
                                        j++;
                                        open=true;
                                        continue;
                                    }

                            }
                            else //currentInt>currentmax
                            {					
                                    while(top!=-1)
                                    {
                                            braces.pop();
                                            top--;
                                            result.add(')');
                                    }					
                                    open=true;                                    
                            }
                    }

                    if(open==true) //(opening brackets)
                    {	
                            currentmax=currentInt;
                            for(int temp=0; temp<currentInt; temp++)
                            {
                                    braces.push('(');
                                    top++;
                                    result.add('(');
                            }
                            result.add(currentChar);									
                            open=false;
                    }
                    
                    j++;	
            }
            
            //emptying remaining stack
            while(top!=-1)
            {
                braces.pop();
                top--;
                result.add(')');
            }
            open=true;
                
                              
                System.out.println("Case #" + (i+1)+": "+getStringRepresentation(result));
                i++;
                
        }       
    }
    
   public static String getStringRepresentation(ArrayList<Character> list)
{    
    StringBuilder builder = new StringBuilder(list.size());
    for(Character ch: list)
    {
        builder.append(ch);
    }
    return builder.toString();
}
    
}
