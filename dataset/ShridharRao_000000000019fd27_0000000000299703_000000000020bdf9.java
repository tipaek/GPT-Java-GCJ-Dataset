

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;





public class Solution {
	static class Node{
		Integer index=-1,s,e;
		ArrayList<Integer> oil=new ArrayList<>();
		char p='X';
		
		Integer boi=-1;
		public Node(int index,int s, int e) {
			super();
			this.index=index;
			this.s = s;
			this.e = e;
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}

		public int getE() {
			return e;
		}

		public void setE(int e) {
			this.e = e;
		}

		@Override
		public String toString() {
			return "Node [index=" + index +", s=" + s + ", e=" + e /*+ ", oil="+oil*/+", boi="+boi+"]";
		}
		
	}
	
	/*public static class StartComparator implements Comparator<Node> {

	    @Override
	    public int compare(Node n1, Node n2) {
	    	return (n1.s).compareTo(n2.s);
	    }
	}
	
	public static class EndComparator implements Comparator<Node> {

	    @Override
	    public int compare(Node n1, Node n2) {
	    	return (n1.e).compareTo(n2.e);
	    }
	}*/
	public static void main(String[] args) {
    	
    	/*File initialFile = new File("Parenting1.txt");
		InputStream targetStream=null;
	    try {
			targetStream = new FileInputStream(initialFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        // Scanner in = new Scanner(new BufferedReader(new InputStreamReader(targetStream)));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        testCaseLoop:
        for (int testCase = 1;  testCase<= t; ++testCase) 
        {
        	int array[][];
        	int n = in.nextInt();
        	List<Node> nodeList= new ArrayList<>();
            
        	for(int i=0;i<n;i++){
        		
        		int s=in.nextInt();
        		int e=in.nextInt();
        		nodeList.add(new Node(i,s,e));
        		
        	}
        	Comparator<Node> compareByStart = (Node n1, Node n2) ->
            n1.s.compareTo( n2.s );
        	
            Comparator<Node> compareByEnd = (Node n1, Node n2) ->
            n1.e.compareTo( n2.e );
            
//            Collections.sort(nodeList, compareByStart);
            
            boolean impossible=false;
            
            
            Node prevNode = nodeList.get(0);
            
            boolean isCurrJ=true;
            StringBuilder ans = new StringBuilder("J");
            nodeList.get(0).p='J';
            ArrayList<Node> jList=new ArrayList<>();
            jList.add(nodeList.get(0));
            ArrayList<Node> cList=new ArrayList<>();
            for(int i=1;i<nodeList.size();i++){
            	Node currentNode = nodeList.get(i);
//            	boolean overlap = isOverlap(currentNode.s, currentNode.e, prevNode.s, prevNode.e);
            	boolean jIntersectSameParent = isAnyIntersectionListOneByOne(jList,currentNode);
            	boolean cIntersectSameParent=true;
            	
            	if(!jIntersectSameParent)
            		isCurrJ=true;
            	else{
            		cIntersectSameParent = isAnyIntersectionListOneByOne(cList,currentNode);
            		if (!cIntersectSameParent)
            			isCurrJ=false;
            		}
            	if(jIntersectSameParent==true && cIntersectSameParent ==true){
            		System.out.println("Case #"+testCase+": IMPOSSIBLE");
//        			System.out.println("nodeList:"+nodeList);
        			continue testCaseLoop;
            	}
            	
            	
            	if(isCurrJ){
            		
            		jList.add(currentNode);
            		currentNode.p='J';
            		ans.append("J");
            	}
            	else{
            		
            		
            		cList.add(currentNode);
            		currentNode.p='C';
            		ans.append("C");
            	}
            		
            	prevNode=currentNode;	
            }
                     
            
            System.out.println("Case #"+testCase+": "+ans);
//            System.out.println("nodeList:"+nodeList);
            	
            
        }
        
        
	}
	
	public static boolean isOverlap(int s1,int e1,int s2,int e2){
    	
    	if((s1<s2&&e1<=s2)
    			||(s2<s1&&e2<=s1))
    			return false;
    	else
    		return true;
    	
//    	if((e2>s1&&e2<e1)||(e1>s2&&e1<e2))
//    		return true;
//    	if((s2>s1&&s2<e1)||(s1<s2&&s1<e2))
//    		return true;
//		return false;
		
    }
	
	public static boolean isAnyIntersectionListOneByOne(List<Node> jcList, Node currentNode ){
		for(Node jcNode:jcList){
			boolean overlap = isOverlap(jcNode.s, jcNode.e, currentNode.s, currentNode.e);
			if(overlap)
				return true;
		}
		return false;
	}
}
