import java.io.*;
import java.util.Arrays;

public class Solution {
	public static void main(String args[]) throws Exception{
	    BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(stdReader.readLine());
		for(int i = 0 ; i < T ; i++){
			int N = Integer.parseInt(stdReader.readLine());
			Tuple[] p = new Tuple[N];
			char[] person = new char[N];
			for(int j = 0 ; j < N ; j++) {
				String[] s = stdReader.readLine().split(" ");
				Tuple<Integer,Integer,Integer> tp = new Tuple<Integer,Integer,Integer>();
				tp.setFirst(Integer.parseInt(s[0]));
				tp.setSecond(Integer.parseInt(s[1]));
				tp.setThird(j);
				p[j] = tp;
			}
			Arrays.sort(p);
			int C = -1;
			int J = -1;
			boolean isok = true;
			for(int j = 0 ; j < N ; j++) {
				if(C <= (Integer)p[j].getFirst()) {
					C = (Integer)p[j].getSecond();
					person[(Integer)p[j].getThird()] = 'C';
				}else if(J <= (Integer)p[j].getFirst()) {
					J = (Integer)p[j].getSecond();
					person[(Integer)p[j].getThird()] = 'J';
				}else {
					isok = false;
					break;
				}
			}
			if(!isok) {
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}else {
				StringBuilder sb = new StringBuilder();
				for(int j = 0 ; j < person.length ; j++) {
					sb.append(person[j]);
				}
				System.out.println("Case #"+(i+1)+": "+sb.toString());
			}
		}
		stdReader.close();
	}
}
class Tuple<S, T, R> implements Cloneable,Comparable<Tuple<?, ?, ?>>, Serializable {
    private static final long serialVersionUID = -553348920790587668L;
    @Override
    public Tuple<?, ?, ?> clone() {
        try {
            return (Tuple<?, ?, ?>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }
    public Tuple(){//S first, T second) {
        //this.first = first;
        //this.second = second;
    	//return;
    }
    private S first;
    private T second;
    private R third;
    @SuppressWarnings("unchecked")
	public Tuple(Tuple<?, ?, ?> p) {
        first = (S) p.getFirst();
        second = (T) p.getSecond();
        third = (R) p.getThird();
    }
    public S getFirst() {
        return first;
    }
    public void setFirst(S first) {
        this.first = first;
    }
    public T getSecond() {
        return second;
    }
    public void setSecond(T second) {
        this.second = second;
    }
    
    public R getThird() {
        return third;
    }
    public void setThird(R third) {
        this.third = third;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof Tuple)) { return false; }
        Tuple<?, ?, ?> Tuple = (Tuple<?, ?, ?>) obj;
        if (first == null) {
            if (second == null) {
                if (Tuple.first == null && Tuple.second == null) { return true; }
                return false;
            }
            if (Tuple.first == null) { return second.equals(Tuple.second); }
            return false;
        }
        if (second == null) {
            if (first != null) {
                if (Tuple.second == null) { return first.equals(Tuple.first); }
                return false;
            }
        }
        return first.equals(Tuple.first) && second.equals(Tuple.second);
    }
    /**
     * hashcode
     */
    @Override
    public int hashCode() {
        int result = 17;
        result *= 31;
        if (first != null) {
            result += first.hashCode();
        }
        result *= 31;
        if (second != null) {
            result += second.hashCode();
        }
        return result;
    }
    @Override
    public String toString() {
        return "[" + (first != null ? first : "null") + ", " + (second != null ? second : "null") + "]";
    }
    @SuppressWarnings("unchecked")
    public int compareTo(Tuple<?, ?, ?> o) {// Comparable>
        Comparable f = null;
        Comparable s = null;
        try {
            f = (Comparable) first;
            s = (Comparable) second;
        } catch (ClassCastException e) {
            throw new IllegalStateException(e);
        }
        if (f == null || s == null || o == null) throw new NullPointerException();
        int c = f.compareTo(o.first);
        if (c != 0) {return c; }
        return s.compareTo(o.second);
    }
}