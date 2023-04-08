package edu.frcc.csc1061j.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 20);
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
	public static void testConjecture(String destination, String source, int limit) throws IOException {
        Document doc = null;
        Connection conn = Jsoup.connect(source);
    	String link = null;
    	boolean linkFound = false;
        try 
        {
            doc = conn.get();
        }
        catch (Exception e)
        {
            System.out.println("Could not open page. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // select the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");

        for (Element para : paragraphs) {
            Iterable<Node> iter = new WikiNodeIterable(para);
            for (Node node : iter) {
                
                // TODO: FILL THIS IN!
            	
            	int paren = 0;
            	
            	// If this node is a text node make sure you are not within parentheses
            	if (node instanceof TextNode)
            	{
            		String text = node.toString();
            		int i = 0, j = 0; 
            		 
            		while (i != -1)
            		{
            			i = text.indexOf("(", j);
            			if (i != -1)
            			{
                			paren++;
            			}
            			j = i + 1;
            		}
            		
            		i = 0; 
            		j = 0;
            		
            		while (i != -1)
            		{
            			i = text.indexOf(")", j);
            			if (i != -1)
            			{
                			paren--;
            			}
            			j = i + 1;
            		}
            		
            	}
            	
            	// If this node has a link you can get it by accessing the href attribute in the node
            	link = node.attr("href");
            	
            	// If the link is not null and not an empty string and does not start with a # sign 
            	// and is not within parentheses, follow the link recursively by calling testConjecture() 
            	// until you reach your objective or run past the limit. 
            	if (link != null && !link.isEmpty() && (link.charAt(0) != '#') && paren == 0)
            	{
            		System.out.println("https://en.wikipedia.org" + link);
            		link = "https://en.wikipedia.org" + link;
            		linkFound = true;
            		break;
            	}
            }
    		if (linkFound)
    		{
    			break;
    		}
        }
        
        if (link.equals(destination))
        {
        	System.out.println();
        	System.out.println("\u001B[32m" + "Success! ^◡^🎉" + "\n" + "Number of links taken: " + (20 - limit) + "\u001B[0m"); // prints in green
        	return;
        }
        else if (limit <= 0)
        {
        	System.out.println();
        	System.out.println("\u001B[31mLimit exceeded ㅠ﹏ㅠ\u001B[0m"); // prints in red
        	return;
        }
        
		testConjecture(destination, link, --limit);
        
    }
}
