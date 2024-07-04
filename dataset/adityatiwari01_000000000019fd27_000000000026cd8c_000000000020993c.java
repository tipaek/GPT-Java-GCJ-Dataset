import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Solution{  
 public static void main(String args[]) {
	 Scanner sc = new Scanner(System.in);
     if(sc.hasNext()){
         int T = sc.nextInt();
         for(int i=0;i<T;i++){
             int N = sc.nextInt();
             int arr[][] = new int[N][N];
             int S = 0;
             for(int j=0;j<N;j++){
                    for(int k=0;k<N;k++){
                        arr[j][k] = sc.nextInt();
                        if(k==j)
                            S=S+arr[j][k];
                        
                }
             }
             int c1=0,c2=0;
             System.out.print("Case #"+(i+1)+": "+S+" ");
             for(int j=0;j<N;j++){
    	        Set<Integer> s1 = new HashSet<>();
    	        Set<Integer> s2 = new HashSet<>();
    	        for(int k=0;k<N;k++){
    	            s1.add(arr[j][k]);
    	            s2.add(arr[k][j]);
    	        }
    	        if(s1.size()<N)
    	    	    ++c1;
    	    	if(s2.size()<N)
    	    	    ++c2;
    	    }
             System.out.println(c1+" "+c2);
     	}
 	}
  }
}