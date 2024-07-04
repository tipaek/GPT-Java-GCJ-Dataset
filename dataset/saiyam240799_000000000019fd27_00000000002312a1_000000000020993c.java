import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter w = new PrintWriter(System.out);

        int t = input.nextInt();
        int count =1;
        while(t-->0)
        {
            int n = input.nextInt();
        
            int a[][] = new int[n][n];
            
            HashSet<Integer> set = new HashSet<Integer>();
            HashSet<Integer> set1 = new HashSet<Integer>();
            
            int sum =0;
            int row =0;
            int col =0;
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j] = input.nextInt();
            
                }
            }
            
            
            int ansrow = 0;
            int anscol =0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    
                
                    if(set.contains(a[i][j]))
                    {
                        
                        row=1;
                    }
                    else
                    {
                        set.add(a[i][j]);
                    }
                    
                    if(i==j)
                        sum+=a[i][j];
                    
                    
                    
                    
                    if(set1.contains(a[j][i]))
                    {
                        //System.out.println(set1);
                    //    System.out.println(i + " " + j + " " + a[j][i]);
                        col=1;
                    }
                    else
                        {
                            
                            set1.add(a[j][i]);
                       //     System.out.println(set1);
                        }
                        
                        
                    
                }
                ansrow+=row;
                anscol+=col;
                
           //     System.out.println("ans  " + ansrow);
                set.clear();
                set1.clear();
                row =0;
                col=0;
            }
            
            
            System.out.println("Case " + "#" + count +": " + sum + " " + ansrow + " " + anscol);
            
            
            count++;
            
            
            
        }
        


		w.close();
	}
}


