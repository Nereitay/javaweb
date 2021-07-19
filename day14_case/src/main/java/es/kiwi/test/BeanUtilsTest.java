package es.kiwi.test;

import es.kiwi.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

    @Test
    public void test() {
        User user = new User();
        try {
            BeanUtils.setProperty(user, "sex", "female");
            System.out.println(user);

            String sex = BeanUtils.getProperty(user, "sex");
            System.out.println(sex);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
