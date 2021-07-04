package es.kiwi.annotation;

//@MyAnno(age = 12)
//@MyAnno(12)
@MyAnno(value = 12, per = Person.P1, strs = {"aaa", "bbb"}, anno2 = @MyAnno2)
@MyAnno3
public class Worker {

    @MyAnno3
    public String name = "aaa";

    @MyAnno3
    public void show() {

    }

}
