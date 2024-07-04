import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Ans{
    public static void main(String[] args) throws IOException  
    { 

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// PrintWriter out = new PrintWriter(new BufferedWriter(
 //                                  new OutputStreamWriter(System.out)));
  
	int tests=Integer.parseInt(br.readLine());
	for (int t=0;t<tests;t++){
			int n=Integer.parseInt(br.readLine());
			int reqSum=(n*(n+1))/2;
			int matrix[][]=new int[n][n];
			int trace=0;
			int sumRows=0;
			int sumColms[]=new int[n];
			int repRows=0;
			int repCols=0;
			for (int i=0;i<n;i++){
						// System.out.println("111111111111111111111111");

				StringTokenizer tk = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++){
							// System.out.println("22222222222222222222222");

					int num=Integer.parseInt(tk.nextToken());
					matrix[i][j]=num;
					sumColms[j]+=num;
					if (i==j){
						trace+=num;
					}
					// System.out.println("Adding to row "+num);
					sumRows+=num;
				}
					// System.out.println("sum row "+sumRows);

				if (sumRows!=reqSum){
					repRows+=1;
						// System.out.println("added in if"+repRows);
				
				}else{
					int checker[]=new int[n];

					for (int b=0;b<n;b++){
						if (checker[matrix[i][b]-1]>0){
							repRows+=1;
							// System.out.println("added in else"+repRows);

							break;
						}else{
							checker[matrix[i][b]-1]+=1;
						
						}
					}
				}
				sumRows=0;
			}
			for (int k=0;k<n;k++){
				if (sumColms[k]!=reqSum){
					repCols+=1;
				}else{
					int checkerr[]=new int[n];
					for (int d=0;d<n;d++){
						if (checkerr[matrix[d][k]-1]>0){
							repCols+=1;
							break;
						}else{
							checkerr[matrix[d][k]-1]+=1;
						
						}
					}
				}			}
			System.out.printf("Case #%d: %d %d %d\n",(t+1),trace,repRows,repCols);
		}
	}
}
// StringTokenizer tk = new StringTokenizer(br.readLine());
// int arr[]=new int[k];
// int max=0;
// for (int i=0;i<12;i++){
//   int n=Integer.parseInt(tk.nextToken());
// }