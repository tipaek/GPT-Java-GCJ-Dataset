import java.util.*;

public class Solution {

	public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override
          public int compare(final int[] entry1,  
                             final int[] entry2) { 

            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        for(int t=0; t<T; t++){
            int N = sc.nextInt();
            int ar[][] = new int[N][2];
            ArrayList<Integer> ma = new ArrayList<Integer>(N);
            for(int i=0; i<N; i++){
            	ar[i][0] = sc.nextInt();
            	ma.add(ar[i][0]);
            	ar[i][1] = sc.nextInt();
            }
            sortbyColumn(ar,0);
            int endTimeC = 0;
            int endTimeJ = 0;
            int solnStr[] = new int[N];
            int flag = 0;
            for(int i=0; i<N; i++){
            	if(i==0){
            		solnStr[i] = 0;
            		endTimeC = ar[i][1];
            	}
            	else{
            		int x = ar[i][0];
            		if(x>=endTimeC){
            			solnStr[i] = 0;
            			endTimeC = ar[i][1];
            		}
            		else if(x>=endTimeJ){
            			solnStr[i] = 1;
            			endTimeJ = ar[i][1];
            		}
            		else{
            			flag=1;
            		}
            	}
            }
            String ans = "";
            int x[][] = new int[N][2];
            for(int i=0; i<solnStr.length; i++){
            	x[i][0] = ar[i][0];
            	x[i][1] = solnStr[i];
            }
            String res[] = new String[N];
            for(int i=0; i<x.length; i++){
            	int ind = ma.indexOf(x[i][0]);
            	if(x[i][1] == 0)
            		res[ind] = "C";
            	else
            		res[ind] = "J";
            }
            for(int i=0; i<res.length; i++){
            	ans += res[i];
            }
            if(flag==0){
            	System.out.println("Case #"+(t+1)+": "+ ans);
            } else{
            	System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            }
        }

	}
}