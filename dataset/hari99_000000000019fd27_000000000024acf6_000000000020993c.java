import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> answers=new ArrayList<>();
        int tests=sc.nextInt();
        for(int t=0;t<tests;t++){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j){
                        trace+=arr[i][j];
                    }
                }
            }
        int rows=0;
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<n;j++){
                set.add(arr[i][j]);
            }
            if(set.size()!=n)
            rows++;
        }   
        
        int cols=0;
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<n;j++){
                set.add(arr[j][i]);
            }
            if(set.size()!=n)
            cols++;
        } 
        
        String ans=Integer.toString(trace)+" "+Integer.toString(rows)+" "+Integer.toString(cols); 
        answers.add(ans);        
        }
        for(int i=0;i<answers.size();i++){
            System.out.println("Case #"+(i+1)+": "+answers.get(i));
        }
    }
}