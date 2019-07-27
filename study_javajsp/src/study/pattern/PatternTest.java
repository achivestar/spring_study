package study.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String serial = "adasf090-dfdfdf-001";
		Pattern pattern = Pattern.compile("^[0-9a-zA-Z\\-]+\\-([0-9]{1,3})$");
		Matcher m = pattern.matcher(serial);
		if (m.find()) {
			System.out.println(m.group(1));
		}

	}

}
