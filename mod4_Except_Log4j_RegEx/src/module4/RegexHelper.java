package module4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class RegexHelper {
	public static void main(String[] args) {
		// try-with-resources block. Will be implicitly/automatically closed for us 
		// as long as these resources implement the autocloseable interface.
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter Regex: ");
			Pattern pattern = Pattern.compile(sc.nextLine());
			System.out.println("Enter Regex: ");
			Matcher matcher = pattern.matcher(sc.nextLine());
			
			boolean found = false;
			while(matcher.find()) {
				System.out.println("Found text " + matcher.group() + 
						" starting at index=" + matcher.start() + 
						" and ending at index=" + matcher.end() );
				found = true;
			}
			
			if(!found)
				System.out.println("No match found.");
	// Handling unchecked exception (indicate a syntax error in a regular expression pattern)
		}catch (PatternSyntaxException e) { 
			e.printStackTrace();
		}
	}

}
