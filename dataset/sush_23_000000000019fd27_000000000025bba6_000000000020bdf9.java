import java.util.*;
import java.util.stream.*;
class Time implements Comparable<Time>{
    int st,et;
    Time(int st,int et){
        this.st = st;
        this.et = et;
    }
	public int compareTo(Time o1){
		return this.st - o1.st;
	}
	public String toString(){
		return this.st +" "+this.et;
	}
}
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<String> ans = new ArrayList<>();
        for(int t=1;t<=T;t++){
            int n = sc.nextInt();
			Time arr[] = new Time[n]; for(int i=0;i<n;i++)arr[i] = new Time(sc.nextInt(),sc.nextInt());
			Arrays.sort(arr);
            String res = "";
            ArrayList<Time> Ja = new ArrayList<>();
            ArrayList<Time> Ca = new ArrayList<>();
			boolean flag = true;
            for(int i=0;i<n;i++){
                //int st = sc.nextInt(), et = sc.nextInt();
				int st = arr[i].st, et = arr[i].et;
				if(flag == false)continue;
                Time temp = new Time(st,et);
				boolean a = isPos(Ja,temp);
                if(a){res+="J"; continue;}
				boolean b = isPos(Ca,temp);
				if(b){res+="C"; continue;}
				res = "IMPOSSIBLE";
				flag = false;
            }
			ans.add(new String("Case #"+t+": "+res));
        }
		ans.stream().forEach(s->System.out.println(s));
    }
	static boolean isPos(ArrayList<Time> al,Time temp){
	if(al.size()==0){
	al.add(temp);
	return true;
	}
	Time temp1 = al.get(al.size()-1);
	if(temp1.et <= temp.st){
	if(temp1.et == temp.st){
		al.add(new Time(temp1.st,temp.et));
	}
		else al.add(temp);
		return true;
	}
return false;
				
				}
}