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
            	for(int i=0;i<l;i++)
            	{
            		int [] curr = dq.poll();
            		if(curr[0]==X && curr[1]==Y)
            		{
            			flag = true;
            			break;
            		}            		
            	dq.add(curr);
            	dq.add(new int[] {curr[0]+1,curr[1]});
            	dq.add(new int[] {curr[0]-1,curr[1]});
            	dq.add(new int[] {curr[0],curr[1]+1});
            	dq.add(new int[] {curr[0],curr[1]-1});
            	}
            	
            	if(flag)break;
            	count++;
            	switch (c){
            	case 'E':
            		X++;
            		break;
            	case 'W':
            		X--;
            		break;
            	case 'N':
            		Y++;
            		break;
            	case 'S':
            		Y--;
            		break;
            	}
            }
//            	if(c=='S')
//                {                	
//                    dq.add(new int[] {curr[0]+1,curr[1]});
//                    dq.add(new int[] {curr[0],curr[1]-1});
//                }else if(c=='N')
//                {
//                	dq.add(new int[] {curr[0]+1,curr[1]});
//                    dq.add(new int[] {curr[0],curr[1]+1});
//                }else if(c=='E')
//                {
//                	dq.add(new int[] {curr[0]+1,curr[1]});
//                    dq.add(new int[] {curr[0],curr[1]-1});
//                }else{
//                    //W
//                	dq.add(new int[] {curr[0]+1,curr[1]});
//                    dq.add(new int[] {curr[0],curr[1]-1});
//                }
            
            if(flag)
                System.out.println("Case #"+t+": "+count);
                else
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");            	
            }               
            
            
        }    
}