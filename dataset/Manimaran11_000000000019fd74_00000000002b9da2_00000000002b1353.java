
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    public static BigInteger[][] create(int n){
        BigInteger[][] arr = new BigInteger[n][n];  
  
        // Iterate through every line and print integer(s) in it 
        for (int line = 0; line < n; line++) 
        { 
            // Every line has number of integers equal to line number 
            for (int i = 0; i <= line; i++) 
            { 
            // First and last values in every row are 1 
            if (line == i || i == 0) 
                arr[line][i] = BigInteger.ONE; 
            else // Other values are sum of values just above and left of above 
                arr[line][i] = arr[line-1][i-1].add(arr[line-1][i]); 
            // System.out.print(arr[line][i]); 
            } 
            // System.out.println(""); 
        }
        return arr; 
    }

    public static boolean isSafe(BigInteger[][] arr,int i,int j) {
        return i>=0 && j>=0 && i>=j && i<500 && arr[i][j]!=null;
    }

    public static boolean solve(BigInteger[][] arr,BigInteger sum,LinkedList<point>l,int i,int j){
            int comp = sum.compareTo(BigInteger.ZERO);    
         if(comp==0)
                return true;
            if(comp<0)
            return false;
            if(isSafe(arr,i,j) && l.size()<500){
                sum=sum.subtract(arr[i][j]);
                l.add(new point(i+1,j+1));
                if(solve(arr,sum,l,i+1,j)){
                    return true;
                }
                if(solve(arr,sum,l,i,j+1))
                return true;
                if(solve(arr,sum,l,i+1,j+1))
                return true;
                //   if(solve(arr,sum,l,i+1,j-1)){
                //     return true;
                // }
                l.removeLast();
                sum=sum.add(arr[i][j]);
            }
            return false;
    }

    public static void main(String []args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // long start = System.currentTimeMillis();
        int y=1;
        BigInteger [][]arr = create(500);
            // System.out.println(arr[0][0].add(arr[1][0]));
            while(t>0){
                System.out.print("Case #"+y+": ");
           String s = br.readLine();
            BigInteger sum = new BigInteger(s);
            LinkedList<point>l = new LinkedList<>();
            if(solve(arr,sum,l,0,0)){
                for(point p : l){
                    System.out.println(p.x+" "+p.y);
                }
            }

            y++;
            t--;
        }
        // long end = System.currentTimeMillis();
        // float sec = (end - start) / 1000F; System.out.println(sec + " seconds");
   
    }

    public static class point{
        int x,y;
        point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}