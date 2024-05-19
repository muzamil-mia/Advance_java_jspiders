package studentSpring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ConstructorInjection {

	public static void main(String[] args) {
		Resource res = new ClassPathResource("constructorInjection.xml");
	    BeanFactory bf = new XmlBeanFactory(res);
	    System.out.println("hello world");
	    School school = (School)bf.getBean(School.class);
	    System.out.println(school);
	}

}
