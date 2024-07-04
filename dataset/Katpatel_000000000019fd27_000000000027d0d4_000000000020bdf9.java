import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int t=1;t<=testcase;t++){
            StringBuilder sb = new StringBuilder("");
            int C=-1;
            int J=-1;
            int n=sc.nextInt();
            ArrayList<Node> list = new ArrayList();
            ArrayList<Node> _list = new ArrayList();
            for(int i=0;i<n;i++){
            	Node node = new Node(sc.nextInt(),sc.nextInt());
            	list.add(node);
            	_list.add(node);
            }
            Collections.sort(list,(a,b) -> (a.s==b.s)? (a.e-b.e):(a.s-b.s));
            boolean flag=true;
            for(Node node:list){
            	if(node.s>=C){
            		node.ass="C";
            		C=node.e;
            	}
            	else if(node.s>=J){
            		node.ass="J";
            		J=node.e;
            	}
            	else{
            		flag=false;
            		sb = new StringBuilder("IMPOSSIBLE");
            		break;
            	}
            }
            if(flag){
            	for(Node node:_list) sb.append(node.ass);
            }
            System.out.println("Case #"+t+": "+sb.toString());
        }
    }
}

class Node{
	int s;
	int e;
	String ass;
	Node(int s, int e){
		this.s=s;
		this.e=e;
	}
}
