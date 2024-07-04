import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int i=1; i<=T; i++){
            String[] info = in.nextLine().split("");
            int[] array = new int[info.length + 1];
            int[] array1 = new int[info.length + 1];
            int curr = 0;
            array[0] = Integer.parseInt(info[0]);
            curr = array[0];
            //for(int j = 0; j < info.length; j++)
            int j = 0;
            while(j < info.length-1)  	
            {

            	//System.out.println(info.length);
            	if(Integer.parseInt(info[j]) > Integer.parseInt(info[j+1]))
            	{
            		array1[j+1] = Integer.parseInt(info[j]) - Integer.parseInt(info[j+1]) ;
            		//array[j+2] = Integer.parseInt(info[j+1]) ;
            		curr -= array1[j+1];
            		j = j+1;
            	}
            	else if(Integer.parseInt(info[j]) < Integer.parseInt(info[j+1]))
            	{
            		array[j+1] = (Integer.parseInt(info[j+1]) - curr);
            		curr += (Integer.parseInt(info[j+1]) - curr);
            		j++;
            	}
            	else
            	{
            		j++;
            	}
            	//System.out.println(curr);
            }
            StringBuffer res = new StringBuffer("");
            for(int l = 0; l < info.length; l++)
            {
            	for(int m = 0; m < array1[l]; m++)
            	{
            		res.append(")");
            	}
            	for(int n = 0; n < array[l]; n++)
            	{
            		res.append("(");
            	}
            	res.append(info[l]);
            }
            for(int p = 0; p < curr; p++)
            {
            	res.append(")");
            }

            
            System.out.println("\n" + "Case #" + i + ": " + res);          
            
            }
        	in.close();
        }
}