

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class second {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

int T = sc.nextInt();

for (int i = 0; i < T; i++) {
int N = sc.nextInt();
List<Integer> start = new ArrayList<>();
List<Integer> end = new ArrayList<>();
String result = "";
boolean impossible = false;

HashMap<Integer, TimeSlots> map = new HashMap<>();

for (int j = 0; j <= 1440; j++) {
	TimeSlots minutes = new TimeSlots();
List<Integer> starting = new ArrayList<>();
List<Integer> ending = new ArrayList<>();
minutes.setStart(starting);
minutes.setEnd(ending);

map.put(j, minutes);
}

for (int j = 0; j < N; j++) {
start.add(sc.nextInt());
end.add(sc.nextInt());
}

for (int j = 0; j < start.size(); j++) {
List<Integer> list = map.get(start.get(j)).getStart();
list.add(j);
TimeSlots minutes = map.get(start.get(j));
minutes.setStart(list);
map.put(start.get(j), minutes);
}

for (int j = 0; j < end.size(); j++) {
List<Integer> list = map.get(end.get(j)).getEnd();
list.add(j);
TimeSlots minutes = map.get(end.get(j));
minutes.setEnd(list);
map.put(end.get(j), minutes);
}
ArrayList<Character> assign = new ArrayList<Character>();
for (int plue = 0; plue < N; plue++) {
assign.add('N');
}
boolean c = true, j = true, endit = false;
for (int min = 0; min < 1441; min++) {
for (int ends : map.get(min).end) {
if (assign.get(ends) == 'C') {
c = true;
} else {
j = true;
}
}
for (int starts : map.get(min).start) {
if (c) {
assign.set(starts, 'C');
c = false;
} else if (j) {
assign.set(starts, 'J');
j = false;
} else {
endit = true;
}
}
if (endit) {
break;
}

}
if (endit) {
System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
continue;
}

for (Character ch : assign) {
result = result + ch;
}

System.out.println("Case #" + (i + 1) + ": " + result);


}

}

}

class TimeSlots {

List<Integer> start;
List<Integer> end;

public List<Integer> getStart() {
return start;
}

public void setStart(List<Integer> start) {
this.start = start;
}

public List<Integer> getEnd() {
return end;
}

public void setEnd(List<Integer> end) {
this.end = end;
}

@Override
public String toString() {
return "Minutes [start=" + start + ", end=" + end + "]";
}

}
