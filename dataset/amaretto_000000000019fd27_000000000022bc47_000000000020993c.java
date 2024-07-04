import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int test=1; test<=t; test++){
        int n = s.nextInt();
        int arr[][] = new int[n][n];
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=s.nextInt();
                if(i==j){
                    sum+=arr[i][j];
                }
            }
        }
        int a1=0;
        int a2=0;
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            boolean ret=false;
            for(int j=0; j<n; j++){
                if(set.contains(arr[i][j])){
                    ret=true;
                    a1++;
                    break;
                }else{
                    set.add(arr[i][j]);
                }
            }
        }
        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            boolean ret=false;
            for(int j=0; j<n; j++){
                if(set.contains(arr[j][i])){
                    ret=true;
                    a2++;
                    break;
                }else{
                    set.add(arr[j][i]);
                }
            }
        }
        System.out.println("Case #"+test+": "+sum+" "+a1+" "+a2);
        }
    }
}