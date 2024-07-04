import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        int max=Integer.MAX_VALUE;
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for (int q=1; q<=t; q++)
        {
            int x=scan.nextInt();
            int y=scan.nextInt();
            String s=scan.next();
            int[][] pos=new int[1][2];
            pos[0][0]=x; pos[0][1]=y;
            boolean flag=false;
            int count=0;
            for (int i=0; i<s.length(); i++){
                if(s.charAt(i)== 'N')
    	            pos[0][1]++;
    	        else if(s.charAt(i)== 'S')
    	            pos[0][1]--;
    	        else if(s.charAt(i) == 'E')
    	            pos[0][0]++;
    	        else if(s.charAt(i) == 'W')
    	            pos[0][0]--;
    	        count++;
    	        if((Math.abs(pos[0][0]) + Math.abs(pos[0][1])) <= count){
	                flag = true;
	                    break;
	            }
            }
            System.out.println((flag==true)?"Case #"+q+": "+count:"Case #"+q+": "+"IMPOSSIBLE");
        }
    }
}