import net.bndy.ftsi.IndexService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class main {

    @Autowired
    private IndexService indexService;

    public void main() {
        Assert.assertNotEquals(this.indexService, null);
    }
}
