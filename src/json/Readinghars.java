package json;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;

import edu.umass.cs.benchlab.har.*;
import edu.umass.cs.benchlab.har.tools.*;


public class Readinghars {


public static void main(String[] args) {
    String filename = new String("D:\\SeleniumEasy.har");
    File f = new File(filename);
    HarFileReader r = new HarFileReader();
    HarFileWriter w = new HarFileWriter();

    try
    {
      System.out.println("Reading " + filename);
      HarLog log = r.readHarFile(f);

      // Access all elements as objects
      HarBrowser browser = log.getBrowser();
      HarEntries entries = log.getEntries();

   // Used for loops
      List<HarPage> pages = log.getPages().getPages();
      List<HarEntry> hentry = entries.getEntries(); 

      for (HarPage page : pages)
      {
        System.out.println("page start time: "
            + ISO8601DateFormatter.format(page.getStartedDateTime()));
        System.out.println("page id: " + page.getId());
        System.out.println("page title: " + page.getTitle());
        }

      //Output "response" code of entries.
      for (HarEntry entry : hentry)
      {
          System.out.println("request code: " + entry.getRequest().getMethod()); //Output request type
          System.out.println("    response code: " + entry.getRequest().getUrl()); //Output url of request
          System.out.println("    response code: " + entry.getResponse().getStatus()); // Output the 
      }

      /*
      // Once you are done manipulating the objects, write back to a file
      System.out.println("Writing " + "fileName" + ".test");
      File f2 = new File("fileName" + ".test");
      w.writeHarFile(log, f2);
      */
    }
    catch (JsonParseException e)
    {
      e.printStackTrace();
      //fail("Parsing error during test");
    }
    catch (IOException e)
    {
      e.printStackTrace();
      //fail("IO exception during test");
    }
}
    
}
