
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
		char p;
		
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
    	/*
    	File initialFile = new File("Nesting1.txt");
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
        	
            Comparator<Node> compareByIndex = (Node n1, Node n2) ->
            n1.index.compareTo( n2.index );
            
            Collections.sort(nodeList, compareByStart);
            
            boolean impossible=false;
            
            int overlaps=0;
            int currentOverlapIndex=0;
            boolean currentOverlapChanged=false;
            int largestEndTillCurrent=nodeList.get(0).e;
            Node largestIndexTillCurrentNode=nodeList.get(0);
            Node prevNode = nodeList.get(0);
            for(int i=1;i<nodeList.size();i++){
            	currentOverlapChanged=false;
            	Node currentNode = nodeList.get(i);
//            	Node nextNode = nodeList.get(i+1);
            	if(currentNode.e>largestEndTillCurrent){
            		
            		currentOverlapIndex=currentNode.index;
            		currentOverlapChanged=true;
            	}
            	if(currentNode.s<largestEndTillCurrent/*&&currentOverlapChanged*/){
            		overlaps++;
            		
            		if(currentNode.s<largestIndexTillCurrentNode.e)
//            			largestIndexTillCurrent=currentNode.index;
//            		prevNode.overlapIndexList.add(currentNode.index);
            		{
            		currentNode.oil.add(largestIndexTillCurrentNode.index);
            		currentNode.boi=largestIndexTillCurrentNode.index;
            		}
            		else{
            			largestIndexTillCurrentNode=currentNode;
            		}
            	}
            	else{//overlap update index to current CHECK THIS
//            		if(currentNode.s>=nodeList.get(largestIndexTillCurrent).e)
//            			largestIndexTillCurrent=currentNode.index;
            	}
            	
            	//check if same boi are overlapping with --previous?
            	if(currentNode.boi == prevNode.boi&&currentNode.boi!=-1){
            		if(currentNode.s >prevNode.s && currentNode.s<prevNode.e)
            			impossible=true;
            	}
            		
            	largestEndTillCurrent=Math.max(currentNode.e, largestEndTillCurrent);
            	prevNode=nodeList.get(i);
            }
            
//            char p[]=new char[n];
            
            nodeList.get(0).p='J';
            //start with J always
            
            boolean isCurrJ=true;
            StringBuilder ans = new StringBuilder();
            Node fillPrevNode = nodeList.get(0);
            Node fillLargestIndexTillCurrentNode=nodeList.get(0);
            for(int i=1;i<nodeList.size();i++){
            	if(impossible)
            		{
            			System.out.println("Case #"+testCase+": IMPOSSIBLE");
//            			System.out.println("nodeList:"+nodeList);
            			continue testCaseLoop;
            		}
            	Node fillCurrentNode = nodeList.get(i);
            	if(fillCurrentNode.s<fillPrevNode.e){
            		isCurrJ=!isCurrJ;
            	}
            	if(isCurrJ){
            		fillCurrentNode.p='J';
//            		ans.append("J");
            	}
            	else{
            		fillCurrentNode.p='C';
//            		ans.append("C");
            	}
//            	if(fillLargestIndexTillCurrentNode)
            	
            	fillPrevNode=fillCurrentNode;
            }
            
            Collections.sort(nodeList, compareByIndex);
            
            for(int i=0;i<nodeList.size();i++){
            	ans.append(nodeList.get(i).p);
            }
            
            System.out.println("Case #"+testCase+": "+ans);
//            System.out.println("nodeList:"+nodeList);
            	
            
        }
	}
	

}
