import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
	
	public static void main(String[] args) throws Exception {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.valueOf(br.readLine());
	
	for(int tada=1; tada<=t;tada++)
	{
		
		int n=Integer.valueOf(br.readLine());
		ArrayList<Tasks> list=new ArrayList<Tasks>();
		for(int i=0;i<n;i++)
		{
			String data[]=br.readLine().split(" ");
			Tasks tk=new Tasks(i,Integer.valueOf(data[0]) , Integer.valueOf(data[1]));
			list.add(tk);
		}
		
		
		Collections.sort(list);
	ArrayList<Tasks> Cameron =new ArrayList<Tasks>();
	ArrayList<Tasks> Jamie =new ArrayList<Tasks>();
	boolean imposible=false;
	for(Tasks currentTask:list)
	{
		if(Cameron.size()==0)
		{
			Cameron.add(currentTask);
			currentTask.setAssignedTo('C');
			continue;
		}
		
		if(!(Cameron.get(Cameron.size()-1).doesOverLap(currentTask)))
		{
			Cameron.add(currentTask);
			currentTask.setAssignedTo('C');
			continue;
		}
		
		if(Jamie.size()==0)
		{
			Jamie.add(currentTask);
			currentTask.setAssignedTo('J');
			continue;
		}
		
		if(!(Jamie.get(Jamie.size()-1).doesOverLap(currentTask)))
		{
			Jamie.add(currentTask);
			currentTask.setAssignedTo('J');
			continue;
		}
		
		
		imposible=true;
		
	}
	
	System.out.print("Case #"+tada+": ");
	if(imposible) {
		
		System.out.print("IMPOSSIBLE");
		
	}
	else
	{
		Collections.sort(list,new idComparator());
		
		for(Tasks currentTask:list)
		{
			System.out.print(currentTask.getAssignedTo());
			
		}
		
	}
	System.out.println();
	
	
	}
	}
}

class Tasks implements Comparable<Tasks>{
	private int id;
	private int startTime;
	private int endTime;
	private char assignedTo;
	public Tasks(int id, int startTime, int endTime) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public char getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(char assignedTo) {
		this.assignedTo = assignedTo;
	}
	@Override
	public int compareTo(Tasks taskOther) {
		
		return this.startTime-taskOther.startTime;
	}
	
	//Will only work if sorted by startTime
	public boolean doesOverLap(Tasks taskOther)
	{
		if(this.getEndTime()>taskOther.getStartTime())
			return true;
		
		return false;
	}
	
	
}

class idComparator implements Comparator<Tasks>{

	@Override
	public int compare(Tasks arg0, Tasks arg1) {
		// TODO Auto-generated method stub
		return arg0.getId()-arg1.getId();
	}
	
}
