package net.tsamaya.regex;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arnaud on 13/12/16.
 */
public class MatcherTest extends TestCase {

	@Test
	public void testRegex3Words() {

		System.out.println("--testRegex3Words");

		final String regex = "^(\\p{L}+)\\.(\\p{L}+)\\.(\\p{L}+)$";
		final String validAddresses = "tintin.indien.malin.enfin\n"
				+ "index.home.raft\n"
				+ "élégant.noëll.œuvre\n"
				+ "et.cætera";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(validAddresses);

		int nvalid = 0;

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));
			nvalid++;
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}

		Assert.assertEquals(2, nvalid);

	}

	@Test
	public void testRegex2Words() {

		System.out.println("--testRegex2Words");

		final String regex = "^(\\p{L}+)\\.(\\p{L}+)$";
		final String validAddresses = "index.home\n"
				+ "noël.œuvre\n"
				+ "noël.œuvre.cætera\n"
				+ "indien";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(validAddresses);

		int nvalid = 0;

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));
			nvalid++;
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}

		Assert.assertEquals(2, nvalid);

	}

	@Test
	public void testRegex1or2Words() {

		System.out.println("--testRegex1or2Words");

		final String regex = "^(\\p{L}+)(?:\\.?(\\p{L}+)?)$";
		final String validAddresses = "index.home.raft\n"
				+ "noëll.œuvre\n"
				+ "indien";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(validAddresses);

		int nvalid = 0;
//        String[] hints = new String[2];
		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));
			nvalid++;
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
//				hints[i-1] = matcher.group(i);
			}
//			for(int i = 0; i<hints.length; i++) {
//				System.out.println("hint : " + hints[i]);
//			}
		}

		Assert.assertEquals(2, nvalid);

	}


	@Test
	public void testRegex1or2WordsWithInvalidAddresses() {

		System.out.println("--testRegex1or2WordsWithInvalidAddresses");

		final String regex = "^(\\p{L}+)(?:\\.?(\\p{L}+)?)$";
		final String invalidAddresses = "index.home.raft\n"
				+ "1.2.3\n"
				+ "ab1,ab2,ab3\n"
				+ "1.1\n"
				+ "q.a.c";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(invalidAddresses);

		int nvalid = 0;

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));
			nvalid++;
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}

		Assert.assertEquals(0, nvalid);

	}
}
