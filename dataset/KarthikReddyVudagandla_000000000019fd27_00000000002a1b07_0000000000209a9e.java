import java.util.*;

public class Solution {
    
    public static void prt(int[] arr,int B)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < B; i++)
        {
            sb.append(Integer.toString(arr[i]));

        }
        System.out.println(sb.toString());
        Scanner sc1=new Scanner(System.in);
        //sc1.nextLine();
        //sc1.nextLine();
    }
    
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        //int T = sc.nextInt();
        //int B = sc.nextInt();
        
        String line = sc.nextLine();
        String[] sarr=line.split(" ");
        int T= Integer.parseInt(sarr[0]);
        int B=Integer.parseInt(sarr[1]);
        
        for(int x = 0; x < T; x++)
        {            
            int arr[] = new int[B];
            for(int j = 0; j < B; j++)
            {
                arr[j] = -1;
            }
            System.out.println(1+"");
            arr[0] = sc.nextInt();
            //solve(sc, B, 1, arr);
            //int count = 1;
            
            if(B <= 9)
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
                
                Boolean first = true, sec= true, thi = true, four = true;
                int[] checkArr = new int[5];
                for(int i = 0; i < 5; i++)
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
                    prt(arr, B);
                }
                else if(sec)
                {
                    prt(arr1, B);
                }
                else if(thi)
                {
                    prt(arr2, B);
                }
                else if(four)
                {
                    prt(arr3, B);
                }
            }
            else
            {
                int[] arr1 = new int[B];
                prt(arr1, B);
            }
            
        }
        
    }
    
}