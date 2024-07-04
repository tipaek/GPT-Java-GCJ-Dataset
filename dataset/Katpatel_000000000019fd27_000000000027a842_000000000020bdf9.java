import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int t=1;t<=testcase;t++){
            StringBuilder sb = new StringBuilder("");
            int C=0;
            int J=0;
            int n=sc.nextInt();
            ArrayList<Node> list = new ArrayList();
            for(int i=0;i<n;i++){
            	list.add(new Node(sc.nextInt(),sc.nextInt()));
            }
            Collections.sort(list,(a,b) -> a.e-b.e);
            boolean flag=true;
            for(Node node:list){
            	if(node.s>=C){
            		sb.append("C");
            		C=node.e;
            	}
            	else if(node.s>=J){
            		sb.append("J");
            		J=node.e;
            	}
            	else{
            		flag=false;
            		sb = new StringBuilder("IMPOSSIBLE");
            		break;
            	}
            }
            System.out.println("Case #"+t+": "+sb.toString());
        }
    }
}

class Node{
	int s;
	int e;
	Node(int s, int e){
		this.s=s;
		this.e=e;
	}
}


