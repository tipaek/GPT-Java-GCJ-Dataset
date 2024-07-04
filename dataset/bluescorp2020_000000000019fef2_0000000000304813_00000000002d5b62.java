import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	private static void solve(int x, int y){
		Queue<Pos> q = new LinkedList<>();
		Pos start = new Pos(0, 0, 1, "");
		Pos end = new Pos(y, x, 0,"");
		
		q.add(start);
		int jump=1;
		while(true){
			Pos head=q.remove();
			jump=head.jump;
			if(jump>256)
				break;
			if(head.x==end.x && head.y==end.y){
				end.path=head.path;
				end.jump=jump;
				break;
			}
			Pos pN=new Pos(head);
			pN.x+=jump;
			pN.path+="N";
			pN.jump=(jump<<1);
			q.add(pN);
			
			Pos pS=new Pos(head);
			pS.x-=jump;
			pS.path+="S";
			pS.jump=(jump<<1);
			q.add(pS);
			
			Pos pE=new Pos(head);
			pE.y+=jump;
			pE.path+="E";
			pE.jump=(jump<<1);
			q.add(pE);
			
			Pos pW=new Pos(head);
			pW.y-=jump;
			pW.path+="W";
			pW.jump=(jump<<1);
			q.add(pW);
			
		}
		if(end.jump==0){
			System.out.println("IMPOSSIBLE");
		}else{
			System.out.println(end.path);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		for(int t=1;t<=n;t++){
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			System.out.print("Case #"+t+": ");
			solve(x, y);
		}
		scanner.close();
	}
}

class Pos{
	int x;
	int y;
	int jump;
	String path;
	
	public Pos(int x, int y, int jump, String path) {
		super();
		this.x = x;
		this.y = y;
		this.jump=jump;
		this.path = path;
	}
	
	public Pos(Pos p){
		super();
		this.x=p.x;
		this.y=p.y;
		this.path=p.path;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + ", jump=" + jump + ", path=" + path + "]";
	}

	
}
