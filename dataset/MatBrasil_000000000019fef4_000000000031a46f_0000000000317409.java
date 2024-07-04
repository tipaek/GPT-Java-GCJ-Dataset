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
        	
        	String[] t = s.nextLine().split(" ");
        	int x_ini = Integer.parseInt(t[0]),y_ini=Integer.parseInt(t[1]);
        	char[] moves = t[2].toCharArray();
        	int[] x = new int[moves.length+1];
        	int[] y = new int[moves.length+1];
        	x[0] = x_ini;
        	y[0] = y_ini;
        	for(int i=0;i<moves.length;i++)
        	{
        		x[i+1] = x[i]+getMoveX(moves[i]);
        		y[i+1] = y[i]+getMoveY(moves[i]);
        	}
        	int minDist=-1;
        	for(int i=0;i<x.length;i++)
        	{
        		int dist = Math.abs(x[i])+Math.abs(y[i]);
        		if(dist<=i)
        		{
        			minDist = i;
        			break;
        		}
        	}
        	if(minDist==-1)System.out.println("Case #"+caso+ ": IMPOSSIBLE");
        	else System.out.println("Case #"+caso+ ": "+minDist);
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