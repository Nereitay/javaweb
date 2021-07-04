package es.kiwi.test;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        add(map);
        List<Per> list = (List<Per>) map.get("list");
        System.out.println(list.get(0).getName());
    }

    private static void add(Map<String, Object> map) {
        List<Per> list = new ArrayList<>();
        list.add(new Per("Test"));
        map.put("list", list);
    }

    private static class Per{
        private String name;

        @Override
        public String toString() {
            return "Per{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public Per() {
        }

        public Per(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

