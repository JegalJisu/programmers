package exam.sk;

public class Test1 {
	public static int solution(int money, int[] costs) {
		int answer = 0;
		int[] coin = {1, 5, 10, 50, 100, 500};
		double[] coinByCost = new double[6];
		
		for (int i = 0; i < costs.length; i++) {
			coinByCost[i] = (double)costs[i]/coin[i];
		}
		
		while(money != 0) {
			double lowCost = 10000.0;
			int index = -1;
			for (int i = 0; i < coinByCost.length; i++) {
				if (lowCost >= coinByCost[i]) {
					lowCost = coinByCost[i];
					index = i;
				}
			}
			
			answer += money / coin[index] * costs[index];
			money %= coin[index];
			coinByCost[index] = 10000.0;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 99, 35, 50, 1000};
		System.out.println(solution(4578, arr));
	}
}
