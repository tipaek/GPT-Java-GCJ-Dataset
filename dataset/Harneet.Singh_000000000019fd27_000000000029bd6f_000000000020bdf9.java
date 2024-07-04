
import java.io.IOException;
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
			IntervalST<String> searchTable = new IntervalST<String>();
			Interval1DInt intervals [] = new Interval1DInt[n];
			
			int arr [] [] = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				String arrString [] = scan.nextLine().split(" ");
//				arr[i][0] = Integer.parseInt(arrString[0]);
//				arr[i][1] = Integer.parseInt(arrString[1]);
				arr[i][0] = Integer.parseInt(arrString[0]) * 10 + 1;
				arr[i][1] = Integer.parseInt(arrString[1]) * 10 - 1;
				intervals[i] = new Interval1DInt(arr[i][0], arr[i][1]);
				
				searchTable.put(intervals[i], "C");
			}
			
			HashMap<Interval1DInt, String> map = new HashMap<Interval1DInt, String>(n * 2);
			LinkedHashSet<String> set = new LinkedHashSet<>(n);
			for (int i = 0; i < arr.length; i++)
			{
				if(set.contains(arr[i][0] + " " + arr[i][1]))
					map.put(intervals[i], "J");
				
				set.add(arr[i][0] + " " + arr[i][1]);
			}
			
			for (int i = 0; i < arr.length; i++)
			{
				if(map.get(intervals[i]) == null)
					map.put(intervals[i], "C");
				
				Iterable<Interval1DInt> intersectingIntervals = searchTable.searchAll(intervals[i]);
//				System.out.println(intervals[i] + " -------> " + intersectingIntervals);
				for(Interval1DInt interval1DInt : intersectingIntervals)
				{
					if(intervals[i] != interval1DInt)
					{
//						if(map.get(interval1DInt) == null)
//							map.put(interval1DInt, "C");
//					}
////					else if(map.get(interval1DInt) == null)
////						map.put(interval1DInt, "J");
//					else
//					{
						if (map.get(interval1DInt) == null)
							if (map.get(intervals[i]).equals("C"))
								map.put(interval1DInt, "J");
							else
								map.put(interval1DInt, "C");
						else
						{
//							if(intervals[i].equals(interval1DInt))
//								if (map.get(intervals[i]).equals("C"))
//									map.put(interval1DInt, "J");
//								else
//									map.put(interval1DInt, "C");
//							else 
								if (map.get(intervals[i]).equals(map.get(interval1DInt)))
									map.put(interval1DInt, "IMP");
						}
//						else if(map.get(interval1DInt).equals("J"))
//							map.put(interval1DInt, "IMPOSSIBLE");
					}
				}
//				System.out.println("Case #" + (testcase + 1) + ": " + Arrays.toString(arr[i]));
			}
			
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
	


	static class IntervalST<Value>  {

	    private Node root;   // root of the BST

	    // BST helper node data type
	    private class Node {
	        Interval1DInt interval;      // key
	        Value value;              // associated data
	        Node left, right;         // left and right subtrees
	        int N;                    // size of subtree rooted at this node
	        int max;                  // max endpoint in subtree rooted at this node

	        Node(Interval1DInt interval, Value value) {
	            this.interval = interval;
	            this.value    = value;
	            this.N        = 1;
	            this.max      = interval.max;
	        }
	    }


	   /***************************************************************************
	    *  BST search
	    ***************************************************************************/

	    public boolean contains(Interval1DInt interval) {
	        return (get(interval) != null);
	    }

	    // return value associated with the given key
	    // if no such value, return null
	    public Value get(Interval1DInt interval) {
	        return get(root, interval);
	    }

	    private Value get(Node x, Interval1DInt interval) {
	        if (x == null)                  return null;
	        int cmp = interval.compareTo(x.interval);
	        if      (cmp < 0) return get(x.left, interval);
	        else if (cmp > 0) return get(x.right, interval);
	        else              return x.value;
	    }


	   /***************************************************************************
	    *  randomized insertion
	    ***************************************************************************/
	    public void put(Interval1DInt interval, Value value) {
//	        if (contains(interval)) { remove(interval);  }
	        root = randomizedInsert(root, interval, value);
	    }

	    // make new node the root with uniform probability
	    private Node randomizedInsert(Node x, Interval1DInt interval, Value value) {
	        if (x == null) return new Node(interval, value);
	        if (Math.random() * size(x) < 1.0) return rootInsert(x, interval, value);
	        int cmp = interval.compareTo(x.interval);
	        if (cmp < 0)  x.left  = randomizedInsert(x.left,  interval, value);
	        else          x.right = randomizedInsert(x.right, interval, value);
	        fix(x);
	        return x;
	    }

	    private Node rootInsert(Node x, Interval1DInt interval, Value value) {
	        if (x == null) return new Node(interval, value);
	        int cmp = interval.compareTo(x.interval);
	        if (cmp < 0) { x.left  = rootInsert(x.left,  interval, value); x = rotR(x); }
	        else         { x.right = rootInsert(x.right, interval, value); x = rotL(x); }
	        return x;
	    }


	   /***************************************************************************
	    *  deletion
	    ***************************************************************************/
	    private Node joinLR(Node a, Node b) { 
	        if (a == null) return b;
	        if (b == null) return a;

	        if (Math.random() * (size(a) + size(b)) < size(a))  {
	            a.right = joinLR(a.right, b);
	            fix(a);
	            return a;
	        }
	        else {
	            b.left = joinLR(a, b.left);
	            fix(b);
	            return b;
	        }
	    }

	    // remove and return value associated with given interval;
	    // if no such interval exists return null
	    public Value remove(Interval1DInt interval) {
	        Value value = get(interval);
	        root = remove(root, interval);
	        return value;
	    }

	    private Node remove(Node h, Interval1DInt interval) {
	        if (h == null) return null;
	        int cmp = interval.compareTo(h.interval);
	        if      (cmp < 0) h.left  = remove(h.left,  interval);
	        else if (cmp > 0) h.right = remove(h.right, interval);
	        else              h = joinLR(h.left, h.right);
	        fix(h);
	        return h;
	    }


	   /***************************************************************************
	    *  Interval searching
	    ***************************************************************************/

	    // return an interval in data structure that intersects the given inteval;
	    // return null if no such interval exists
	    // running time is proportional to log N
	    public Interval1DInt search(Interval1DInt interval) {
	        return search(root, interval);
	    }

	    // look in subtree rooted at x
	    public Interval1DInt search(Node x, Interval1DInt interval) {
	        while (x != null) {
	            if (interval.intersects(x.interval)) return x.interval;
	            else if (x.left == null)             x = x.right;
	            else if (x.left.max < interval.min)  x = x.right;
	            else                                 x = x.left;
	        }
	        return null;
	    }


	    // return *all* intervals in data structure that intersect the given interval
	    // running time is proportional to R log N, where R is the number of intersections
	    public Iterable<Interval1DInt> searchAll(Interval1DInt interval) {
	        LinkedList<Interval1DInt> list = new LinkedList<Interval1DInt>();
	        searchAll(root, interval, list);
	        return list;
	    }

	    // look in subtree rooted at x
	    public boolean searchAll(Node x, Interval1DInt interval, LinkedList<Interval1DInt> list) {
	         boolean found1 = false;
	         boolean found2 = false;
	         boolean found3 = false;
	         if (x == null)
	            return false;
	        if (interval.intersects(x.interval)) {
	            list.add(x.interval);
	            found1 = true;
	        }
	        if (x.left != null && x.left.max >= interval.min)
	            found2 = searchAll(x.left, interval, list);
	        if (found2 || x.left == null || x.left.max < interval.min)
	            found3 = searchAll(x.right, interval, list);
	        return found1 || found2 || found3;
	    }


	   /***************************************************************************
	    *  useful binary tree functions
	    ***************************************************************************/

	    // return number of nodes in subtree rooted at x
	    public int size() { return size(root); }
	    private int size(Node x) { 
	        if (x == null) return 0;
	        else           return x.N;
	    }

	    // height of tree (empty tree height = 0)
	    public int height() { return height(root); }
	    private int height(Node x) {
	        if (x == null) return 0;
	        return 1 + Math.max(height(x.left), height(x.right));
	    }


	   /***************************************************************************
	    *  helper BST functions
	    ***************************************************************************/

	    // fix auxilliar information (subtree count and max fields)
	    private void fix(Node x) {
	        if (x == null) return;
	        x.N = 1 + size(x.left) + size(x.right);
	        x.max = max3(x.interval.max, max(x.left), max(x.right));
	    }

	    private int max(Node x) {
	        if (x == null) return Integer.MIN_VALUE;
	        return x.max;
	    }

	    // precondition: a is not null
	    private int max3(int a, int b, int c) {
	        return Math.max(a, Math.max(b, c));
	    }

	    // right rotate
	    private Node rotR(Node h) {
	        Node x = h.left;
	        h.left = x.right;
	        x.right = h;
	        fix(h);
	        fix(x);
	        return x;
	    }

	    // left rotate
	    private Node rotL(Node h) {
	        Node x = h.right;
	        h.right = x.left;
	        x.left = h;
	        fix(h);
	        fix(x);
	        return x;
	    }


	   /***************************************************************************
	    *  Debugging functions that test the integrity of the tree
	    ***************************************************************************/

	    // check integrity of subtree count fields
	    public boolean check() { return checkCount() && checkMax(); }

	    // check integrity of count fields
	    private boolean checkCount() { return checkCount(root); }
	    private boolean checkCount(Node x) {
	        if (x == null) return true;
	        return checkCount(x.left) && checkCount(x.right) && (x.N == 1 + size(x.left) + size(x.right));
	    }

	    private boolean checkMax() { return checkMax(root); }
	    private boolean checkMax(Node x) {
	        if (x == null) return true;
	        return x.max ==  max3(x.interval.max, max(x.left), max(x.right));
	    }
	}
	
	static class Interval1DInt
    {
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
    }
}
