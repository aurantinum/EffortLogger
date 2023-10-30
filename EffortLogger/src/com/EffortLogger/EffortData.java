// Get EffortLogger data, then change to data that administrators can see
// Change to linked list (at least for roles

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
		
		for (int i = 0; i < effortData.length; i++) {
			data = data + effortData[i];
			data = data + "\n\n";
		}
		
		return data;
	}
	
	public String PrintDevelopers() {
		String data = "";
		
		data = data + "Developers:\n\n";
		for (int i = 0; i < developers.length; i++) {
			if (developers[i] == null) {
				break;
			}
			data = data + developers[i];
			data = data + "\n\n";
		}
		
		return data;
	}
	
	public String PrintEngineers() {
		String data = "";
		
		data = data + "Engineers:\n\n";
		for (int i = 0; i < engineers.length; i++) {
			if (engineers[i] == null) {
				break;
			}
			data = data + engineers[i];
			data = data + "\n\n";
		}
		
		return data;
	}
	
	// Strips name
	// strip ID, any other user information
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
