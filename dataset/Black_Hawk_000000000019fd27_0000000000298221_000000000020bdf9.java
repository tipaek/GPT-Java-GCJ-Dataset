
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Abc {

	int index;
	int SE;
	int EE;
	char c;
}


class sortBySE implements Comparator<Abc> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Abc a, Abc b) 
    { 
        return a.SE-b.SE;
    } 
} 
  
class sortByEE implements Comparator<Abc> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Abc a, Abc b) 
    { 
        return a.EE-b.EE;
    } 
} 

public class Solution {

	Abc[] arr;
	int n;

	public Solution(int n) {
		this.n=n;
		arr=new Abc[n];
	}


	void taskProvider()
	{
		boolean C=false,J=false;
		boolean possible=true;
		int t1=0, t2=0, i=0;
		while(possible && i<n)
		{
			if(t1<=arr[i].SE)
			{
				C=false;
			}

			if(t2<=arr[i].SE)
			{
				J=false;
			}


			if(!C)
			{
				arr[i].c='C';
				t1=arr[i].EE;
				C=true;

			}
			else if(!J)
			{
				arr[i].c='J';
				t2=arr[i].EE;
				J=true;
			}
			else
			{
				possible=false;
			}	


			i++;
		}

		if(possible)
		{ 
			quickSort(arr,0,n-1);
			for(i=0;i<n;i++)
			{
				System.out.print(arr[i].c);
			}
		}
		else
		{
			System.out.print("IMPOSSIBLE");
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

		int t=0, n=0, i=0;

		t=Integer.parseInt(in.readLine().trim());
		Solution[] lm= new Solution[t];
		for(int p=0 ; p<t ; p++)
		{
			n=Integer.parseInt(in.readLine().trim());
			lm[p]=new Solution(n);

			for(i=0;i<n;i++)
			{
				String s[]=(in.readLine().trim()).split(" ");
				lm[p].arr[i]=new Abc();
				lm[p].arr[i].index=i;
				lm[p].arr[i].SE=Integer.parseInt(s[0]);
				lm[p].arr[i].EE=Integer.parseInt(s[1]);
			}

			Arrays.sort(lm[p].arr, new sortByEE()); 
			Arrays.sort(lm[p].arr, new sortBySE());


		}


		for(i=0;i<t;i++)
		{
			System.out.print("Case #"+(i+1)+": ");
			lm[i].taskProvider();
			System.out.println();
		}
	}

	void display()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i].index+"    "+arr[i].c+"   "+arr[i].EE);
		}
	}

	void quickSort(Abc s[],int start, int end)
	{
		int i=start +1;
		int j= end;

		while(i<=j)
		{
			if(s[i].index<=s[start].index)
			{
				i++;
			}
			else if(s[j].index>s[start].index)
			{
				j--;
			}
			else
			{
				Collections.swap(Arrays.asList(s), i, j);
			}
		}
		Collections.swap(Arrays.asList(s),start, j);


		if(start<j-1)

			quickSort(s,start,j-1);

		if(j+1<end)
			quickSort(s,j+1,end);

	}

}
