
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Main{
	public static  void  main(String[] args){
	int n;
	Scanner scanner=new Scanner(System.in);
	n=scanner.nextInt();
	int countc=0;
	int countr=0;
	HashMap<Integer,Integer> c=new HashMap<>();
	for(int i=0;i<n;i++){
		int trace=0;
		int s=scanner.nextInt();
		ArrayList<sol> col=new ArrayList<>();
		for(int j=0;j<s;j++){
			col.add(new sol());
		}
		int[][] a=new int[s][s];
		for(int j=0;j<s;j++){
			int r=0;
			HashMap<Integer,Integer> row=new HashMap<>();
			for(int k=0;k<s;k++){

				a[j][k]=scanner.nextInt();
				if(k==j){
					trace=trace+a[j][k];
				}
				if(col.get(k).a.get(a[j][k])==null){
					col.get(k).a.put(a[j][k],1);
				}
				else {
					if(col.get(k).c==0){
						col.get(k).c++;
						countc++;
					}
				}
				if(row.get(a[j][k])==null){
					row.put(a[j][k],1);
				}
				else{
					if(r==0) {
						r++;
						countr++;
					}
				}
			}
		}
		System.out.println("Case #"+(i+1)+": "+trace+" "+countr +" "+countc);
countc=0;
countr=0;
	}
	}
}
class sol{
	HashMap<Integer,Integer> a=new HashMap<>();
	int c=0;
}