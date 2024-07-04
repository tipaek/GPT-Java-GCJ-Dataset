import java.util.*;
class Solution{
    static int rowcount(int[][] arr,int n){
        int count=0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> st=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(st.add(arr[i][j])==false){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    static int ccount(int[][] arr,int n){
        int count=0;
        for(int i=0;i<n;i++)
        {
            Set<Integer> st=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(st.add(arr[j][i])==false){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=1;
        while(c<=t){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                    trace+=arr[i][j];
                }
            }
            int rc=rowcount(arr,n);
            int cc=ccount(arr,n);
            System.out.println("Case #"+c+": "+trace+" "+rc+" "+cc);
            c++;
        }
    }
}