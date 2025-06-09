package Optional;

import java.util.Optional;

public class OptionalChecking {
    public static void main(String[] args) {
        Optional<String> presentOptional = Optional.of("Hello");
        Optional<String> emptyOptional = Optional.empty();

        // 1. isPresent() - 检查值是否存在
        System.out.println("Present optional has value: " + presentOptional.isPresent());
        System.out.println("Empty optional has value: " + emptyOptional.isPresent());

        // 2. isEmpty() - Java 11新增，检查是否为空
        System.out.println("Present optional is empty: " + presentOptional.isEmpty());
        System.out.println("Empty optional is empty: " + emptyOptional.isEmpty());

        // 3. get() - 获取值，如果为空会抛出NoSuchElementException
        if (presentOptional.isPresent()) {
            System.out.println("Value: " + presentOptional.get());
        }

        // 不安全的做法 - 可能抛出异常
        try {
            String value = emptyOptional.get();
        } catch (Exception e) {
            System.out.println("get() on empty Optional throws: " + e.getClass().getSimpleName());
        }

        // 4. orElse() - 提供默认值
        String value1 = presentOptional.orElse("Default");
        String value2 = emptyOptional.orElse("Default");
        System.out.println("Present with orElse: " + value1);
        System.out.println("Empty with orElse: " + value2);

        // 5. orElseGet() - 通过Supplier提供默认值
        String value3 = presentOptional.orElseGet(() -> "Computed Default");
        String value4 = emptyOptional.orElseGet(() -> {
            System.out.println("Computing default value...");
            return "Computed Default";
        });
        System.out.println("Present with orElseGet: " + value3);
        System.out.println("Empty with orElseGet: " + value4);

        // 6. orElseThrow() - 抛出指定异常
        try {
            String value5 = emptyOptional.orElseThrow(() ->
                    new IllegalStateException("Value is not present"));
        } catch (IllegalStateException e) {
            System.out.println("orElseThrow: " + e.getMessage());
        }

        // 7. orElseThrow() - Java 10新增，抛出NoSuchElementException
        try {
            String value6 = emptyOptional.orElseThrow();
        } catch (Exception e) {
            System.out.println("orElseThrow() throws: " + e.getClass().getSimpleName());
        }
    }
}
