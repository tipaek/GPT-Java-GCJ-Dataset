import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner kb=new Scanner(System.in);
		int a=kb.nextInt();
		for(int q=0;q<a;q++){
		    int b=kb.nextInt();
		    int[][] arr=new int[b][b];
		    for(int i=0;i<b;i++){
		        for (int j=0;j<b;j++){
		            arr[i][j]=kb.nextInt();
		        }
		   }
		   int k=0;
		   for(int i=0;i<b;i++){
		       k=k+arr[i][i];
		   }
		   int r=0;
		   ac:
		   for(int i=0;i<b;i++){
		       for(int g=0;g<b;g++){
		       for(int j=g+1;j<b;j++){
		           if(arr[i][g]==arr[i][j]){
		               r++;
		               continue ac;
		           }
		       }
		     }
		   }
		   int c=0;
		     bc:
		   for(int i=0;i<b;i++){
		       for(int g=0;g<b;g++){
		       for(int j=g+1;j<b;j++){
		           if(arr[g][i]==arr[j][i]){
		               c++;
		               continue bc;
		           }
		       }
		       }
		   }
		   System.out.println(k);
		   System.out.println(r);
		   System.out.println(c);
		   
		}
	}
}