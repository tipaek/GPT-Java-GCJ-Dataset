import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
    	public static <T extends Comparable<T>> void concurrentSort( final List<T> key, List<?>... lists){
        // Do validation
        if(key == null || lists == null)
        	throw new NullPointerException("key cannot be null.");
 
        for(List<?> list : lists)
        	if(list.size() != key.size())
        		throw new IllegalArgumentException("all lists must be the same size");
 
        // Lists are size 0 or 1, nothing to sort
        if(key.size() < 2)
        	return;
 
        // Create a List of indices
		List<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < key.size(); i++)
			indices.add(i);
 
        // Sort the indices list based on the key
		Collections.sort(indices, new Comparator<Integer>(){
			@Override public int compare(Integer i, Integer j) {
				return key.get(i).compareTo(key.get(j));
			}
		});
 
		Map<Integer, Integer> swapMap = new HashMap<Integer, Integer>(indices.size());
		List<Integer> swapFrom = new ArrayList<Integer>(indices.size()),
					  swapTo   = new ArrayList<Integer>(indices.size());
 
        // create a mapping that allows sorting of the List by N swaps.
		for(int i = 0; i < key.size(); i++){
			int k = indices.get(i);
			while(i != k && swapMap.containsKey(k))
				k = swapMap.get(k);
 
			swapFrom.add(i);
			swapTo.add(k);
			swapMap.put(i, k);
		}
 
        // use the swap order to sort each list by swapping elements
		for(List<?> list : lists)
			for(int i = 0; i < list.size(); i++)
				Collections.swap(list, swapFrom.get(i), swapTo.get(i));
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int tt=1;tt<=t;tt++){
		    int cc,jj,flg=0;
		    int n = sc.nextInt();
		    String op="";
            List<Integer> a = new ArrayList<Integer>();
            List<Integer> b = new ArrayList<Integer>();
            List<Integer> in = new ArrayList<Integer>();
            
            for(int i=0;i<n;i++){
                a.add(sc.nextInt());
                b.add(sc.nextInt());
            }
            for(int i=0;i<n;i++)
                in.add(i);
            concurrentSort(a,a,b,in);
            
    
            cc=b.get(0);
            jj=b.get(1);
            op = op.concat("CJ");
            for(int i=2;i<n;i++){
                if(a.get(i)>=cc){
                    op = op.concat("C");
                    cc=b.get(i);
                }else if(a.get(i)>=jj){
                    op = op.concat("J"); 
                    jj=b.get(i);
                }else{
                    System.out.println("Case #"+tt+": IMPOSSIBLE");
                    flg=1;
                    break;
                }
            }
            if(flg==0){
                char bb[] = op.toCharArray();
                System.out.print("Case #"+tt+": ");
                for(int i=0;i<bb.length;i++)
                    System.out.print(bb[in.get(i)]);
                System.out.println();
            }
            
		}
	}
}
