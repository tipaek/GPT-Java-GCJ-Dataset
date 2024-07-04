import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution{
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException  
    { 


		// PrintWriter out = new PrintWriter(new BufferedWriter(
	 //                                  new OutputStreamWriter(System.out)));
	  
		int tests=Integer.parseInt(br.readLine());
		for (int t=0;t<tests;t++){
			func(t);
	}
}

	public static void func(int t) throws IOException{
		int number=Integer.parseInt(br.readLine());
		int activities[][]=new int[number][2];
		for (int n=0;n<number;n++){
			StringTokenizer tk = new StringTokenizer(br.readLine());
			activities[n][0]=Integer.parseInt(tk.nextToken());
			activities[n][1]=Integer.parseInt(tk.nextToken());
		}
		String ans[]=new String[number];
		int j[][]=new int[number][2];
		int c[][]=new int[number][2];
		int inj=0;
		int inc=0;
		for (int i=0;i<number;i++){
			if (check(activities[i],j)==false){
				if (check(activities[i],c)==false){
					System.out.printf("Case #%d: IMPOSSIBLE\n",t+1);
					return;
				}else{
					c[inc]=activities[i];
					inc+=1;
					ans[i]="C";
				}
			}else{
				j[inj]=activities[i];
				inj+=1;
				ans[i]="J";
			}
		}
		System.out.printf("Case #%d: ",t+1);
		for (int y=0;y<ans.length;y++){
			System.out.print(ans[y]);
		}
		System.out.println();
	}
	
	public static boolean check(int task[],int person[][]){
		boolean flag=true;
		for (int i=0;i<person.length;i++){
			if (task[0]<person[i][0]){
				if (task[1]>person[i][0]){
					return false;
				}
			}else{
				if (task[0]>=person[i][1]){

				}else{
					return false;
				}
			}
		}
		return true;
	}
}