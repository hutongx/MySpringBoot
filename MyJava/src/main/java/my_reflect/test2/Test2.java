package my_reflect.test2;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws Exception{
        List list = new ArrayList();
        list.add("hello");
        list.add(123);  // 可以放任何类型！

        String str = (String) list.get(0);  // 必须强制转换
        int str2 = (int) list.get(1); // 运行时报错！ClassCastException

        System.out.println(str + " " + str2);


        // 情况1：我明确知道类型
        Class<String> stringClass = String.class;
        String instance = stringClass.newInstance();  // 返回String，不需要转换
        instance = "Hello, World!";
        System.out.println(instance);

        // 情况2：我不知道具体类型
        Class<?> unknownClass = Class.forName("java.lang.String");
        Object o = unknownClass.newInstance();  // 只能返回Object，需要转换
        System.out.println(o.getClass().getName());
    }
}
