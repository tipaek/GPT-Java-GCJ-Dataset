import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int ar[][] = new int[N][2];
            for(int i=0; i<N; i++){
            	ar[i][0] = sc.nextInt();
            	ar[i][1] = sc.nextInt();
            }
            int endTimeC = 0;
            int endTimeJ = 0;
            String solnStr = "";
            int flag = 0;
            for(int i=0; i<N; i++){
            	if(i==0){
            		solnStr+="C";
            		endTimeC = ar[i][1];
            	}
            	else{
            		int x = ar[i][0];
            		if(x>=endTimeC){
            			solnStr+="C";
            			endTimeC = ar[i][1];
            		}
            		else if(x>=endTimeJ){
            			solnStr+="J";
            			endTimeJ = ar[i][1];
            		}
            		else{
            			flag=1;
            		}
            	}
            }
            if(flag==0){
            	System.out.println("Case #"+(t+1)+": "+ solnStr);
            } else{
            	System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            }
        }

	}
}