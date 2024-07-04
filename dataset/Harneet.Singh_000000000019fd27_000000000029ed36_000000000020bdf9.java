
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		
		for (int testcase = 0; testcase < testcases; testcase++)
		{
			int n = Integer.parseInt(scan.nextLine());
			Interval1DInt intervals [] = new Interval1DInt[n];
			Interval1DInt sortedIntervals [] = new Interval1DInt[n];
			
			int arr [] [] = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				String arrString [] = scan.nextLine().split(" ");
//				arr[i][0] = Integer.parseInt(arrString[0]);
//				arr[i][1] = Integer.parseInt(arrString[1]);
				arr[i][0] = Integer.parseInt(arrString[0]) * 10 + 1;
				arr[i][1] = Integer.parseInt(arrString[1]) * 10 - 1;
				intervals[i] = new Interval1DInt(arr[i][0], arr[i][1]);
				sortedIntervals[i] = intervals[i];
			}
			
			Arrays.sort(sortedIntervals, Interval1DInt.MIN_ENDPOINT_ORDER);
			
			HashMap<Interval1DInt, String> map = new HashMap<Interval1DInt, String>(n * 2);
//			LinkedHashSet<String> set = new LinkedHashSet<>(n);
	f:		for (int i = 0; i < n; i++)
			{
				if(map.get(sortedIntervals[i]) == null)
					map.put(sortedIntervals[i], "C");
				for(int j = i + 1; j < n; j++)
				{
					if(sortedIntervals[i].intersects(sortedIntervals[j]))
					{
						if(map.get(sortedIntervals[i]) == map.get(sortedIntervals[j]))
						{
							map.put(intervals[0], "IMP");
							break f;
						}

						if (map.get(sortedIntervals[i]).equals("C"))
							map.put(sortedIntervals[j], "J");
						else
							map.put(sortedIntervals[j], "C");
					}
					else
						break;
				}
				
//				if(set.contains(arr[i][0] + " " + arr[i][1]))
//					map.put(intervals[i], "J");
//				
//				set.add(arr[i][0] + " " + arr[i][1]);
			}
			
