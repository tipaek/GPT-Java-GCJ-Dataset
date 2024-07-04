import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=1;i<=test;i++)
        {
             int size=sc.nextInt();
             int r=0;
             int c=0;
             int sum=0;
             int arr[][]=new int[size][size];
             int brr[][]=new int[size][size];
             for(int j=0;j<size;j++)
             {
                 for(int k=0;k<size;k++)
                 {
                     arr[j][k]=sc.nextInt();
                 }
             }
             for(int j=0;j<size;j++)
             {
                 int count=0;
                 ArrayList<Integer>al=new ArrayList<>();
                 for(int k=0;k<size;k++)
                 {
                     if(al.contains(arr[j][k])){
                         al.add(k);
                     count++;}
                     else
                         al.add(arr[j][k]);
                 }
                 if(count>0)
                     r++;
                 al.clear();
             }
             for(int j=0;j<size;j++)
             {
                 for(int k=0;k<size;k++)
                 {
                     brr[j][k]=arr[k][j];
                 }
             }
             for(int j=0;j<size;j++)
             {
                 int count=0;
                 ArrayList<Integer>al=new ArrayList<>();
                 for(int k=0;k<size;k++)
                 {
                     if(al.contains(brr[j][k])){
                         al.add(k);
                     count++;}
                     else
                         al.add(brr[j][k]);
                 }
                 if(count>0)
                     c++;
                 al.clear();
             }
             for(int j=0;j<size;j++)
             {
                 for(int k=0;k<size;k++)
                 {
                     if(j==k)
                         sum=sum+arr[j][k];
                 }
             }
             System.out.println("Case #"+i+""+":"+" "+sum+" "+r+" "+c);
             
             
             
        }
    }
    
}