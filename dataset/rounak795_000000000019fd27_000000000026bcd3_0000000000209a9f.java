import java.io.*;
import java.util.*;
public class Codechef {
    public static final Scanner ran = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        int test_caseno = ran.nextInt();int x=1;
        ran.skip("(\r\n|[\n\r])?");
        for (int testcaseiterart = 0; testcaseiterart < test_caseno; testcaseiterart++) {
        	String inputstring=ran.nextLine();
        	String stringter="";
        	
      
        	
        	double khulabracket=inputstring.charAt(0);
        	
        	for(int i=0;i<khulabracket-48;i++)
        	{
        		stringter+='(';
        	}
        	
        	
        	stringter+=(char)khulabracket;
        	
            for(int i=1;i<inputstring.length();i++)
    		{
    		double characterinput=inputstring.charAt(i);
    		
    		
    		if(khulabracket>characterinput)
    		{
    			for(int j=0;j<(khulabracket-characterinput);j++)
    			stringter+=')';
    			stringter+=(char)characterinput;khulabracket=characterinput;	
    		}                                       
    		
    		else if(khulabracket<characterinput)
    		{
    			for(int j=0;j<(characterinput-khulabracket);j++)
    			stringter+='(';
    			stringter+=(char)characterinput;khulabracket=characterinput;
    		}
    		else
    		{
    			stringter+=(char)characterinput;
    		}
    		}
            khulabracket-=48;
        	
            for(int j=0;j<khulabracket;j++)
        		stringter+=')';
        	System.out.println("Case #"+(x++)+": "+stringter);
        }
    }
}