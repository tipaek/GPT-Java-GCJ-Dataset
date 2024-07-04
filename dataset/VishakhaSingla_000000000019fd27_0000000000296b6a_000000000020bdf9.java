import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        for(int i = 0; i<t; i++)
        {
            int n = sc.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];
            int max = Integer.MIN_VALUE;
            for(int j = 0; j<n ; j++)
            {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
                if( end[j] > max )
                max = end[j];
            }
            int arr[] = new int[max+1];
            for(int j = 0; j<=max ; j++)
            {
                arr[j] = 0;
            }
            for(int j = 0; j<n ; j++)
            {
                arr[start[j]]++;
                arr[end[j]]--;
            }
            int prev = 0,flag = 0;
            String s="", turn="C";
            for(int j = 0; j<=max; j++)
            {
                //flag = 0;
                arr[j] = prev + arr[j];
                // if(arr[j] != prev)
                // flag = 1;
                prev = arr[j];
                if(arr[j] > 2)
                {
                    s="";
                    flag=1;
                    break;
                }
                // else if(flag == 1)
                // {
                //     if(arr[j] == 1)
                //     s = s + turn;
                //     else if(arr[j] == 2)
                //     {
                //         turn = turn.equals("C") ? "J" : "C";
                //         s = s + turn;
                //     }
                // }
            }
            if(flag==1)
            {
            int mat[][]=new int[2][2];
            mat[0][0]=start[0];
            mat[0][1]=end[0];
            for(int j = 1; j<n; j++)
            {
                if((start[j]<=mat[0][0] && end[j]<=mat[0][0])||(start[j]>=mat[0][1] && end[j]>=mat[0][1]))
                {
                    mat[1][0]=start[j];
                    mat[1][1]=end[j];
                    s=s+"J";
                }
                else
                {
                    mat[0][0]=start[j];
                    mat[0][1]=end[j];
                    s=s+"J";
                }
            }
            }
            if(s.equals(""))
            System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else
            System.out.println("Case #"+(i+1)+": "+s);
            
            
        }
    }
}


// #include<stdio.h>
// #include<stdlib.h>
// struct activities
// {
//     int start;
//     int end;
    
// }
// int cmp(const void *a,const void *b)
// {
//     return ((struct activities*)a->start)-((struct activities*)b->start);
// }
// int main()
// {
//     int t;
//     int i;
//     for(i=0;i<t;i++)
//     {
//         int n;
//         scanf("%d",&n);
//         struct activities *arr=(struct activities*)malloc(sizeof(activities)*n);
//         int j;
//         for(j=0;j<n;j++)
//         {
//             scanf("%d",&arr[j]->start);
//             scanf("%d",&arr[j]->end);
//         }
//         //qsort(arr,n,sizeof(struct activities),cmp);
//     }
// }