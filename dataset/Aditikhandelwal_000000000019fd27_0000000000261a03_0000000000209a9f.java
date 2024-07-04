

import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc=t;
        while(t!=0)
        {
        	String s = scn.next();
        	int currento=0;
        	int currentc=0;
        	String ans="";
        	for(int i =0;i<s.length();i=i+2)
        	{
        		int v1= Character.getNumericValue(s.charAt(i));
        		int require = v1-currento;
        		if(require<0)
        		{
        			switch((int)Math.abs(require))
            		{
            		case 0:
            			    break;
            		case 1:
            			ans= ans+")";
            			currento=currento-1;
            			currentc=currentc-1;
            			break;
            		case 2:
            			ans= ans+"))";
            			currento=currento-2;
            			currentc=currentc-2;
            			break;
            		case 3:
            			ans= ans+")))";
            			currento=currento-3;
            			currentc=currentc-3;
            			break;
            		case 4:
            			ans= ans+"))))";
            			currento=currento-4;
            			currentc=currentc-4;
            			break;
            		case 5:
            			ans= ans+")))))";
            			currento=currento-5;
            			currentc=currentc-5;
            			break;
            		case 6:
            			ans= ans+"))))))";
            			currento=currento-6;
            			currentc=currentc-6;
            			break;
            		case 7:
            			ans= ans+")))))))";
            			currento=currento-7;
            			currentc=currentc-7;
            			break;
            		case 8:
            			ans= ans+"))))))))";
            			currento=currento-8;
            			currentc=currentc-8;
            			break;
            		case 9:
            			ans= ans+")))))))))";
            			currento=currento-9;
            			currentc=currentc-9;
            			break;
            		}
        			
        		}
        		else
        		{
        		switch(require)
        		{
        		case 0:
        			    break;
        		case 1:
        			ans= ans+"(";
        			currento=currento+1;
        			currentc=currentc+1;
        			break;
        		case 2:
        			ans= ans+"((";
        			currento=currento+2;
        			currentc=currentc+2;
        			break;
        		case 3:
        			ans= ans+"(((";
        			currento=currento+3;
        			currentc=currentc+3;
        			break;
        		case 4:
        			ans= ans+"((((";
        			currento=currento+4;
        			currentc=currentc+4;
        			break;
        		case 5:
        			ans= ans+"(((((";
        			currento=currento+5;
        			currentc=currentc+5;
        			break;
        		case 6:
        			ans= ans+"((((((";
        			currento=currento+6;
        			currentc=currentc+6;
        			break;
        		case 7:
        			ans= ans+"(((((((";
        			currento=currento+7;
        			currentc=currentc+7;
        			break;
        		case 8:
        			ans= ans+"((((((((";
        			currento=currento+8;
        			currentc=currentc+8;
        			break;
        		case 9:
        			ans= ans+"(((((((((";
        			currento=currento+9;
        			currentc=currentc+9;
        			break;
        		}
        		}
        		ans= ans+v1;
        		if(i==s.length()-1)
        		{
        			break;
        		}
        		int v2= Character.getNumericValue(s.charAt(i+1));
        		if(v2>v1)
        		{
        			int require1 = v2-currento;
        			switch(require1)
            		{
            		case 0:
            			    break;
            		case 1:
            			ans= ans+"(";
            			currento=currento+1;
            			currentc=currentc+1;
            			break;
            		case 2:
            			ans= ans+"((";
            			currento=currento+2;
            			currentc=currentc+2;
            			break;
            		case 3:
            			ans= ans+"(((";
            			currento=currento+3;
            			currentc=currentc+3;
            			break;
            		case 4:
            			ans= ans+"((((";
            			currento=currento+4;
            			currentc=currentc+4;
            			break;
            		case 5:
            			ans= ans+"(((((";
            			currento=currento+5;
            			currentc=currentc+5;
            			break;
            		case 6:
            			ans= ans+"((((((";
            			currento=currento+6;
            			currentc=currentc+6;
            			break;
            		case 7:
            			ans= ans+"(((((((";
            			currento=currento+7;
            			currentc=currentc+7;
            			break;
            		case 8:
            			ans= ans+"((((((((";
            			currento=currento+8;
            			currentc=currentc+8;
            			break;
            		case 9:
            			ans= ans+"(((((((((";
            			currento=currento+9;
            			currentc=currentc+9;
            			break;
            		}
        			ans= ans+v2;
        		}
        		else if(v2<v1)
        		{
        			int require2 = v1-v2;
        			switch(require2)
            		{
            		case 0:
            			    break;
            		case 1:
            			ans= ans+")";
            			currento=currento-1;
            			currentc=currentc-1;
            			break;
            		case 2:
            			ans= ans+"))";
            			currento=currento-2;
            			currentc=currentc-2;
            			break;
            		case 3:
            			ans= ans+")))";
            			currento=currento-3;
            			currentc=currentc-3;
            			break;
            		case 4:
            			ans= ans+"))))";
            			currento=currento-4;
            			currentc=currentc-4;
            			break;
            		case 5:
            			ans= ans+")))))";
            			currento=currento-5;
            			currentc=currentc-5;
            			break;
            		case 6:
            			ans= ans+"))))))";
            			currento=currento-6;
            			currentc=currentc-6;
            			break;
            		case 7:
            			ans= ans+")))))))";
            			currento=currento-7;
            			currentc=currentc-7;
            			break;
            		case 8:
            			ans= ans+"))))))))";
            			currento=currento-8;
            			currentc=currentc-8;
            			break;
            		case 9:
            			ans= ans+")))))))))";
            			currento=currento-9;
            			currentc=currentc-9;
            			break;
            		}
        			ans= ans+v2;
        		}
        		else
        		{
        			ans= ans+v2;
        		}
        	}
        	
        	switch(currentc)
            		{
            		case 0:
            			    break;
            		case 1:
            			ans= ans+")";
            			currento=currento-1;
            			currentc=currentc-1;
            			break;
            		case 2:
            			ans= ans+"))";
            			currento=currento-2;
            			currentc=currentc-2;
            			break;
            		case 3:
            			ans= ans+")))";
            			currento=currento-3;
            			currentc=currentc-3;
            			break;
            		case 4:
            			ans= ans+"))))";
            			currento=currento-4;
            			currentc=currentc-4;
            			break;
            		case 5:
            			ans= ans+")))))";
            			currento=currento-5;
            			currentc=currentc-5;
            			break;
            		case 6:
            			ans= ans+"))))))";
            			currento=currento-6;
            			currentc=currentc-6;
            			break;
            		case 7:
            			ans= ans+")))))))";
            			currento=currento-7;
            			currentc=currentc-7;
            			break;
            		case 8:
            			ans= ans+"))))))))";
            			currento=currento-8;
            			currentc=currentc-8;
            			break;
            		case 9:
            			ans= ans+")))))))))";
            			currento=currento-9;
            			currentc=currentc-9;
            			break;
            		}
        	System.out.println("Case #"+(tc-t+1)+": " +ans);
        	t--;
        }

	}

}
