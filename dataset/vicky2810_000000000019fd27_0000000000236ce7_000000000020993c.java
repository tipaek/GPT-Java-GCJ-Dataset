import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){
                int n=Integer.parseInt(br.readLine());
                int[][] arr=new int[n][n];
                int trace=0;
                for(int j=0;j<n;j++) {
                    String[] str = br.readLine().split(" ");
                    for(int k=0;k<n;k++){
                        arr[j][k]=Integer.parseInt(str[k]);
                        if(j==k){
                            trace+=arr[j][k];
                        }
                    }
                }
                int r=0;
                for(int j=0;j<n;j++){
                    HashSet<Integer> set=new HashSet<>();
                    for(int k=0;k<n;k++){
                        if(set.contains(arr[j][k])){
                            r++;
                            break;
                        }
                        set.add(arr[j][k]);
                    }
                }
                int c=0;
                for(int j=0;j<n;j++){
                    HashSet<Integer> set=new HashSet<>();
                    for(int k=0;k<n;k++){
                        if(set.contains(arr[k][j])){
                            c++;
                            break;
                        }
                        set.add(arr[k][j]);
                    }
                }
                System.out.println("case #"+(i+1)+": "+trace+" "+r+" "+c);


            }
        }catch(Exception e){
            System.out.println("kkkk "+e.getMessage());
        }
    }
}
