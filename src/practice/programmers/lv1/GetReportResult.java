package practice.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GetReportResult {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		HashSet<String> reportSet = new HashSet<String>(Arrays.asList(report));
		Map<String, Integer> reportMap = new HashMap<String, Integer>();
		String[] reports = reportSet.toArray(new String[0]);
		
		for (int i = 0; i < reports.length; i++) {
			String name = reports[i].split(" ")[1];
			
			if (reportMap.containsKey(name)) {
				reportMap.put(name, reportMap.get(name) + 1);
			}
			else {
				reportMap.put(name, 1);
			}
		}
		
		for (int i = 0; i < reports.length; i++) {
			String reportName = reports[i].split(" ")[1];
			
			if (reportMap.containsKey(reportName) && reportMap.get(reportName) >= k) {
				for (int j =0; j < id_list.length; j++) {
					if (reports[i].split(" ")[0].equals(id_list[j])) {
						answer[j]++;
						break;
					}
				}
			}
		}
		
		return answer;
	}
}
