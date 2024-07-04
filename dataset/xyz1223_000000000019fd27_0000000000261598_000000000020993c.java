import java.util.*;
public class Solution{
public static void main (String[] args) 
	{
	  Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();int r=0; int c=0;int sum=0;
            int arr[][]= new int[n][n];
            for(int j=0;j<n;j++){
                HashMap<Integer,Integer> hm = new HashMap<>();
                int count=0;
                for(int k=0;k<n; k++){
                    arr[j][k]=s.nextInt();
                    if(hm.containsKey(arr[j][k])){
                      count++;
                    }
                    else{
                        hm.put(arr[j][k],1);
                    }
                    if(j==k){
                        sum += arr[j][k];
                    }
                }
                if(count>0)
                r++;
            }
            if(sum%n == 0){
                r=0; c=0;
            }else{
                
            
             for(int j=0;j<n;j++){
                HashMap<Integer,Integer> hm = new HashMap<>();
                int count=0;
                for(int k=0;k<n; k++){
                    if(hm.containsKey(arr[k][j])){
                      count++;
                    }
                    else{
                        hm.put(arr[k][j],1);
                    }
                }
                if(count>0){
                    c++;
                }
             }  
            }
        System.out.println("Case #"+ i+ ": " + sum + " "+ r + " "+ c);
	}
}
}