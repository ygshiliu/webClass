package day04_xml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

class TestDom4j {

	@Test
	void test1() throws DocumentException {
	
		//1.创建解析器对象
		SAXReader saxReader = new SAXReader();
		//2.解析xml文件获取document对象
		Document document = saxReader.read("students.xml");
		//3.得到根元素
		Element root = document.getRootElement();
		//System.out.println(root);
		List<Element> stuList = root.elements("student");
		
		for (Element element : stuList) {
			//System.out.println(element);
			
			//获取id,name,age
			//获取当前元素的属性值
			String id = element.attributeValue("id");
			//获取当前元素的name子元素的文本
			String name = element.elementText("name");
			//获取当前元素的age子元素的文本
			String age = element.elementText("age");
			System.out.println(id);
			System.out.println(name);
			System.out.println(age);
			
			//组合对象
			
		}
	}
	@Test
	public void testxpath() throws DocumentException {
		//1.创建解析器对象
		SAXReader saxReader = new SAXReader();
		//2.解析xml文件获取document对象
		Document document = saxReader.read("students.xml");
		
		List<Element> selectNodes = document.selectNodes("//student");
		for (Element element : selectNodes) {
			System.out.println(element.attributeValue("id"));
			System.out.println(element.elementText("name"));
			System.out.println(element.elementText("age"));
		}
		
		System.out.println("======================");
		
		Element ele = (Element) document.selectSingleNode("/students/student[@id='3']");
		
		System.out.println(ele);
		//id,name,age
		String id = ele.attributeValue("id");
		String name = ele.elementText("name");
		String age = ele.elementText("age");
		
		System.out.println(id+"--"+name+"--"+age);
	}

}
