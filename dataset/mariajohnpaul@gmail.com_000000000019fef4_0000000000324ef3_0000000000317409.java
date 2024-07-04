import java.util.*;
public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String S = sc.next();
            int count = 0;
            int [] start = new int[] {0,0};
            ArrayDeque<int []> dq = new ArrayDeque<>();
            dq.add(start);
            boolean flag = false;
            S+=" ";
            for(char c : S.toCharArray())
            {
            	int l= dq.size();
            	int NX =X;
            	int NY = Y;
            	switch (c){
            	case 'E':
            		NX++;
            		break;
            	case 'W':
            		NX--;
            		break;
            	case 'N':
            		NY++;
            		break;
            	case 'S':
            		NY--;
            		break;
            	}
            	for(int i=0;i<l;i++)
            	{
            		int [] curr = dq.poll();
            		if(curr[0]==X && curr[1]==Y)
            		{
            			flag = true;
            			break;
            		}            		
            	dq.add(curr);
            	if(Math.hypot(curr[0]-NX, curr[1]-NY)>Math.hypot(curr[0]+1-NX,curr[1]-NY))
            	dq.add(new int[] {curr[0]+1,curr[1]});
            	if(Math.hypot(curr[0]-NX, curr[1]-NY)>Math.hypot(curr[0]-1-NX,curr[1]-NY))
            	dq.add(new int[] {curr[0]-1,curr[1]});
            	if(Math.hypot(curr[0]-NX, curr[1]-NY)>Math.hypot(curr[0]-NX,curr[1]+1-NY))
            	dq.add(new int[] {curr[0],curr[1]+1});
            	if(Math.hypot(curr[0]-NX, curr[1]-NY)>Math.hypot(curr[0]+1-NX,curr[1]-1-NY))
            	dq.add(new int[] {curr[0],curr[1]-1});
            	}
            	X=NX;
            	Y=NY;
            	if(flag)break;
            	count++;
            
            }
            
            if(flag)
                System.out.println("Case #"+t+": "+count);
                else
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");            	
            }               
            
            
        }    
}