
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);


        
            
           int t = input.nextInt();
        int count=1;
        while(count<=t)
        {
        int n = input.nextInt();
       
        int[][] arr= new int[n][3];
        for(int i=0;i<n;i++)
        {
        arr[i][0]=input.nextInt();
        arr[i][1] =input.nextInt();
        arr[i][2] = i;
        }
        Arrays.sort(arr, (a,b) -> (a[0]-b[0]));
       
        char[] ans =new char[n];
       
        int flag11=0;
        int flag2=0;
        int end111=0;
        int end22=0;
        int flag3=0;
        for(int i=0;i<n;i++)
        {
        if(arr[i][0]>=end111)
        {
        flag11=0;
        }
        if(arr[i][0]>=end22)
        {
        flag2=0;
        }
        //System.out.println(flag11 + " " + flag2 + " " + end111 + " " + end22 );
        if(flag11==0)
        {
        flag11=1;
        end111=arr[i][1];
        ans[arr[i][2]]='C';
        }
        else if(flag2==0)
        {
        flag2=1;
        end22= arr[i][1];
        ans[arr[i][2]]='J';
        }
        else
        {
        flag3=1;
        }
        //System.out.println(flag11 + " " + flag2 + " " + end111 + " " + end22 );
        //System.out.println(ans);
        }
        String answer= new String(ans);
        if(flag3==1)
        {
        	answer="IMPOSSIBLE";
        }
        System.out.println("Case #" + (count)+": " + answer);
       
        count++;
        }
            

		w.close();
	}

}








        