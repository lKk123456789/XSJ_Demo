package provider;

import com.xsj.api.XService;
import org.springframework.stereotype.Service;


@Service("testService")
public class XServiceImpl implements XService {

    public void fun() {
        System.out.println("11111");
    }
}
