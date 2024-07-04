import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int t=1;t<=testcase;t++){
            String s = sc.next();
            int max=0;
            ArrayList<Node> list = new ArrayList();
            for(int i=0;i<s.length();i++){
            	int j=i+1;
            	while(j<s.length() && s.charAt(i)==s.charAt(j))j++;
            	list.add(new Node(s.charAt(i)-'0',s.substring(i,j)));
            	max=Math.max(max, s.charAt(i)-'0');
            	i=j-1;
            }
            while(max>0){
            	ArrayList<Node> _list = new ArrayList();
            	for(int i=0;i<list.size();i++){
            		if(list.get(i).key==max){
            			list.get(i).key--;
            			list.get(i).val = "("+list.get(i).val+")";
            		}
            		if(_list.size()>0 && _list.get(_list.size()-1).key==list.get(i).key)
        				_list.get(_list.size()-1).val += list.get(i).val;
        			else _list.add(list.get(i));
            	}
            	list.clear();
            	list.addAll(_list);
//            	for(Node n:list){
//            		System.out.print(n.val + " ");
//            	}
//            	System.out.println();
            	max--;
            }
            System.out.println("Case #"+t+": "+list.get(0).val);
        }
    }
}

class Node{
	String val;
	int key;
	Node(int key, String val){
		this.key=key;
		this.val=val;
	}
}


