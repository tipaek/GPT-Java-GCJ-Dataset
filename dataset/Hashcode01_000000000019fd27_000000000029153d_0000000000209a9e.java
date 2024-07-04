import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        PrintWriter writer = new PrintWriter(System.out);
        String a[] = br.readLine().split(" ");
        String res = "";
        boolean fg = false;
        int chk = 0;
        int T = Integer.parseInt(a[0]);
        int B = Integer.parseInt(a[1]);
        //System.out.println(T + " "+ B);
        int mid = B/2;
        int nmid = mid + 1;
        int t = T;
        int chance = 0;
        while(t-- > 0)
        {
            //System.out.println("1");
        	fg = true;
            res = "";
            int val[] = new int[B+1];
            int prev[] = new int[B+1];
            for(int i=0;i<=B;i++)
            {
                val[i] = -1;
                prev[i] = -1;
            }
            if(B == 10)
            {
                //System.out.println("2a");
                for(int i=1;i<=10;i++)
                {
                    writer.write(Integer.toString(i));
                    writer.flush();
                    val[i] = Integer.parseInt(br.readLine());
                    res += val[i];
                }
                writer.write(res);
                writer.flush();
                char ok = (char)br.read();
                if(ok == 'N')
                    System.exit(0);
            }
            else
            {
                //System.out.println("2b");
                ArrayList<Integer> pos = new ArrayList<Integer>();
                while(pos.size() < B)
                {
//                	for(int i = 1;i<=B;i++)
//                		System.out.print(val[i]+ "  ");
//                	System.out.println();
                    if(chance % 10 == 0)
                    {
                        writer.write(Integer.toString(mid));
                        writer.flush();
                        //System.out.println("get mid");
                        val[mid] = Integer.parseInt(br.readLine());
                        chance++;
                    }
                    if(chance % 10 == 1)
                    {
                        writer.write(Integer.toString(nmid));
                        writer.flush();
                        //System.out.println("got nmid");
                        val[nmid] = Integer.parseInt(br.readLine());
                        chance ++;
                    }
                    if(!pos.contains(mid))
                    	pos.add(mid);
                    if(!pos.contains(nmid))
                    	pos.add(nmid);
                    //System.out.println(pos);
                    if(fg)
                    {
                    	int n = 0;
                    	if(val[mid] == val[nmid])
                    	{
                    		do
                    		{
                    			do
                    			{
                    				n = (int)((Math.random()*100)%(B+1));
                    				//System.out.print("---"+n);
                    			}while(n==0 || pos.contains(n));
                    			writer.write(Integer.toString(n));
                    			writer.flush();
                    			val[n] = Integer.parseInt(br.readLine());
                    			writer.write(Integer.toString(B-n+1));
                    			writer.flush();
                    			val[B-n+1] = Integer.parseInt(br.readLine());
                    			chance += 2;
                    			pos.add(n);
                    			pos.add(B-n+1);
                    			if(chance%10 == 0)
                    				break;
                    		}while(val[n] == val[B-n+1]);
                    	}
                    	else
                    	{
                    		do
                    		{
                    			do
                    			{
                    				n = (int)((Math.random()*100)%(B+1));
                    				//System.out.print("---!"+n+"\n");
                    			}while(n==0 || pos.contains(n));
                    			writer.write(Integer.toString(n));
                    			writer.flush();
                    			val[n] = Integer.parseInt(br.readLine());
                    			writer.write(Integer.toString(B-n+1));
                    			writer.flush();
                    			val[B-n+1] = Integer.parseInt(br.readLine());
                    			chance += 2;
                    			pos.add(n);
                    			pos.add(B-n+1);
                    			if(chance%10 == 0)
                    				break;
                    		}while(val[n] != val[B-n+1]);
                    	}
                    	chk = n;
                    	while(chance % 10 != 0)
                    	{
                    		do
                    		{
                    			n = (int)((Math.random()*100)%(B+1));
                    		}while(n==0 || pos.contains(n));
                    		writer.write(Integer.toString(n));
                    		writer.flush();
                    		val[n] = Integer.parseInt(br.readLine());
                    		chance ++;
                    		pos.add(n);
                    	}
                    	fg = false;
                    }
                    else
                    {
                    	writer.write(Integer.toString(chk));
                    	writer.flush();
                    	val[chk] = Integer.parseInt(br.readLine());
                    	chance++;
                    	if(val[mid] == val[nmid] && prev[mid] == val[mid])
                    	{
                    		if(val[chk] == prev[chk])
                    		{
                    			for(int i=1;i<= B;i++)
                    				val[i] = prev[i];
                    		}
                    		else
                    		{
                    			pos.clear();
                    			for(int i=1;i<=B;i++)
                    			{
                    				if(prev[i] != -1)
                    				{
                    					val[B-i+1] = prev[i];
                    					pos.add(B-i+1);	
                    				}
                    			}
                    		}
                    	}
                    	else if(val[mid] == val[nmid] && prev[mid] != val[mid])
                    	{
                    		if(val[chk] != prev[chk])
                    		{
                    			for(int i : pos)
                    				val[i] = (prev[i]+1)%2;
                    		}
                    		else
                    		{
                    			pos.clear();
                    			for(int i=1;i<=B;i++)
                    			{
                    				val[B-i+1] = prev[i];
                    				if(prev[i] != -1)
                    				{
                    					val[B-i+1] += 1;
                    					val[B-i+1] %= 2;
                    					pos.add(B-i+1);		
                    				}
                    			}
                    		}
                    	}
                    	else if(val[mid] != val[nmid] && val[mid] == prev[mid])
                    	{
                    		if(prev[chk] == val[chk])
                    			for(int i=1;i<= B;i++)
                    				val[i] = prev[i];
                    		else
                    		{
                    			pos.clear();
                    			for(int i=1;i<=B;i++)
                    			{
                    				val[B-i+1] = prev[i];
                    				if(prev[i] != -1)
                    				{
                    					val[B-i+1] += 1;
                    					val[B-i+1] %= 2;
                    					pos.add(B-i+1);		
                    				}
                    			}
                    		}
                    	}
                    	else
                    	{
                    		if(prev[chk] == val[chk])
                    		{
                    			pos.clear();
                    			for(int i=1;i<=B;i++)
                    			{
                    				val[B-i+1] = prev[i];
                    				if(prev[i] != -1)
                    					pos.add(B-i+1);		
                    			}
                    		}
                    		else
                    		{
                    			for(int i=1;i<=B;i++)
                    				if(prev[i] != -1)
                    					val[i] = (prev[i]+1)%2;
                    		}
                    	}
                    	int n = 0;
                    	while(chance % 10 != 0)
                    	{
                    		do
                    		{
                    			n = (int)((Math.random()*100)%(B+1));
                    		}while(n==0 || pos.contains(n));
                    		writer.write(Integer.toString(n));
                    		writer.flush();
                    		val[n] = Integer.parseInt(br.readLine());
                    		chance ++;
                    		pos.add(n);
                    		if(pos.size() == B)
                    			break;
                    	}
                    	for(int i=1;i<=B;i++)
                    		prev[i] = val[i];
                    }
                }//while - fill
                for(int i=1;i<=B;i++)
                	res += val[i];
                //System.out.println("Result : "+res);
                writer.write(res);
                writer.flush();
                char ok = (char)br.read();
                if(ok == 'N')
                	System.exit(0);
            }// else - B
        }// while - T
    }
}