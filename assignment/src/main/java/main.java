
import java.io.IOException;



public class main {
public static void main(String[] args) throws IOException {
    
    getweb web = new getweb();
    web.grabData();
        
    
    getlist list = new getlist();
     list.getlist();
     
     write write = new write();
     write.writeToexcel();
     
     
   

    }


}