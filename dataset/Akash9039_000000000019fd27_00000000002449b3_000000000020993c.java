import java.util.Arrays;
import java.util.Scanner;
class Main{
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		int a=kb.nextInt();
		while(a>0){
                    int k=0;
		    int b=kb.nextInt();
		    int[][] arr=new int[b][b];
		    for(int i=0;i<b;i++){
		        for (int j=0;j<b;j++){
		            arr[i][j]=kb.nextInt();
                            if(i==j)
                             k=k+arr[i][i];

		        }
                        Arrays.sort(arr[i]);
                    }
		   int c=0;
		     bc:
		   for(int i=0;i<b;i++){
                       int d=0;
		       for(int j=d+1;j<b;j++){
		           if(arr[d][i]==arr[j][i]){
		               c++;
                               d++;
		               continue bc;
		           }
                           d++;
                       }
		   }
                      int r=0;
		   ac:
		   for(int i=0;i<b;i++){
                       int v=0;
		       for(int j=v+1;j<b;j++){
		           if(arr[i][v]==arr[i][j]){
		               r++;
                               v++;
		               continue ac;
		           }
                          v++;
		       }
		     }
		   System.out.println(k);
		   System.out.println(r);
		   System.out.println(c);
		   a--;
		}
	}
}