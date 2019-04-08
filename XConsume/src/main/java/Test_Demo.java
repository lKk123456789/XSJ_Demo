import com.xsj.api.XService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Test_Demo {
    @Autowired
    private XService xService;
    public void testfun(){
      xService.fun();
    }
}
