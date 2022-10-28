package com.whx.dom4j;

import com.whx.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/17
 * @descriptions  Dom4j 基本用法，通过 book.xml 来创建 Java 对象
 */
public class dom4jTest {


    @Test
    public void test01() throws DocumentException {

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/com/whx/book.xml");
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.asXML());

        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
//            System.out.println(book);
            String name = book.elementText("name");
            String author = book.elementText("author");
            String price = book.elementText("price");
            String sn = book.attributeValue("sn");
            System.out.println(new Book(sn,name,author, BigDecimal.valueOf(Double.parseDouble(price))));

        }

    }
}
