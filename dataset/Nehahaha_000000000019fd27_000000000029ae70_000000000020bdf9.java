import java.util.*;
 class ArrayIndexComparator implements Comparator<Integer>
{
    private final Integer[] array;

    public ArrayIndexComparator(Integer[] array)
    {
        this.array = array;
    }

    public Integer[] createIndexArray()
    {
        Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
        {
            indexes[i] = i; // Autoboxing
        }
        return indexes;
    }

    @Override
    public int compare(Integer index1, Integer index2)
    {
         // Autounbox from Integer to int to use as array indexes
        return array[index1].compareTo(array[index2]);
    }
}
public class Solution{
    private static void  displayResult(List<StringBuilder> res) {
		for(int i=0;i<res.size();i=i+2)
			System.out.println("Case #"+res.get(i)+": "+res.get(i+1));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        List<StringBuilder> result = new ArrayList<>();
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt();
			Integer[] start = new Integer[n];
			List<Integer> cam = new ArrayList<>();
			List<Integer> jam = new ArrayList<>();
			String res="";
			StringBuilder string =new StringBuilder();
			int[] end = new int[n];
			int[] sortedEnd = new int[n];
			for(int j=0;j<n;j++){
				start[j] = sc.nextInt();
				end[j] = sc.nextInt();
			}			
			ArrayIndexComparator comparator = new ArrayIndexComparator(start);
			Integer[] indexes = comparator.createIndexArray();
			Arrays.sort(indexes, comparator);
			for(int l=0;l<n;l++) {
			//System.out.println(indexes[l]);
				int in = indexes[l];
				sortedEnd[l] = end[in];
			}
			Arrays.sort(start);
			for(int m=0;m<n;m++) {
				int startTime = start[m];
				int endTime = sortedEnd[m];
				if(cam.isEmpty() && jam.isEmpty()) {
					cam.clear();
					cam.add(startTime);
					cam.add(endTime);
					res+="C";
				}else {
					int getE = cam.get(1);
                    if(startTime>=getE) {
                    	cam.clear();
                    	cam.add(startTime);
                    	cam.add(endTime);
                    	res+="C";
                    }else if(jam.isEmpty() || startTime>=jam.get(1)) {
                    	jam.clear();
                    	jam.add(startTime);
                    	jam.add(endTime);
                    	res+="J";
                    }else {
                    	res = "IMPOSSIBLE";
                    }
				}
				
			}
			if(res!="IMPOSSIBLE") {
				string.append(res) ;
				for(int p=0;p<indexes.length;p++) {
					int ind =  indexes[p];
					char ch = res.charAt(p);
				        string.setCharAt(ind, ch); 
				}
			}else {
				string.append(res);
			}
			StringBuilder is = new StringBuilder();
			result.add(is.append(Integer.toString(i)));
			result.add(string);
		}
         displayResult(result);
	}
}