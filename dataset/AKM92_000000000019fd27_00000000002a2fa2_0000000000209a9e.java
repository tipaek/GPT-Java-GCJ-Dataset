import java.util.*;

public class Solution {
    
    public static void prt(int[] arr,int B, Scanner sc)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < B; i++)
        {
            sb.append(Integer.toString(arr[i]));

        }
        System.out.println(sb.toString());
        //sc.nextLine();
        //sc.nextLine();
    }
    
    public static void solve(Scanner sc, int B, int q, int[] arr)
    {
        
        //int count = q;
        if(B < 10)
        {
            for(int i = 0; i < B; i++)
            {
                System.out.println((i+1)+"");
                arr[i] = sc.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < B; i++)
            {
                sb.append(Integer.toString(arr[i]));
                
            }
            System.out.println(sb.toString());
        }
        else if(B == 10)
        {
            int[] arr1 = new int[B];
            int[] arr2 = new int[B];
            int[] arr3 = new int[B];
            
            for(int i = 0; i < B; i++)
            {
                System.out.println((i+1)+"");
                arr[i] = sc.nextInt();
                arr1[i] = (arr[i]==0?1:0);
                arr2[B-i-1] = arr[i];
                arr3[B-i-1] = (arr[i]==0?1:0);
            }
            
            boolean first = true, sec= true, thi = true, four = true;
            int[] checkArr = new int[9];
            for(int i = 0; i < 9; i++)
            {
                System.out.println((i+1)+"");
                checkArr[i] = sc.nextInt();
                if(first && arr[i]!=checkArr[i])
                    first = false;
                if(sec && arr1[i]!=checkArr[i])
                    sec = false;
                if(thi && arr2[i]!=checkArr[i])
                    thi = false;
                if(four && arr3[i]!=checkArr[i])
                    four = false;
            }
            if(first)
            {
                prt(arr, B, sc);
            }
            else if(sec)
            {
                prt(arr1, B, sc);
            }
            else if(thi)
            {
                prt(arr2, B, sc);
            }
            else if(four)
            {
                prt(arr3, B, sc);
            }
        }
        else
        {
            int[] arr1 = new int[B];
            prt(arr1, B, sc);
        }
        
    }
    
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int B = sc.nextInt();
        for(int p = 0; p < T; p++)
        {            
            int arr[] = new int[B];
            for(int j = 0; j < B; j++)
            {
                arr[j] = -1;
            }
            System.out.println(1+"");
            arr[0] = sc.nextInt();
            //solve(sc, B, 1, arr);
            
            if(B < 10)
            {
                for(int i = 0; i < B; i++)
                {
                    System.out.println((i+1)+"");
                    arr[i] = sc.nextInt();
                }
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < B; i++)
                {
                    sb.append(Integer.toString(arr[i]));
                    
                }
                System.out.println(sb.toString());
            }
            else if(B == 10)
            {
                int[] arr1 = new int[B];
                int[] arr2 = new int[B];
                int[] arr3 = new int[B];
                
                for(int i = 0; i < B; i++)
                {
                    System.out.println((i+1)+"");
                    arr[i] = sc.nextInt();
                    arr1[i] = (arr[i]==0?1:0);
                    arr2[B-i-1] = arr[i];
                    arr3[B-i-1] = (arr[i]==0?1:0);
                }
                
                boolean first = true, sec= true, thi = true, four = true;
                int[] checkArr = new int[9];
                for(int i = 0; i < 9; i++)
                {
                    System.out.println((i+1)+"");
                    checkArr[i] = sc.nextInt();
                    if(first && arr[i]!=checkArr[i])
                        first = false;
                    if(sec && arr1[i]!=checkArr[i])
                        sec = false;
                    if(thi && arr2[i]!=checkArr[i])
                        thi = false;
                    if(four && arr3[i]!=checkArr[i])
                        four = false;
                }
                if(first)
                {
                    prt(arr, B, sc);
                }
                else if(sec)
                {
                    prt(arr1, B, sc);
                }
                else if(thi)
                {
                    prt(arr2, B, sc);
                }
                else
                {
                    prt(arr3, B, sc);
                }
            }
            else
            {
                int[] arr1 = new int[B];
                prt(arr1, B, sc);
            }
            
            sc.nextLine();
            String strs = sc.nextLine();
            if(strs.charAt(0)=='N')
                break;
        }
        
    }
    
}
