package com.example.xmlpullparsing;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
 

public class XmlPullParserHandler {
    private List<Employee> employees= new ArrayList<Employee>();
    private Employee employee;
    private String text;
 
    public List<Employee> getEmployees() {
        return employees;
    }
 
    public List<Employee> parse(InputStream is) {
           try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();
 
            parser.setInput(is, null);
 
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (tagname.equalsIgnoreCase("mytag")) {
                        // create a new instance of employee
                        employee = new Employee();
                    }
                    break;
 
                case XmlPullParser.TEXT:
                    text = parser.getText();
                    break;
 
                case XmlPullParser.END_TAG:
                    if (tagname.equalsIgnoreCase("mytag")) {
                        // add employee object to list
                        employees.add(employee);
                    }else if (tagname.equalsIgnoreCase("mysubtag1")) {
                        employee.setId(Integer.parseInt(text));
                    }  else if (tagname.equalsIgnoreCase("mysubtag2")) {
                        employee.setName(text);
                    } else if (tagname.equalsIgnoreCase("mysubtag3")) {
                        employee.setSalary(text);
                    } 
                    break;
 
                default:
                    break;
                }
                eventType = parser.next();
            }
 
        } catch (XmlPullParserException e) {e.printStackTrace();} 
        catch (IOException e) {e.printStackTrace();}
 
        return employees;
    }
}
