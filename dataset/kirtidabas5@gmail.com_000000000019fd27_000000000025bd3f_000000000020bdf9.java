
import java.util.*;
class node implements Comparable<node>{
	int strt,end,idx;
	node(int strt,int end,int idx){
		this.idx=idx;
		this.strt=strt;
		this.end=end;
	}
	@Override
	public int compareTo(node o) {
		if(this.strt<o.strt ||(this.strt==o.strt && this.end<o.end))
			return -1;
		else if(this.strt>o.strt ||(this.strt==o.strt && this.end>o.end))
			return 1;
		else
			return 0;
	}
	
}
 class Solution{
	
	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		scn.nextLine();
		int Case=0;
		while(t-->0) {
			int n=scn.nextInt();
			char[]ans=new char[n];
			boolean imp=false;
			node[]arr=new node[n];
			for(int i=0;i<n;i++) {
				int strt=scn.nextInt();
				int end=scn.nextInt();
				node nn=new node(strt,end,i);
				arr[i]=nn;
			}
			
			Arrays.sort(arr);
			int endc=-1,endj=-1;
			for(int i=0;i<n;i++) {
				node nn=arr[i];
				if(nn.strt>=endc) {
					endc=nn.end;
					ans[nn.idx]='C';
				}else if(nn.strt>=endj) {
					endj=nn.end;
					ans[nn.idx]='J';
				}else {
					imp=true;
					break;
				}
			}
			
			Case++; 
			System.out.print("Case #"+Case+": ");
			if(imp) {
				System.out.println("IMPOSSIBLE");
			}else {
			for(int i=0;i<n;i++) {
				System.out.print(ans[i]);
			}
			System.out.println();
			}
			}
	}

}
