package assign06;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WebBrowserTester {

	private WebBrowser emptyWebBrowser;
	private WebBrowser singleURLWebBrowser;
	private WebBrowser smallWebBrowser;
	private WebBrowser largeWebBrowser;
	
	private String chars = "abcdefghijklmnopqrstuvwxyz";
	private Random rng = new Random();
	
	private String generateRandURL() {
		StringBuilder url = new StringBuilder();
		url.append("https://www.");
		for (int i = 0; i < 10; i++)
			url.append(chars.charAt(rng.nextInt(26)));
		url.append(".com");
		
		return url.toString();
	}

	@BeforeEach
	void setUp() {
		// Creates an empty WebBrowser object
		emptyWebBrowser = new WebBrowser();
		
		// Creates a WebBrowser object and visits one website
		singleURLWebBrowser = new WebBrowser();
		try {
			singleURLWebBrowser.visit(new URL("https://www.nilsstreedain.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// Creates a WebBrowser object and visits five websites
		smallWebBrowser = new WebBrowser();
		try {
			smallWebBrowser.visit(new URL("https://www.url0.com/"));
			smallWebBrowser.visit(new URL("https://www.url1.com/"));
			smallWebBrowser.visit(new URL("https://www.url2.com/"));
			smallWebBrowser.visit(new URL("https://www.url3.com/"));
			smallWebBrowser.visit(new URL("https://www.url4.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		// Creates a WebBrowser object and visits 1000 random websites
		largeWebBrowser = new WebBrowser();
		try {
			for (int i = 0; i < 1000; i++)
				largeWebBrowser.visit(new URL(generateRandURL()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
// visit() Tests
	@Test
	void visitMalformedURL() {
		boolean flag = false;
		try {
			emptyWebBrowser.visit(new URL(""));
		} catch (MalformedURLException e) {
			flag = true;
		}
		assertTrue(flag);
		assertThrows(NoSuchElementException.class, () -> {
			 emptyWebBrowser.back();
		});
	}
	
	@Test
	void visitEmptyBrowser() {
		try {
			emptyWebBrowser.visit(new URL("https://www.nilsstreedain.com/"));
			emptyWebBrowser.visit(new URL("https://www.craig.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		assertEquals("https://www.nilsstreedain.com/", emptyWebBrowser.back().toString());
	}
	
	@Test
	void otherTest() {
		
	}

}
