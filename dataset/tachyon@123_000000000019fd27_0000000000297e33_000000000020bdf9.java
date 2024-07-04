import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() {   
          @Override              
          public int compare(final int[] entry1,final int[] entry2) { 
        	  if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        }); 
    } 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test = sc.nextInt();
		for(int t=0; t<test; t++){
			int n=sc.nextInt();
			sc.nextLine();
			int[][] m=new int[n][2];
			int [][]act=new int[n][2];
			for (int i=0;i<n;i++){
				//System.out.println("row "+i+"=");
				String[] s=sc.nextLine().split(" ");
				for (int j1=0;j1<2;j1++){
					m[i][j1]=Integer.parseInt(s[j1]);
					act[i][j1]=Integer.parseInt(s[j1]);
				}
			}
			
			sortbyColumn(m, 0);
			 
			
			
			String resTmp="C";
			int c=m[0][1],j=0;
			for (int i=1;i<n;i++){
				if(c<=m[i][0]){
						resTmp+="C";
						c=m[i][1];
						continue;
				}
				else if(j<=m[i][0]){
					resTmp+="J";
					j=m[i][1];
				}
				else{
					resTmp="IMPOSSIBLE";
					break;
				}
			}
			String res="";
			if(resTmp.equalsIgnoreCase("IMPOSSIBLE")){
				res=resTmp;
			}
			else{
				for (int i = 0; i < n; i++) { 
					for (int d = 0; d < n; d++) { 
						if(Arrays.equals(act[i], m[d])){
							m[d]=new int[2];
							res+=resTmp.charAt(d);
							break;
						}   
			        }
			           
		        }
				
			}
			
			
			//System.out.println("Case #"+(t+1)+": "+resTmp);
			System.out.println("Case #"+(t+1)+": "+res);

			
		}
		
	}

}
