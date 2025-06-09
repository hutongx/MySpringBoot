package Optional;

import java.util.*;

public class OptionalBestPractices {

    // ✅ 好的实践：作为方法返回类型
    public Optional<String> findUserName(int id) {
        // 模拟查找逻辑
        return id > 0 ? Optional.of("User" + id) : Optional.empty();
    }

    // ❌ 不推荐：Optional作为方法参数
    public void badMethod(Optional<String> name) {
        // 这样做会让调用者困惑
    }

    // ✅ 推荐：直接使用可null的参数
    public void goodMethod(String name) {
        Optional.ofNullable(name)
                .ifPresent(n -> System.out.println("Name: " + n));
    }

    // ❌ 不推荐：Optional作为字段
    public class BadUser {
        private Optional<String> name; // 不要这样做
        private Optional<String> email; // 不要这样做
    }

    // ✅ 推荐：普通字段，getter返回Optional
    public class GoodUser {
        private String name;
        private String email;

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }


    public static void main(String[] args) {
        OptionalBestPractices examples = new OptionalBestPractices();

        System.out.println("=== 正确使用模式 ===");

        // ✅ 好的实践：避免null检查
        String result1 = examples.findUserName(0)
                .map(String::toUpperCase)
                .orElse("UNKNOWN");
        System.out.println("Result 1: " + result1);

        // ✅ 好的实践：链式操作
        String result2 = Optional.of("  hello world  ")
                .filter(s -> !s.trim().isEmpty())
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("EMPTY");
        System.out.println("Result 2: " + result2);

        // ✅ 好的实践：使用ifPresent而不是isPresent + get
        Optional<String> optional = Optional.of("Hello");
        optional.ifPresent(value -> System.out.println("Value: " + value));

        System.out.println("\n=== 错误使用模式 ===");

        // ❌ 错误：不要这样做
        Optional<String> badOptional = Optional.of("test");
        if (badOptional.isPresent()) {
            String value = badOptional.get(); // 应该直接使用ifPresent
            System.out.println("Bad pattern: " + value);
        }

        // ❌ 错误：Optional.of(null)
        try {
            Optional<String> nullOptional = Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("Never use Optional.of(null)");
        }

        // ❌ 错误：在集合中使用Optional
        List<Optional<String>> badList = Arrays.asList(
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B")
        );
        System.out.println("Bad list size: " + badList.size());

        // ✅ 更好：过滤null值
        List<String> goodList = Arrays.asList("A", null, "B")
                .stream()
                .filter(Objects::nonNull)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Good list: " + goodList);

        System.out.println("\n=== 性能考虑 ===");

        // ✅ orElse vs orElseGet的性能差异
        String expensiveDefault = "Expensive computation";

        // orElse: 总是计算默认值
        String result3 = Optional.of("value").orElse(expensiveDefault);

        // orElseGet: 只在需要时计算默认值
        String result4 = Optional.of("value").orElseGet(() -> {
            System.out.println("This won't be called");
            return "Expensive computation";
        });

        // 当Optional为空时
        String result5 = Optional.<String>empty().orElseGet(() -> {
            System.out.println("This will be called");
            return "Lazy computation";
        });

        System.out.println("\n=== 复杂场景处理 ===");

        // 处理多个Optional
        Optional<String> opt1 = Optional.of("Hello");
        Optional<String> opt2 = Optional.of("World");
        Optional<String> opt3 = Optional.empty();

        // 组合多个Optional
        Optional<String> combined = opt1.flatMap(s1 ->
                opt2.map(s2 -> s1 + " " + s2)
        );
        System.out.println("Combined: " + combined.orElse("Not available"));

        // 处理Optional链
        Optional<String> result6 = processOptionalChain("input");
        System.out.println("Chain result: " + result6.orElse("Failed"));

        System.out.println("\n=== 与Stream API结合 ===");

        List<String> inputs = Arrays.asList("1", "2", "invalid", "3", "4");

        // 安全转换并收集结果
        List<Integer> numbers = inputs.stream()
                .map(examples::safeParseInt)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println("Parsed numbers: " + numbers);

        // Java 9+ 更优雅的方式
        List<Integer> numbers2 = inputs.stream()
                .map(examples::safeParseInt)
                .flatMap(Optional::stream)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println("Parsed numbers (Java 9+): " + numbers2);
    }

    // 辅助方法：安全的字符串转整数
    private Optional<Integer> safeParseInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    // 复杂的Optional链式处理
    private static Optional<String> processOptionalChain(String input) {
        return Optional.ofNullable(input)
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .map(s -> "Processed: " + s);
    }
}
