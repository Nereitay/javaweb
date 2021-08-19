package es.kiwi.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.kiwi.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws IOException {
        //1. 创建Person对象
        Person p = new Person();
        p.setName("Leon");
        p.setAge(23);
        p.setGender("男");

        //2. 创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*

            转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串

         */
        String json = mapper.writeValueAsString(p);
        System.out.println(json); // {"name":"Leon","age":23,"gender":"男"}

        //writeValue，将数据写到d://a.txt文件中
        mapper.writeValue(new File("a.txt"), p);

        //writeValue.将数据关联到Writer中
        mapper.writeValue(new FileWriter("b.txt"), p);
    }


    @Test
    public void test2() throws IOException {
        //1. 创建Person对象
        Person p = new Person();
        p.setName("Leon");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        //2. 创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(p);
        System.out.println(json); // {"name":"Leon","age":23,"gender":"男","birthday":1629370284556}

    }

    @Test
    public void test3() throws IOException {
        //1. 创建Person对象
        Person p = new Person();
        p.setName("Leo");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1 = new Person();
        p1.setName("on");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("eon");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        //创建list集合
        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p);

        
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(people);
        System.out.println(json); // [{"name":"on","age":23,"gender":"男","birthday":"2021-08-19"},{"name":"eon","age":23,"gender":"男","birthday":"2021-08-19"},{"name":"Leo","age":23,"gender":"男","birthday":"2021-08-19"}]

    }

    @Test
    public void test4() throws IOException {
        
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "Michel");
        map.put("age", 55);
        map.put("gender", "男");


        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(map);
        System.out.println(json); //{"gender":"男","name":"Michel","age":55}

    }

    @Test
    public void test5() throws IOException {

        String json = "{\"gender\":\"男\",\"name\":\"Michel\",\"age\":55}";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
