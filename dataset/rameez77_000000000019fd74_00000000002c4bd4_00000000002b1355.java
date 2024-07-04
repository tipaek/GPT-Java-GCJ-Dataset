import java.io.*;
import java.util.*;

class square {
    static void test(int tc, int r, int c, int arr[][])
    {
        int sum = 0;
        int[][] arrc = new int[r][c];
        arrc = arr;
        
        int flag = 1;
        while (flag == 1)
        {
            flag = 0;
            for (int i=0; i<r; i++)
            {
                for(int j=0; j<c; j++)
                {
                    sum += arr[i][j];
                }
            }
            
            for (int i=0; i<r; i++)
            {
                for(int j=0; j<c; j++)
                {
                    int t = i-1, b = i+1, l = j-1, r1 = j+1, count = 0, sumn = 0;
                    
                    
                    while(l>=0)
                    {
                        if(arr[i][l] != -1)
                        {
                            count += 1;
                            sumn += arr[i][l];
                            flag = 1;
                            break;
                        }
                        else
                            l -= 1;
                    }
                    
                    while(r1<c)
                    {
                        if(arr[i][r1] != -1)
                        {
                            count += 1;
                            sumn += arr[i][r1];
                            flag = 1;
                            break;
                        }
                        else
                            r1 += 1;
                    }
                    
                    while(t>=0)
                    {
                        if(arr[t][j] != -1)
                        {
                            count += 1;
                            sumn += arr[t][j];
                            flag = 1;
                            break;
                        }
                        else
                            t -= 1;
                    }
                    
                    while(b<r)
                    {
                        if(arr[b][j] != -1)
                        {
                            count += 1;
                            sumn += arr[b][j];
                            flag = 1;
                            break;
                        }
                        else
                            r1 += 1;
                    }
                    
                    if(flag == 1)
                    {
                        float avg = sumn/count;
                        if(avg > arr[i][j])
                            arrc[i][j] = -1;
                    }
                }
            }
            arr = arrc;
        }
        System.out.println("Case #"+(tc+1)+": "+sum);
    }
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i=0; i<t; i++)
		{
		    int r = in.nextInt();
		    int c = in.nextInt();
		    int[][] arr = new int[r][c];
		    for(int j=0; j<r; j++)
		    {
		        for(int k=0; k<c; k++)
		        {
		            arr[j][k] = in.nextInt();
		        }
		    }
		    test(i, r, c, arr);
		}
	}
}