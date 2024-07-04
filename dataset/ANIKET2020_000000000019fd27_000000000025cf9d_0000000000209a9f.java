import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                
        System.out.println("Hi, " + name + ".");    
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 
        System.out.println("Hi, " + name + ".");    
        
    }
}
