


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
        int count =1;
        
        
        
        
        
        while(count<=t)
        {
            
            int n = input.nextInt();
            
            int arr[][] = new int[n][3];
          //  System.out.println(n);
            
            int ans[] = new int[1441];
            int max  =-1;
            for(int i=0;i<n;i++)
            {
                arr[i][0] = input.nextInt();
                arr[i][1] = input.nextInt();
                arr[i][2] = i;
                
                
                ans[arr[i][0]]+=1;
                ans[arr[i][1]]-=1;
                
              
                
              //  System.out.println(arr[i][0] + " " + arr[i][1]);
                
                
                if(max<arr[i][1])
                    max = arr[i][1];
                
            }
            
            
            Arrays.sort(arr,(a,b)->(a[0]-b[0]));
            
            for(int i=1;i<=max;i++)
            {
                ans[i]+= ans[i-1];
           //     w.println(i + "lll " + ans[i] + " ");
            
            }
            
            StringBuilder s= new  StringBuilder();
            int ans1[] = new int[n];
            
            
            int maxc = 0;
            
            
            int flag3=0;
            int maxj = 0;
            for(int i=0;i<n;i++)
            {
                if(ans[arr[i][0]] == 1)
                {
                    ans1[arr[i][2]] = 1;
                        if(maxc<arr[i][1])
                            maxc = arr[i][1];
                        
                        
                //   System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2] +  "ans ---- " +   ans1[arr[i][2]]);     
                        
                }
                else if(ans[arr[i][0]]==2)
                {
                    if(maxc>arr[i][0])
                    {
                        ans1[arr[i][2]] = 2;
                        if(maxj<arr[i][1])
                            maxj = arr[i][1];
                    }
                    else
                    {
                        ans1[arr[i][2]] = 1;
                        if(maxc<arr[i][1])
                            maxc = arr[i][1];
                    }
                    
                    
           //         System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2] +  "ans  " +   ans1[arr[i][2]]); 
                }
                else if(ans[arr[i][0]]==3)
                {
                    flag3=1;
                    break;
                }
            }
            
            
            for(int i=0;i<n && flag3==0;i++)
            {
            	if(ans1[i]==1)
            	{
            		s.append('C');
            	}
            	else if(ans1[i]==2)
            		s.append('J');
            }
            
            
            
            
            if(flag3==1)
            {
                w.println("Case " + "#" + count + ": IMPOSSIBLE");
            }
            else
            {
                w.println("Case " + "#" + count + ": " + s);
                
                
            }
            count++;
            
            
            
            
            
            
            
            
            
            
        }

        
	
		

		w.close();
	}

}








    