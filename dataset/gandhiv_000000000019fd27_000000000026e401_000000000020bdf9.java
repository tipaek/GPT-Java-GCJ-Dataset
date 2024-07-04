import java.util.*;
class Pair implements Comparable<Pair>{
    private Integer id;
    private Integer s;
    private Integer f;
    private Character name;
    Pair(int id, int s, int f){
        this.id = id;
        this.s = s;
        this.f = f;
        this.name = 'N';
    }
    public void setName(Character name){
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public Integer getS() {
        return s;
    }
    public Integer getF() {
        return f;
    }
    public Character getName() {
        return name;
    }
    @Override
    public int compareTo(Pair o) {
        return this.getS().compareTo(o.getS());
    }
    @Override
    public String toString() {
        return ""+name;
    }
}
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int i1;
		for(i1=1;i1<=n1;i1++){
		    int n = sc.nextInt();
		    List<Pair> li = new ArrayList<Pair>();
		    int i,j,k,s,f;
		    for(i=0;i<n;i++){
		        s = sc.nextInt();
		        f = sc.nextInt();
		        li.add(new Pair(i+1,s,f));
		    }
		    List<Pair> li1 = new ArrayList<Pair>(li);
		    List<Pair> res = new ArrayList<Pair>();
		    Collections.sort(li);
		    i=0;
		    Pair p = li.get(0);
		    p.setName('C');
		    res.add(p);
		    for(j=1;j<n;j++){
		        if(li.get(j).getS()>=li.get(i).getF()){
		            p = li.get(j);
		            p.setName('C');
		            res.add(p);
		            i=j;
		        }
		    }
		    List<Pair> res1 = new ArrayList<Pair>();
		    for(k=0;k<n;k++){
		        if(li.get(k).getName()=='N'){
		            res1.add(li.get(k));
		        }
		    }
		    if(res1.size()>0){
		    i=0;
		    p = res1.get(0);
		    p.setName('J');
		    for(j=1;j<res1.size();j++){
		        if(res1.get(j).getS()>=res1.get(i).getF()){
		            p = res1.get(j);
		            p.setName('J');
		            i=j;
		        }
		    }
		    }
		    boolean fl=false;
		    i=0;
		    while(fl==false && i<n){
		        if(li.get(i).getName()=='N')
		            fl=true;
		        i++;
		    }
		    System.out.print("Case #"+i1+": ");
		    if(fl==true)
		        System.out.println("IMPOSSIBLE");
		    else{
		        for(Pair x:li1){
		            System.out.print(""+x.getName());
		        }
		        System.out.println();
		    }
		}
	}
}