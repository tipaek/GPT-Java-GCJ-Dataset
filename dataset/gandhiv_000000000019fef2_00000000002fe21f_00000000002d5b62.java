import java.util.*;
import java.lang.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		for(int i1=1;i1<=n1;i1++){
		    int[][] a = new int[9][9];
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    int x1 = Math.abs(x);
		    int y1 = Math.abs(y);
		    String res = "";
		    System.out.print("Case #"+i1+": ");
		    if((x1+y1)%2==0)
		        System.out.println("IMPOSSIBLE");
		    else{
		        if(x1==1 && y1==0)
		            res+="E";
		        if(x1==0 && y1==1)
		            res+="N";
		        if(x1==2 && y1==1)
		            res+="NE";
		        if(x1==1 && y1==2)
		            res+="EN";
		        if(x1==3 && y1==0)
		            res+="EE";
		        if(x1==0 && y1==3)
		            res+="NN";
		        if(x1==2 && y1==3)
		            res+="SEN";
		        if(x1==3 && y1==2)
		            res+="WNE";
		        if(x1==4 && y1==1)
		            res+="SNE";
		        if(x1==1 && y1==4)
		            res+="WEN";
		        if(x1==3 && y1==4)
		            res+="NNE";
		        if(x1==4 && y1==1)
		            res+="EEN";
		        if(x1!=x){
		            res = res.replaceAll("W","e");
		            res = res.replaceAll("E","w");
		            res = res.toUpperCase();
		        }
		        if(y1!=y){
		            res = res.replaceAll("N","s");
		            res = res.replaceAll("S","n");
		            res = res.toUpperCase();
		        }
		        System.out.println(res);
		    }
		}
	}
}
