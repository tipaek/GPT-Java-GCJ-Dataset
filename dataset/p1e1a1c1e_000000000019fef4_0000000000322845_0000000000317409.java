import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    static  String[] inputs;
    static  String[] ouputs;
    static int numOfInputs; 
    static int numOfOutputs; 
    static final int NUM_OF_INPUTS =1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	
        String inputStr ;
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        //System.out.println("Input: "+t );
        for (int i = 1; i <= t; ++i) {
        	
          int x = in.nextInt();
          int y = in.nextInt();
          inputStr = in.next();

       // System.out.println("   ...........  "+ inputStr);
          String result=processResult( x,y,inputStr);
          System.out.println("Case #" + i + ": "+result);
        }
      
	
	}
	

	public static boolean isitPossible(int x,int y,int movesCount)
	{
		if(x<0) x=-x;
		if(y<0) y= -y;
		 //System.out.println("x:"+x+"      y:"+y+"  movesCount:  "+movesCount);
		if(movesCount >=(x+y))
		return true;
		else
			return false;
	}
	public static String processResult(int x,int y,String moves)
	{
		

		char[] carr1  = new char[moves.length()];
		carr1 = moves.toCharArray();
		int deltax=0;
		int deltay=0;
		for(int i=0;i<moves.length();++i)
		{
			switch (carr1[i]) 
			{
			case 'N':
				++deltay;
				break;
			case 'S':
				--deltay;
				break;
			case 'E':
				++deltax; 
				break;
			case 'W':
				--deltax; 
				break;
			}
			if( isitPossible(x+deltax,y+deltay,i+1))
			     return  ""+(i+1);
		}

		return  "IMPOSSIBLE";
		
	}

	
}