//			for (int i = 0; i < arr.length; i++)
//			{
//				if(map.get(intervals[i]) == null)
//					map.put(intervals[i], "C");
//				
//					if(intervals[i] != interval1DInt)
//					{
//						if (map.get(interval1DInt) == null)
//							if (map.get(intervals[i]).equals("C"))
//								map.put(interval1DInt, "J");
//							else
//								map.put(interval1DInt, "C");
//						else
//						{
////							if(intervals[i].equals(interval1DInt))
////								if (map.get(intervals[i]).equals("C"))
////									map.put(interval1DInt, "J");
////								else
////									map.put(interval1DInt, "C");
////							else 
//								if (map.get(intervals[i]).equals(map.get(interval1DInt)))
//									map.put(interval1DInt, "IMP");
//						}
////						else if(map.get(interval1DInt).equals("J"))
////							map.put(interval1DInt, "IMPOSSIBLE");
//					}
//				}
//			}
			
			StringBuffer sb = new StringBuffer(n);
			for(int i = 0; i < n; i++)
			{
				if(map.get(intervals[i]) != null)
				{
					if(map.get(intervals[i]).equals("IMP"))
					{
						sb = new StringBuffer("IMPOSSIBLE");
						break;
					}
					sb.append(map.get(intervals[i]));
				}
				else
					sb.append("C");
			}
			System.out.println("Case #" + (testcase + 1) + ": " + sb);
			System.out.flush();
		}
		
		scan.close();
	}
	
	static class Interval1DInt
    {
		/**
		 * Compares two intervals by min endpoint.
		 */
		public static final Comparator<Interval1DInt> MIN_ENDPOINT_ORDER = new MinEndpointComparator();

    	public final int min;
    	public final int max;
    	
    	public Interval1DInt(int min, int max)
    	{
			this.min = min;
			this.max = max;
    	}
    	
    	/**
    	 * Returns the left endpoint of this interval.
    	 *
    	 * @return the left endpoint of this interval
    	 * @deprecated Replaced by {@link #min()}.
    	 */
    	@Deprecated
    	public double left()
    	{
    		return min;
    	}
    	
    	/**
    	 * Returns the right endpoint of this interval.
    	 * 
    	 * @return the right endpoint of this interval
    	 * @deprecated Replaced by {@link #max()}.
    	 */
    	@Deprecated
    	public double right()
    	{
    		return max;
    	}
    	
    	/**
    	 * Returns the min endpoint of this interval.
    	 *
    	 * @return the min endpoint of this interval
    	 */
    	public double min()
    	{
    		return min;
    	}
    	
    	/**
    	 * Returns the max endpoint of this interval.
    	 *
    	 * @return the max endpoint of this interval
    	 */
    	public double max()
    	{
    		return max;
    	}
    	
    	/**
    	 * Returns true if this interval intersects the specified interval.
    	 *
    	 * @param that
    	 *            the other interval
    	 * @return {@code true} if this interval intersects the argument interval;
    	 *         {@code false} otherwise
    	 */
    	public boolean intersects(Interval1DInt that)
    	{
    		if (this.max < that.min)
    			return false;
    		if (that.max < this.min)
    			return false;
//    		if (this.max == that.min || this.min == that.max)
//    			return false;
    		return true;
    	}
    	
    	/**
    	 * Returns true if this interval contains the specified value.
    	 *
    	 * @param x
    	 *            the value
    	 * @return {@code true} if this interval contains the value {@code x};
    	 *         {@code false} otherwise
    	 */
    	public boolean contains(double x)
    	{
    		return (min <= x) && (x <= max);
    	}
    	
    	/**
    	 * Returns the length of this interval.
    	 *
    	 * @return the length of this interval (max - min)
    	 */
    	public double length()
    	{
    		return max - min;
    	}
    	
    	/**
    	 * Returns a string representation of this interval.
    	 *
    	 * @return a string representation of this interval in the form [min, max]
    	 */
    	public String toString()
    	{
    		return "[" + min + ", " + max + "]";
    	}
    	
    	/**
    	 * Compares this transaction to the specified object.
    	 *
    	 * @param other
    	 *            the other interval
    	 * @return {@code true} if this interval equals the other interval;
    	 *         {@code false} otherwise
    	 */
    	public boolean equals(Object other)
    	{
    		if (other == this)
    			return true;
//    		if (other == null)
//    			return false;
//    		if (other.getClass() != this.getClass())
    			return false;
//    		Interval1DInt that = (Interval1DInt) other;
//    		return this.min == that.min && this.max == that.max;
    	}
    	
    	/**
    	 * Returns an integer hash code for this interval.
    	 *
    	 * @return an integer hash code for this interval
    	 */
    	public int hashCode()
    	{
    		int hash1 = ((Integer) min).hashCode();
    		int hash2 = ((Integer) max).hashCode();
    		return 31 * hash1 + hash2;
    	}
    	
    	/**
    	 * Created by me on Apr 5 2020
    	 * TODO
    	 * 
    	 * @param b
    	 * @return
    	 */
    	public int compareTo(Interval1DInt b)
    	{
    		if (min < b.min)
    			return -1;
    		else if (min > b.min)
    			return +1;
    		else if (max < b.max)
    			return -1;
    		else if (max > b.max)
    			return +1;
    		else
    			return 0;
    	}
    	
    	// ascending order of min endpoint, breaking ties by max endpoint
    	private static class MinEndpointComparator implements Comparator<Interval1DInt>
    	{
    		public int compare(Interval1DInt a, Interval1DInt b)
    		{
    			if (a.min < b.min)
    				return -1;
    			else if (a.min > b.min)
    				return +1;
    			else if (a.max < b.max)
    				return -1;
    			else if (a.max > b.max)
    				return +1;
    			else
    				return 0;
    		}
    	}
    }
}
