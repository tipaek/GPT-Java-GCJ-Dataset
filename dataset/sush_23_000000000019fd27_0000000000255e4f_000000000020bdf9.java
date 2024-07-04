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
}
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<String> ans = new ArrayList<>();
        for(int t=1;t<=T;t++){
            int n = sc.nextInt();
            String res = "";
            ArrayList<Time> Ja = new ArrayList<>();
            ArrayList<Time> Ca = new ArrayList<>();
			boolean flag = true;
            for(int i=0;i<n;i++){
                int st = sc.nextInt(), et = sc.nextInt();
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
	//Integer l = new Integer(temp.st);
	if(al.size()==0){
	al.add(temp);
	return true;
	}
		int index = Collections.binarySearch(al,new Time(temp.st,0));
		
                if(index<0){
                    index = -index-1;
                    /*if(index == 0){// || */
					//if(index == al.size())
					 //index-=1;
					 
                  /*  al.add(temp);
                    return true;}*/
                    //else index-= 1;  
                }
				if(index == al.size()) index-=1;
				Time temp1 = al.get(index);
                    if(temp.st >= temp1.et || temp.et <= temp1.st){
                      /* al.add(temp);
                        Collections.sort(al);//(o1,o2) -> o1.st-o2.st);
						return true;*/
				index-=1;
				if(index<0){
					al.add(temp);
                        Collections.sort(al);//(o1,o2) -> o1.st-o2.st);
						return true;
				}
				temp1 = al.get(index);
                    if(temp.st >= temp1.et || temp.et <= temp1.st){
                       al.add(temp);
                        Collections.sort(al);//(o1,o2) -> o1.st-o2.st);
						return true;
                 }
				 }
				  return false;
				
				}
}