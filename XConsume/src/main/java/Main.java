import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Test_Demo test_demo= (Test_Demo) context.getBean("testdemo");
        test_demo.testfun();
    }
}
