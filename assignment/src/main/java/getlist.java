
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getlist {

    public List<set> getlist() {

        try {
            final String listStudent = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            final Document document = Jsoup.connect(listStudent).get();
            List<set> details = new ArrayList<set>();
            for (int i = 1; i <= 35; i++) {
                Elements num = document.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-of-type(1)");
                Elements matricNo = document.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-of-type(2)");
                Elements name = document.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-of-type(3)");

                System.out.printf("| %-3s| %-6s| %-45s\n", num.text(), matricNo.text(), name.text());
                details.add(new set(num.text(), matricNo.text(), name.text()));
            }
            System.out.println();
            System.out.println("Table data has been collected successfully.");
            System.out.println();
            return details;

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
