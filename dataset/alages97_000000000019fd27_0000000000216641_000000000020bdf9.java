import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int j = 0; j < N; j++) {
            int number = sc.nextInt();
            ArrayList<TimeSched> list = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int id = i;
                TimeSched time = new TimeSched(start,end,id);
                list.add(time);
            }

            Collections.sort(list);
            StringBuffer sb = new StringBuffer();
            ArrayList<NameTime> namelist = new ArrayList<>();
            int cThreshold = 0;
            int jThreshold = 0;
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                TimeSched current = list.get(i);
                if (current.startTime >= cThreshold) {
                    namelist.add(new NameTime(current.id,"C"));
                    cThreshold = current.endTime;
                } else if (current.startTime >= jThreshold) {
                    //jlist.add(jThreshold);
                    //sb.append('J');
                    namelist.add(new NameTime(current.id,"J"));
                    jThreshold = current.endTime;
                }
                else {
                    flag = false;
                }
            }

            if (flag == false) {
                System.out.println("Case #" + (j+1) + ": " + "IMPOSSIBLE");
            } else {
                for (int i = 0; i < namelist.size(); i++) {
                    sb.append(namelist.get(i).person);
                }
                if (j < N-1) {
                System.out.println("Case #" + (j+1) + ": " + sb.toString());
            } else {
                System.out.print("Case #" + (j+1) + ": " + sb.toString());

            }
            }

        }
    }
}

class TimeSched implements Comparable<TimeSched>{
    int startTime;
    int endTime;
    int id;

    TimeSched(int startTime, int endTime,int id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
    }

    boolean overLap(TimeSched other) {
        if (this.startTime < other.startTime && this.endTime > other.startTime && this.endTime < other.endTime) {
            return true;
        }
        if (other.startTime < this.startTime && other.endTime > this.startTime && other.endTime < this.endTime) {
            return true;
        }

        return false;
    }

    public int compareTo(TimeSched t) {
        if (this.startTime == t.startTime) {
            return this.endTime - t.endTime;
        }
        return this.startTime - t.startTime;
    }

}

class NameTime implements Comparable<NameTime> {
    int id;
    String person;

    NameTime(int id, String person) {
        this.id = id;
        this.person = person;
    }

    public int compareTo(NameTime t) {
        return this.id - t.id;
    }

}
