import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner inputReader = new Scanner(new File("Input"));
			
			File outputFile = new File("Output");
			BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
			out.append("|");
			boolean lastAppendWasBar = true;
			boolean wasBlank = false;
			while (inputReader.hasNextLine()) {
				String line = inputReader.nextLine();
				if (line.equals("")) {
					if (!wasBlank) {
						wasBlank = true;
						System.out.println("WAS BLANK");
						//lastAppendWasBar = false;
					}else {
						out.append("|");
						wasBlank = false;
						lastAppendWasBar = true;
						System.out.println("ADDED BAR");
					}
					
				}else {
					if (!lastAppendWasBar) {
						out.append("<p>" + line + " </p>");
					}else {
						out.append(line + " ");
					}
					wasBlank = false;
					lastAppendWasBar = false;
					System.out.println(line);
				}
			}
			if (!lastAppendWasBar) {
				out.append("|");
			}
			inputReader.close();
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
