
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getweb {

    private static String URL = "https://github.com/STIW3054-A191/Main-Issues/issues/1";

    public void grabData() {
        try {

            final Document source = Jsoup.connect(URL).get();
            Elements table = source.getElementsByTag("p");

            for (Element comment : table) {
                System.out.println(comment.getElementsContainingText("Matric").text());

            }
            System.out.println();
            System.out.println("Table data has been collected successfully.");
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to access " + URL);
        }
    }

}
