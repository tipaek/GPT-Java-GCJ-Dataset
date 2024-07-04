import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

class Practice2 {

	static class Interval
	{
		int s;
		int t;
		char ch;
		public char getChar()
		{
			return ch;
		}
		public void setChar(char ch)
		{
			this.ch = ch;
		}
	}
	
	static class IntervalComparator implements Comparator<Interval>
	{
		public int compare(Interval i1, Interval i2)
		{
			return i1.s-i2.s;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	
        for(int x=0; x<t; x++)
        {
        	int n = Integer.parseInt(br.readLine());
        	ArrayList<Interval> list = new ArrayList<Interval>();
        	LinkedHashMap<Interval, Character> map = new LinkedHashMap<>();
        	for(int i=0; i<n; i++)
        	{
        		String in[] = br.readLine().split(" ");
        		Interval interval = new Interval();
        		interval.s = Integer.parseInt(in[0]);
        		interval.t = Integer.parseInt(in[1]);
        		list.add(interval);
        		map.put(interval, null);
        	}
        	
        	Collections.sort(list, new IntervalComparator());
        	
        	int JS=0, JT=0, CS=0, CT=0; 
        	boolean f = true;
        	boolean f1 = true;
        	boolean f2 = true;
        	Iterator it = list.iterator();
        	while(it.hasNext())
        	{
        		Interval interval = (Interval)it.next();
        		if(interval.s >= CT)
        		{
        			CT = interval.t;
        			interval.setChar('C');
        			
        			map.replace(interval, interval.getChar());
        			f1 = false;
        			
        		}
        		if(interval.s >= JT && f1 == true)
        		{
        			JT = interval.t;
        			interval.setChar('J');
        			map.replace(interval, interval.getChar());
        			f2 = false;
        			
        		}
        		if(f1 == true && f2 == true)
        		{	
        			int x1 = x+1;
        			System.out.print("Case #" + x1 +": ");
        			System.out.println("IMPOSSIBLE");
        			f = false;
        			break;
        		}
        		f1 = true;
        		f2 = true;
        		/*
        		
        		System.out.print(interval.s + " ");
        		System.out.println(interval.t);
        		*/
        	}
        	if(f == true)
        	{	
	        	Iterator it1 = map.entrySet().iterator();
	        	int x1 = x+1;
	        	System.out.print("Case #" + x1 +": ");
	        	while(it1.hasNext())
	        	{
	        		Map.Entry mapElement = (Map.Entry)it1.next();
	        		System.out.print((char)mapElement.getValue());
	        		//System.out.println(((Interval)mapElement.getKey()).s + " "+ ((Interval)mapElement.getKey()).t + " "+(char)mapElement.getValue());
	        	}
        	}
        	System.out.println("");
        	f=true;
        	list = null;
        	map = null;
        	
        	
        }
	}

}
