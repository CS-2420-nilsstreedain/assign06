package assign06;

import static org.junit.Assert.assertArrayEquals;
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
	void visitSingleBrowser() {
		try {
			singleURLWebBrowser.visit(new URL("https://www.result.com/"));
			singleURLWebBrowser.visit(new URL("https://www.tester.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		assertEquals("https://www.result.com/", singleURLWebBrowser.back().toString());
	}
	
	@Test
	void visitSmallBrowser() {
		try {
			smallWebBrowser.visit(new URL("https://www.result.com/"));
			smallWebBrowser.visit(new URL("https://www.tester.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		assertEquals("https://www.result.com/", smallWebBrowser.back().toString());
	}
	
	@Test
	void visitLargeBrowser() {
		try {
			largeWebBrowser.visit(new URL("https://www.result.com/"));
			largeWebBrowser.visit(new URL("https://www.tester.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		assertEquals("https://www.result.com/", largeWebBrowser.back().toString());
	}
	
//back() Tests
	@Test
	void backEmptyBrowser() {
		assertThrows(NoSuchElementException.class, () -> {
			 emptyWebBrowser.back();
		});
	}
	
	@Test
	void backSingleBrowser() {
		assertThrows(NoSuchElementException.class, () -> {
			 singleURLWebBrowser.back();
		});
	}
	
	@Test
	void backSmallBrowser() {
		assertEquals("https://www.url3.com/", smallWebBrowser.back().toString());
	}
	
//forward() Tests
	@Test
	void forwardEmptyBrowser() {
		assertThrows(NoSuchElementException.class, () -> {
			 emptyWebBrowser.forward();
		});
	}
	
	@Test
	void forwardSingleBrowser() {
		assertThrows(NoSuchElementException.class, () -> {
			 singleURLWebBrowser.forward();
		});
	}
	
	@Test
	void forwardSmallBrowser() {
		smallWebBrowser.back();
		assertEquals("https://www.url4.com/", smallWebBrowser.forward().toString());
	}
	
	@Test
	void forwardSeveralSmallBrowser() {
		smallWebBrowser.back();
		smallWebBrowser.back();
		smallWebBrowser.back();
		assertEquals("https://www.url2.com/", smallWebBrowser.forward().toString());
		assertEquals("https://www.url3.com/", smallWebBrowser.forward().toString());
		smallWebBrowser.back();
		smallWebBrowser.back();
		assertEquals("https://www.url2.com/", smallWebBrowser.forward().toString());
		smallWebBrowser.back();
		smallWebBrowser.back();
		assertEquals("https://www.url1.com/", smallWebBrowser.forward().toString());
		assertEquals("https://www.url2.com/", smallWebBrowser.forward().toString());
		assertEquals("https://www.url3.com/", smallWebBrowser.forward().toString());
		assertEquals("https://www.url4.com/", smallWebBrowser.forward().toString());
	}
	
	@Test
	void forwardSeveralWithVisitSmallBrowser() {
		smallWebBrowser.back();
		smallWebBrowser.back();
		try {
			smallWebBrowser.visit(new URL("https://www.result.com/"));
			smallWebBrowser.visit(new URL("https://www.tester.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		smallWebBrowser.back();
		smallWebBrowser.back();
		smallWebBrowser.back();
		assertEquals("https://www.url2.com/", smallWebBrowser.forward().toString());
		assertEquals("https://www.result.com/", smallWebBrowser.forward().toString());
		assertEquals("https://www.tester.com/", smallWebBrowser.forward().toString());

		
	}
	

	
	@Test
	void testCreateBrowserFromHistory() {
		SinglyLinkedList<URL> history = new SinglyLinkedList<>();
		try {
			history.insertFirst(new URL("https://www.0.com/"));
			history.insertFirst(new URL("https://www.1.com/"));
			history.insertFirst(new URL("https://www.2.com/"));
			history.insertFirst(new URL("https://www.3.com/"));
			history.insertFirst(new URL("https://www.4.com/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		WebBrowser browser = new WebBrowser(history);
		assertArrayEquals(history.toArray(), browser.history().toArray());
	}

}
