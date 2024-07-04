import java.util.*;
class Solution{
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    for(int in=0;in<t;in++){
        int n=sc.nextInt();
        int[][]arr = new int[n][n];
        int trace=0;
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
        arr[i][j]=sc.nextInt();
        if(i==j)trace+=arr[i][j];
        }
        
        int r=0,c=0;
        for(int i=0;i<n;i++){
            ArrayList<Integer>al= new ArrayList();
            for(int j=0;j<n;j++){
                if(al.contains(arr[i][j])){r++;break;}
                else al.add(arr[i][j]);
            }
        }
        
        for(int i=0;i<n;i++){
            ArrayList<Integer>al = new ArrayList();
            for(int j=0;j<n;j++){
                if(al.contains(arr[j][i])){c++;break;}
                else al.add(arr[j][i]);
            }
        }
        System.out.println("Case #"+(in+1)+": "+trace+" "+r+" "+c);
    }
}
}