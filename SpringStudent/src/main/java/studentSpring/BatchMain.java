package studentSpring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BatchMain {
	public static void main(String[] args) {
		Resource res = new ClassPathResource("batch.xml");
	    BeanFactory bf = new XmlBeanFactory(res);
	    Batch batch = bf.getBean(Batch.class);
	    System.out.println(batch);
	}
}
