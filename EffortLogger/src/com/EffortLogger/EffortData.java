// Author: Alex Dumerve
// This prototype takes employee effort data and takes the employee name and ID out before 
// administrators have access to it.
// There also has to be enough individuals to maintain anonymity. (In this case, there needs to be 3)

package com.EffortLogger;

public class EffortData {
	private String[] effortData; // effort data
	
	// arrays for roles
	private String[] developers;
	private String[] engineers;
	
	// transfer effort data to class
	public EffortData(String[] effortData) {
		this.effortData = new String[effortData.length];
		for (int i = 0; i < effortData.length; i++) {
			this.effortData[i] = effortData[i];
		}
		
		developers = new String[effortData.length];
		engineers = new String[effortData.length];
		
		PrintAll();
		
		ModifyArray(this.effortData);
	}
	
	public String PrintAll() {
		String data = "";
		int c = 0;
		
		for (int i = 0; i < effortData.length; i++) {
			data = data + effortData[i];
			data = data + "\n\n";
			c = i;
		}
		
		if (c < 2) {
			return "There is not enough data to ensure employee anonymity";
		}
		
		return data;
	}
	
	public String PrintDevelopers() {
		int c = 0;
		String data = "";
		
		data = data + "Developers:\n\n";
		for (int i = 0; i < developers.length; i++) {
			if (developers[i] == null) {
				c = i;
				break;
			}
			data = data + developers[i];
			data = data + "\n\n";
		}
		if (c < 2) {
			return "There is not enough data to ensure employee anonymity";
		}
		
		return data;
	}
	
	public String PrintEngineers() {
		String data = "";
		int c = 0;
		
		data = data + "Engineers:\n\n";
		for (int i = 0; i < engineers.length; i++) {
			if (engineers[i] == null) {
				c = i;
				break;
			}
			data = data + engineers[i];
			data = data + "\n\n";
		}
		
		if (c < 2) {
			return "There is not enough data to ensure employee anonymity";
		}
		
		return data;
	}
	
	// Strips name and ID
	private String StripInfo(String effortData) {
		int indexStart, indexEnd;
		
		// strip name
		indexStart = effortData.indexOf("Name: ");
		indexEnd = effortData.indexOf("\n", indexStart);
		indexEnd++;
		effortData = SubtractSubstring(effortData, indexStart, indexEnd);
		
		// strip ID
		indexStart = effortData.indexOf("ID: ");
		indexEnd = effortData.indexOf("\n", indexStart);
		indexEnd++;
		effortData = SubtractSubstring(effortData, indexStart, indexEnd);
		
		return effortData;
	}
	
	private void ModifyArray(String[] effortData) {
		for (int i = 0; i < effortData.length; i++) {
			effortData[i] = StripInfo(effortData[i]);
			SeperateRank(effortData[i]);
		}
		
		PrintAll();
	}
	
	private String SubtractSubstring(String mainString, int startIndex, int endIndex) {
		
		String partBefore = mainString.substring(0, startIndex);
		String partAfter = mainString.substring(endIndex);
		
		return partBefore + partAfter;
	}
	
	private void SeperateRank(String employee) {
		String rank = "";
		int indexStart, indexEnd;
		// find rank
		indexStart = employee.indexOf("Rank: ");
		indexStart += 6;
		indexEnd = employee.indexOf("\n", indexStart);
		rank = employee.substring(indexStart, indexEnd);
		
		if (rank.equals("Developer")) {
			for (int i = 0; i < developers.length; i++) {
				if (developers[i] == null) {
					developers[i] = employee;
					developers[i] = developers[i].substring(0, indexEnd) + " " + (i + 1) + developers[i].substring(indexEnd);
					break;
				}
			}
		}
		else if(rank.equals("Engineer")) {
			for (int i = 0; i < engineers.length; i++) {
				if (engineers[i] == null) {
					engineers[i] = employee;
					engineers[i] = engineers[i].substring(0, indexEnd) + " " + (i + 1) + engineers[i].substring(indexEnd);
					break;
				}
			}
		}
	}
}
