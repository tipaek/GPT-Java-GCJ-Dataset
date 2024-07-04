import java.util.Scanner;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int tcCount = in.nextInt();
        int B = in.nextInt();
        //System.out.println("tcCount= "+tcCount);
        
        
        for(int x=1;x<=tcCount;x++){
            char[] result = new char[B];    
            int queries=0;
            while(queries<10){
                queries++;
                in.nextLine();
                System.out.println(queries);
                result[queries-1]=in.nextInt()==1?'1':'0';
                
            }
            //System.out.println(Arrays.toString(result));
            System.out.println(new String(result));
        }
        
        
    }
    
    
    
    
}