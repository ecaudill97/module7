package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class wordparserTest {

	@Test
	void test() throws IOException {
		String testhtml = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
		String output =  WordParser.createString(testhtml);
		boolean test1 = output.contains("and=38");
		boolean test2 = output.contains("my=24");
		boolean test3 = output.contains("of=22");
		boolean test4 = output.contains("raven=11");
		boolean test5 = output.contains("with=8");
		
		assertTrue(test1);
		assertTrue(test2);
		assertTrue(test3);
		assertTrue(test4);
		assertTrue(test5);
		
		
		
		
		
		
	}

}
