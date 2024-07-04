import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	class Nested {
		Integer sequence;
		int startTime;
		int endTime;
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getSequence() {
			return sequence;
		}

		public void setSequence(Integer sequence) {
			this.sequence = sequence;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		public String getAssignTo() {
			return assignTo;
		}

		public void setAssignTo(String assignTo) {
			this.assignTo = assignTo;
		}

		String assignTo;
	}

	class Dto {
		Integer times;
		List<Nested> nested = new ArrayList<>();

		public Integer getTimes() {
			return times;
		}

		public void setTimes(Integer times) {
			this.times = times;
		}

		public List<Nested> getNested() {
			return nested;
		}

		public void setNested(List<Nested> nested) {
			this.nested = nested;
		}

	}

	public static void main(String[] args) {

		int t;
		Scanner scn = new Scanner(System.in);

		t = scn.nextInt();
		List<Dto> dtoList = new ArrayList<>();
		Solution Solution = new Solution();
		for (int i = 0; i < t; i++) {
			int size = scn.nextInt();
			Dto dto = Solution.new Dto();
			dto.setTimes(size);
			for (int j = 0; j < dto.getTimes(); j++) {
				int k, v;
				k = scn.nextInt();
				v = scn.nextInt();
				Nested nested = Solution.new Nested();
				nested.setStartTime(k);
				nested.setEndTime(v);
				nested.setSequence(j);
				nested.setName(null);
				dto.getNested().add(nested);
			}
			dtoList.add(dto);
		}
		for (int i = 0; i < dtoList.size(); i++) {
			boolean print = true;
			Dto dto = dtoList.get(i);
			List<Nested> arihant = new ArrayList<>();
			List<Nested> rajat = new ArrayList<>();
			
		
			
			dto.getNested().get(0).setName("C");
			arihant.add(dto.getNested().get(0));
			
			
			
			for (int j = 1; j < dto.getTimes(); j++) {
				if (!validate(dto.getNested().get(j), arihant)) {

					if (validate(dto.getNested().get(j), rajat)) {
						dto.getNested().get(j).setName("J");
						rajat.add(dto.getNested().get(j));
						break;
					}
				}
			}
			

			for (int j = 1; j < dto.getTimes(); j++) {
				if (dto.getNested().get(j).getName() == null || dto.getNested().get(j).getName().isEmpty()) {
					if (validate(dto.getNested().get(j), arihant)) {
						dto.getNested().get(j).setName("C");
						arihant.add(dto.getNested().get(j));
					} else if (validate(dto.getNested().get(j), rajat)) {
						dto.getNested().get(j).setName("J");
						rajat.add(dto.getNested().get(j));
					} else {
						System.out.println("CASE #" + (i+1) + ": IMPOSSIBLE");
						print = false;
						break;
					}

				}
			}
			if (print) {
				List<Nested> finalList = new ArrayList<>();
				finalList.addAll(arihant);
				finalList.addAll(rajat);
				finalList.sort(Comparator.comparing(Nested::getSequence));
				System.out.print("CASE #" + (i+1) + ": ");
				finalList.forEach(data -> {
					System.out.print(data.getName());
				});
				System.out.println();
			}
		}
	}

	static boolean validate(Nested test, List<Nested> list) {		
		int startTime = test.getStartTime();
		int endTime = test.getEndTime();
		for (int i = 0; i < list.size(); i++) {
		/*	if(list.get(i).getName() != null && !list.get(i).getName().isEmpty()){
				System.out.println("Yessssssssss");
				continue;
			}*/
			if (endTime > list.get(i).getStartTime() && list.get(i).getEndTime() > startTime) {
				return false;
			}
		}
		return true;
	}

}
