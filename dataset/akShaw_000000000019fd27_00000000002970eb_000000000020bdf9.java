import java.util.*;

class Solution{

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		int t=sc.nextInt();

		String[] res=new String[t];

		for(int i=0; i<t; i++){

			int n=sc.nextInt();

			Interval[] intervals=new Interval[n];

			for(int j=0; j<n; j++){

				intervals[j]=new Interval(sc.nextInt(), sc.nextInt());

			}

			res[i]="Case #"+(i+1)+": "+getResult(intervals);
		}

		for(int i=0; i<t; i++){
			System.out.println(res[i]);
		}
	}

	private static String getResult(Interval[] intervals){

		ArrayList<Interval> cameron=new ArrayList<>();
		ArrayList<Interval> jamie=new ArrayList<>();

		String res="C";

		cameron.add(intervals[0]);

		for(int i=1; i<intervals.length; i++){

			if(!isBusy(cameron, intervals[i])){

				res+="C";
				cameron.add(intervals[i]);

			} else if(!isBusy(jamie, intervals[i])){

				res+="J";
				jamie.add(intervals[i]);

			} else{
				return "IMPOSSIBLE";
			}
		}

		return res;
	}

	private static boolean isBusy(ArrayList<Interval> parent, Interval interval){

		for(int i=0; i<parent.size(); i++){

			if(intervalOverlaps(parent.get(i), interval))
				return true;

		}

		return false;

	}

	private static boolean intervalOverlaps(Interval a, Interval b){

		int ai1=a.getSi();
		int ai2=a.getEi();

		int bi1=b.getSi();
		int bi2=b.getEi();

		if(ai2<=bi1 || ai1>=bi2){
            return false;
		}
        
    	return true;
        

	}
}

class Interval {

    //starting interval
    private int si;

    //ending interval
    private int ei;

    public Interval(int si, int ei) {
        this.si = si;
        this.ei = ei;
    }

    public int getSi() {
        return si;
    }

    public int getEi() {
        return ei;
    }

}
