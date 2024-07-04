import java.util.*;

class xyz {

	public static void main(String []args) {

		Scanner myObj = new Scanner(System.in);

		int T = myObj.nextInt();

		for (int i = 0 ; i < T ; ++i) {
			int N = myObj.nextInt();
			int K = myObj.nextInt();

			int sample_arr[][] = solve(N, K);

			if (sample_arr == null) {
				System.out.println("Case #" + String.valueOf(i+1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + String.valueOf(i+1) + ": POSSIBLE");
				for (int j = 0 ; j < N ; ++j) {
					for (int k = 0 ; k < N ; ++k) {
						System.out.print(sample_arr[j][k] + " ");
					}
					String newLine = System.getProperty("line.separator");
					System.out.print(newLine);
				}
			}
		}
	}

	public static boolean checkRow(int [][]a, int num, int N, int r) {
	
		for(int i = 0 ; i < N ; ++i) {
			if (a[r][i] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkCol(int [][]a, int num, int N, int c) {
	
		for(int i = 0 ; i < N ; ++i) {
			if (a[i][c] == num) {
				return false;
			}
		}

		return true;
	}


	public static int[][] returnIfPossible(int []arr, int N) {
	
		int ret[][] = new int[N][N];

		for (int i = 0 ; i < arr.length; ++i) {
			ret[i][i] = arr[i];
		}
		int temp;

		for (int i = 0 ; i < N ; ++i) {
			for (int j = 0 ; j < N ; ++j) {
				if (i==j) continue;
				temp = 0;
				for (int k = 1 ; k <= N ; ++k) {
					if (checkRow(ret, k, N, i) && checkCol(ret, k, N, j)) {
						temp = 1;

						ret[i][j] = k;

						break;
					}

				}
				if (temp == 0) {
					return null;
				}

			}
		}
		return ret;

	}

    public static int[][] solve(int N, int K) {

		ArrayList<Integer> numbers = new ArrayList<>(N);
		for(int i = 1; i <= N; i++){
    		numbers.add(i);
		}

        LinkedHashSet<Integer> targets = new LinkedHashSet<Integer>() {{
            add(K);
        }};

        for (Integer target: targets) {
            Combinations combinations = new Combinations(numbers, target, true);
            combinations.calculateCombinations();
			Set<String> soln = combinations.getCombinations();
            for (String solution: soln) {
				String[] elements = solution.split(" ");
				String[] trailing = Arrays.copyOfRange(elements,1,elements.length);
				int[] array = Arrays.asList(trailing).stream().mapToInt(Integer::parseInt).toArray();

				if (array.length > N) {
					continue;
				}

				int [][] ret = returnIfPossible(array, N);

				if (ret != null) {
					return ret;
				}
            }
        }

		return null;

    }

    public static class Combinations {
        private boolean allowRepetitions;
        private int[] repetitions;
        private ArrayList<Integer> numbers;
        private Integer target;
        private Integer sum;
        private boolean hasNext;
        private Set<String> combinations;

        /**
         * Constructor.
         *
         * @param numbers Numbers that can be used to calculate the sum.
         * @param target  Target value for sum.
         */
        public Combinations(ArrayList<Integer> numbers, Integer target) {
            this(numbers, target, true);
        }

        /**
         * Constructor.
         *
         * @param numbers Numbers that can be used to calculate the sum.
         * @param target  Target value for sum.
         */
        public Combinations(ArrayList<Integer> numbers, Integer target, boolean allowRepetitions) {
            this.allowRepetitions = allowRepetitions;
            if (this.allowRepetitions) {
                Set<Integer> numbersSet = new HashSet<>(numbers);
                this.numbers = new ArrayList<>(numbersSet);
            } else {
                this.numbers = numbers;
            }
            this.numbers.removeAll(Arrays.asList(0));
            Collections.sort(this.numbers);

            this.target = target;
            this.repetitions = new int[this.numbers.size()];
            this.combinations = new LinkedHashSet<>();

            this.sum = 0;
            if (this.repetitions.length > 0)
                this.hasNext = true;
            else
                this.hasNext = false;
        }

        /**
         * Calculate and return the sum of the current combination.
         *
         * @return The sum.
         */
        private Integer calculateSum() {
            this.sum = 0;
            for (int i = 0; i < repetitions.length; ++i) {
                this.sum += repetitions[i] * numbers.get(i);
            }
            return this.sum;
        }

        /**
         * Redistribute picks when only one of each number is allowed in the sum.
         */
        private void redistribute() {
            for (int i = 1; i < this.repetitions.length; ++i) {
                if (this.repetitions[i - 1] > 1) {
                    this.repetitions[i - 1] = 0;
                    this.repetitions[i] += 1;
                }
            }
            if (this.repetitions[this.repetitions.length - 1] > 1)
                this.repetitions[this.repetitions.length - 1] = 0;
        }

        /**
         * Get the sum of the next combination. When 0 is returned, there's no other combinations to check.
         *
         * @return The sum.
         */
        private Integer next() {
            if (this.hasNext && this.repetitions.length > 0) {
                this.repetitions[0] += 1;
                if (!this.allowRepetitions)
                    this.redistribute();
                this.calculateSum();

                for (int i = 0; i < this.repetitions.length && this.sum != 0; ++i) {
                    if (this.sum > this.target) {
                        this.repetitions[i] = 0;
                        if (i + 1 < this.repetitions.length) {
                            this.repetitions[i + 1] += 1;
                            if (!this.allowRepetitions)
                                this.redistribute();
                        }
                        this.calculateSum();
                    }
                }

                if (this.sum.compareTo(0) == 0)
                    this.hasNext = false;
            }
            return this.sum;
        }

        /**
         * Calculate all combinations whose sum equals target.
         */
        public void calculateCombinations() {
            while (this.hasNext) {
                if (this.next().compareTo(target) == 0)
                    this.combinations.add(this.toString());
            }
        }

        /**
         * Return all combinations whose sum equals target.
         *
         * @return Combinations as a set of strings.
         */
        public Set<String> getCombinations() {
            return this.combinations;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("" + sum + ": ");
            for (int i = 0; i < repetitions.length; ++i) {
                for (int j = 0; j < repetitions[i]; ++j) {
                    stringBuilder.append(numbers.get(i) + " ");
                }
            }
            return stringBuilder.toString();
        }
    }
}