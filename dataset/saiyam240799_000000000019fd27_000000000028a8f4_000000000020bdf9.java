


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);


        
            
           int t = input.nextInt();
        int var=1;
        while(var<=t)
        {
        int n = input.nextInt();
       
        int[][] array= new int[n][3];
        for(int i=0;i<n;i++)
        {
        array[i][0]=input.nextInt();
        array[i][1] =input.nextInt();
        array[i][2] = i;
        }
       Arrays.sort(array, (a,b) -> (a[0]-b[0]));
       
        char[] ans =new char[n];
       
        int flag11=0;
        int flag2=0;
        int end111=0;
        int end22=0;
        int flag3=0;
        
        
        
        for(int i=0;i<n;i++)
        {
        	if(array[i][0]>=end111)
        	{
        		flag11=0;
        	}
        if(array[i][0]>=end22)
        {
        
        	
        	flag2=0;
        }
        
        if(flag11==0)
        {
        
        	
        	flag11=1;
        
        	end111=array[i][1];
        
        	
        	ans[array[i][2]]='C';
        }
        else if(flag2==0)
        {
        flag2=1;
        end22= array[i][1];
        ans[array[i][2]]='J';
        }
        else
        {
        flag3=1;
        }
      
        }
        String answer= new String(ans);
        if(flag3==1)
        {
        	answer="IMPOSSIBLE";
        }
        System.out.println("Case #" + (var)+": " + answer);
       
        	var++;
        }
            

		w.close();
	}

}








        