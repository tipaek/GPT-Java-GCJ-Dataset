/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
		    int n=in.nextInt();
		    ArrayList<points> al=new ArrayList<>();
		    for(int j=0;j<n;j++)
		    {
		        al.add(new points(in.nextInt(),in.nextInt(),j));
		    }
		    Comparator<points> comp=new Comparator<points>()
		    {
		        @Override
                public int compare(points p1,points p2) 
                {
                    if(p1.start-p2.start==0)
                    {
                        if(p1.end-p2.end==0)
                        {
                            return p1.index-p2.index;
                        }
                        else
                            return p1.end-p2.end;
                    }
                    else
                        return p1.start-p2.start;
                }
		    };
		    Collections.sort(al,comp);
		    //System.out.println(al);
		    int start,end,temp=0,j=0,k=0;
            String[] str=new String[n];
            for(int l=0;l<n;l++)
            {
                if(al.get(l).start<k && al.get(l).start<j)
                {
                    temp=1;
                    break;
                }
                else if(al.get(l).start>=k)
                {
                    str[al.get(l).index]="C";
                    k=al.get(l).end;
                }
                else
                {
                    str[al.get(l).index]="J";
                    j=al.get(l).end;
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            if(temp==1)
            {
                System.out.println("IMPOSSIBLE");
            }
            else
            {
                for(int l=0;l<n;l++)
                {
                    System.out.print(str[l]);
                }
                System.out.println("");
            }
	    }
	}
	
	public static void swap(int a,int b)
	{
	    int temp=a;
	    a=b;
	    b=temp;
	}
}

class points{
    int start,end,index;
    points(int start,int end,int index){
        this.start=start;
        this.end=end;
        this.index=index;
    }
    public String toString()
    {
        return start+" "+end+" "+index;
    }
}
