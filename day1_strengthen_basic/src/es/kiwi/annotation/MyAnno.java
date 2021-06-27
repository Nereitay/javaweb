package es.kiwi.annotation;

/**
 * 自定义注解
 *
 * * 格式：
 * 		元注解
 * 		public @interface 注解名称{
 * 			属性列表;
 *                }
 *
 *  * 本质：是一个接口，该接口默认继承Annotation接口
 *      public interface MyAnno extends java.lang.annotation.Annotation {}
 *
 *  * 属性：接口中的抽象方法
 * 		* 要求：
 * 			1. 属性的返回值类型有下列取值
 * 				* 基本数据类型
 * 				* String
 * 				* 枚举
 * 				* 注解
 * 				* 以上类型的数组
 * 	        2. 定义了属性，在使用时需要给属性赋值
 * 				1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
 * 				2. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可。
 * 				3. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略
 *
 * 	* 元注解：用于描述注解的注解
 * 		* @Target：描述注解能够作用的位置
 * 			* ElementType取值：
 * 				* TYPE：可以作用于类上
 * 				* METHOD：可以作用于方法上
 * 				* FIELD：可以作用于成员变量上
 * 		* @Retention：描述注解被保留的阶段
 * 			* @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
 * 		* @Documented：描述注解是否被抽取到api文档中
 * 		* @Inherited：描述注解是否被子类继承
 */
public @interface MyAnno {

//    int age();
    int value();
    String name() default "Julia";
    Person per();
    MyAnno2 anno2();
    String[] strs();


}
