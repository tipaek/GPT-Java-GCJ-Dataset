import java.util.*;

class Vestigium
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int testCase = 0;
        while(testCase < t)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    arr[i][j] = sc.nextInt();
                    
            isLatinSquare(arr,testCase);
            testCase++;
        }
    }
    
    public static void isLatinSquare(int[][] arr, int t)
    {
        int trace=0,r=0,c=0;
        int N = arr.length;
        HashSet<Integer> hsr = new HashSet<Integer>();
        HashSet<Integer> hsc = new HashSet<Integer>();
        
        for(int i=0;i<N;i++)
        {
            boolean isUniqueR = true, isUniqueC = true;
            for(int j=0;j<N;j++)
            {
                if(hsr.contains(arr[i][j]))
                  isUniqueR = false;

                if(hsc.contains(arr[j][i]))
                  isUniqueC = false;
                
                hsr.add(arr[i][j]);
                hsc.add(arr[j][i]);

                if(i==j)
                    trace += arr[i][j];
            }
            if(!isUniqueR)
                r++;
            if(!isUniqueC)
                c++;

            hsr.clear();
            hsc.clear();
        }
        
        System.out.println("Case #" + t + ": "+ trace+" " + r + " " + c);
    }

}