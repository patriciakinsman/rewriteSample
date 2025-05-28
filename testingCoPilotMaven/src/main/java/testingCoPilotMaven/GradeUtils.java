package testingCoPilotMaven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GradeUtils {

	public String getGradeByScore(int score) {
		if (score > 90)
			return "A";
		else if (score > 80)
			return "B";
		else if (score > 70)
			return "C";
		else if (score > 60)
			return "D";
		else
			return "F";
	}

	public static void readScores() {
		String csvFile = "src/main/resources/students_scores.csv"; // Make sure this file is in your working directory
		String line;
		String csvSplitBy = ",";
		
		//File csv = new File(getClass().getClassLoader().getResource(csvFile).getFile());
		File csv = new File(csvFile);

		try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
			// Read header
			String header = br.readLine();
			System.out.println("Header: " + header);

			// Read each line
			while ((line = br.readLine()) != null) {
				String[] student = line.split(csvSplitBy);
				System.out.println("Name: " + student[0] + ", Math: " + student[1] + ", Science: " + student[2]
						+ ", English: " + student[3]);
				System.out.println("Math Grade: " + new GradeUtils().getGradeByScore(Integer.parseInt(student[1])) 
                        + ", Science Grade: " + new GradeUtils().getGradeByScore(Integer.parseInt(student[2])) 
                        + ", English Grade: " + new GradeUtils().getGradeByScore(Integer.parseInt(student[3])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
