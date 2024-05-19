package spring_1;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class UserMain {

	public static void main(String[] args) {
		Resource r = new ClassPathResource("demo.xml");
		BeanFactory bf = new XmlBeanFactory(r);
		
		User user = (User) bf.getBean(User.class);
		System.out.println(user);
	}

}