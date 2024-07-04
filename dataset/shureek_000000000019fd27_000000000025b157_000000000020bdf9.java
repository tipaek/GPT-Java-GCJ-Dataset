import java.util.LinkedList;
import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int tNum = sc.nextInt(), tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			int aCount = sc.nextInt();
		
			char[] resArr = new char[aCount];
			
			String result = "IMPOSSIBLE";
			
			LinkedList<Activity> acts = new LinkedList<>();
			int curMaxStart=0;
			
			for(int i=0;i<aCount;i++) {
				int aStart = sc.nextInt();
				int aFinish = sc.nextInt();
				
				if(curMaxStart<=aStart) {
					acts.add(new Activity(aStart, aFinish,i));
					curMaxStart=aStart;
				} else {
					int indx=0;
					for(Activity a:acts) {
						if(a.start()>=aStart) {
							acts.add(indx,new Activity(aStart, aFinish,i));
							break;
						}
						indx++;
					}
				}
			}
			
			//System.out.println(acts);
			
			int curParent=0;
			int[] ps = {0,0};
			int[] pf = {0,0};
			boolean imposible = false;
			
			Activity[] actsArr = new Activity[aCount];
			actsArr = (Activity[]) acts.toArray(actsArr);
			
			ps[curParent]=actsArr[0].start();
			pf[curParent]=actsArr[0].finish();
			resArr[actsArr[0].index()]=((curParent==0)?'C':'J');
			
			for(int j=1;j<actsArr.length;j++) {
				curParent=(curParent+1)%2;
					

				if(pf[curParent]<=actsArr[j].start()) {
					ps[curParent]=actsArr[j].start();
					pf[curParent]=actsArr[j].finish();
					resArr[actsArr[j].index()]=((curParent==0)?'C':'J');
					continue;
				} else {
					curParent=(curParent+1)%2;
					if(pf[curParent]<=actsArr[j].start()) {
						ps[curParent]=actsArr[j].start();
						pf[curParent]=actsArr[j].finish();
						resArr[actsArr[j].index()]=((curParent==0)?'C':'J');
						continue;
					} else {
						// IMPOSIBLE
						imposible=true;
						break;
					}
				}
			
				
			}
			
			if(!imposible) {
				result=new String(resArr);
			}
			
			//System.out.println(resArr);
			//System.out.println(result);
			
			
			System.out.println(String.format("Case #%d: %s" , tCurr, result));
			
			
		}
		
		System.out.flush();
	}
	
	

}


class Activity{
    
    int start;       
    int fin;
    int index;
    
    int start() {
    	return this.start;
    }
    int finish() {
    	return this.fin;
    }
    
    int index() {
    	return this.index;
    }
    
    public Activity(int st,int fin, int index) {
    	this.start=st;
    	this.fin=fin;
    	this.index=index;
    }
    
    @Override
    public String toString()
    {
        return this.start+":"+this.fin;
    }
}