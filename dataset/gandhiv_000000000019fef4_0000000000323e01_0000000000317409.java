import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i1=1;i1<=t;i1++){
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    String m = sc.next();
		    int x1 = 0, y1 = 0, x2 = x, y2 = y;
		    int i;
		    boolean flag = false, f1 = y>=x;
		    for(i=0;i<m.length();i++){
		        if(x1==x2 && y1==y2){
		            flag = true;
		            break;
		        }
		        if(m.charAt(i)=='S'||m.charAt(i)=='N'){
		            y2 = (m.charAt(i)=='S')?y2-1:y2+1;
		        }
		        else {
		            x2 = (m.charAt(i)=='W')?x2-1:x2+1;
		        }
		        if(x1==x2 && y1==y2){
		            flag = true;
		            break;
		        }
		        else {
		            if(f1==true){
		                if(x1==x)
		                    f1 = !f1;
		                else    x1++;
		            }
		            else {
		                if(y1==y)
		                    f1 = !f1;
		                else    y1++;
		            }
		        }
		        if(x1==x2 && y1==y2){
		            flag = true;
		            break;
		        }
		        //System.out.println("x1:"+x1+", y1:"+y1+", x2:"+x2+", y2:"+y2);
		    }
		    System.out.print("Case #"+i1+": ");
		    if(flag==true){
		        System.out.println(i+1);
		    }
		    else    System.out.println("IMPOSSIBLE");
		}
	}
}