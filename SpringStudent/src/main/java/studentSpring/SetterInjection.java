package studentSpring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SetterInjection {
	public static void main(String[] args) {
		 Resource res = new ClassPathResource("setterInjection.xml");
		    BeanFactory bf = new XmlBeanFactory(res);
		    System.out.println("hello world");
		    Student student = (Student) bf.getBean(Student.class);
		    System.out.println(student);
	}
}
