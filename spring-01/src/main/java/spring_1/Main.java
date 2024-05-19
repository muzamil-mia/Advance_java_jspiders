package spring_1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		Demo demo1 = new Demo();
		System.out.println("hello wrold");
		
		Resource r = new ClassPathResource("demo.xml");
		BeanFactory bf = new XmlBeanFactory(r);
		
		Demo d1 = bf.getBean(Demo.class);
		System.out.println(d1); //Demo@43301423
		
		Demo d2 = (Demo) bf.getBean("demo");
		System.out.println(d2); //Demo@43301423
		
		Demo d3 = bf.getBean(Demo.class);
		System.out.println(d3); //Demo@43301423
		
		//System.out.println(bf.getBean("dem")); //NoSuchBeanDefinitionException
	}

}
