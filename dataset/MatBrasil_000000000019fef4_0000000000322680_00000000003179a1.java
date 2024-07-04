import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int T= s.nextInt();
        s.nextLine();
        for(int caso=1;caso<=T;caso++)
        {
        	int maxDigits = s.nextInt();s.nextLine();
        	HashMap<Character,Integer> id = new HashMap<>();
        	int idAtual = 0;
        	boolean[][] combinations = new boolean[10][10];
        	char[] resp = new char[10];
        	for(int i=0;i<10;i++)for(int j=0;j<10;j++)combinations[i][j]=true;
        	for(int i=0;i<10000;i++)
        	{
        		String[] query = s.nextLine().split(" ");
        		char[] input = query[0].toCharArray();
        		if(input[0]=='-')continue;
        		char[] output = query[1].toCharArray();
        		for(char o: output)if(!id.containsKey(o))id.put(o,idAtual++);
        		int digit = input[0]-'0';
    			int pos = id.get(output[0]);
        		if(output.length == input.length)
        		{
        			for(int j=digit+1;j<10;j++)combinations[j][pos] = false;
        		}
        		combinations[0][pos] = false;
        		
        	}
        	
        	for(int i=0;i<10;i++)
        	{
        		for(char c: id.keySet())
        		{
        			int lastTrue=-1;
        			for(int j=0;j<10;j++)
        			{
        				if(combinations[j][id.get(c)])
        				{
        					if(lastTrue != -1)
        					{
        						lastTrue = -2;
        						break;
        					}
        					lastTrue = j;
        				}
        				
        			}
        			if(lastTrue >= 0)
    				{
    					resp[lastTrue] = c;
    					for(int k=0;k<10;k++)combinations[lastTrue][k]=false;
    				}
        			
        		}
        	}
        	/*
        	for(int i=0;i<10;i++)
        	{
        		for(int j=0;j<10;j++)
        		{
        			if(combinations[i][j])System.out.print("T ");
        			else System.out.print("F ");
        		}
        		System.out.println();
        	}
        	*/
        	
        	System.out.println("Case #"+caso+ ": "+new String(resp));
        }
    }
    
    public static int getMoveX(char m)
    {
    	if(m == 'E')return 1;
    	if(m == 'W')return -1;
    	return 0;
    }
    
    public static int getMoveY(char m)
    {
    	if(m == 'N')return 1;
    	if(m == 'S')return -1;
    	return 0;
    }
    
    
    
    
}