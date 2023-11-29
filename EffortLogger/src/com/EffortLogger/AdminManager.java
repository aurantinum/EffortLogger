// Author: Alex Dumerve
// This prototype takes employee effort data and takes the employee name and ID out before 
// administrators have access to it.
// There also has to be enough individuals to maintain anonymity. (In this case, there needs to be 2)
// Administrators will be able to filter the data based on roles.
// 
// Changes:
// receives data as Employee[] instead of String[] to fit in with the rest
// Got rid of unnecessary clutter to improve readability 
// PrintAll() now uses other print methods so that roles that don't meet the min does not get printed
// Defects are now shown

package com.EffortLogger;

public class AdminManager {
	// arrays for roles
	private Employee[] developers;
	private Employee[] engineers;
	
	// transfer effort data to class
	public AdminManager(Employee[] effortData) {
		
		developers = new Employee[effortData.length];
		engineers = new Employee[effortData.length];
		
		SeperateArray(effortData);
	}

	public String PrintAll() {
		String data = PrintDevelopers() + PrintEngineers();
		
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
			data = data + developers[i].GetRole() + " " + developers[i].GetRank() + "\n";
			data = data + "Hours: " + developers[i].GetHours() + "\n" + "Defects: " + developers[i].GetDefects();
			data = data + "\n\n";
		}
		if (c < 2) {
			return "There are not enough developers to ensure employee anonymity";
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
			data = data + engineers[i].GetRole() + " " + engineers[i].GetRank() + "\n";
			data = data + "Hours: " + engineers[i].GetHours() + "\n" + "Defects: " + engineers[i].GetDefects();
			data = data + "\n\n";
		}
		
		if (c < 2) {
			return "There are not enough engineers to ensure employee anonymity";
		}
		
		return data;
	}
	
	private void SeperateArray(Employee[] effortData) {
		int j = 0;
		int k = 0;
		for (int i = 0; i < effortData.length; i++) {
			if (effortData[i].GetRole().equals("Developer")) {
				developers[j] = effortData[i];
				j++;
			}
			else if (effortData[i].GetRole().equals("Engineer")) {
				engineers[k] = effortData[i];
				k++;
			}
		}
	}
}
