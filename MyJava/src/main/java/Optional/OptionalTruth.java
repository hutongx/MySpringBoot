package Optional;

import java.util.Optional;

public class OptionalTruth {

    // 传统的痛苦方式 - 到处都是null检查
    public static void traditionalWay() {
        System.out.println("=== 传统方式：到处检查null ===");

        String result = findUser(1);
        if (result != null) {
            String upperCase = result.toUpperCase();
            if (upperCase.length() > 5) {
                System.out.println("传统方式结果: " + upperCase);
            } else {
                System.out.println("传统方式: 长度不够");
            }
        } else {
            System.out.println("传统方式: 用户不存在");
        }
    }

    // Optional方式 - 就是把null检查包装了一下
    public static void optionalWay() {
        System.out.println("\n=== Optional方式：包装null检查 ===");

        String result = findUserOptional(1)
                .map(String::toUpperCase)
                .filter(s -> s.length() > 5)
                .orElse("要么用户不存在，要么长度不够");

        System.out.println("Optional方式结果: " + result);
    }

    // 模拟查找用户 - 传统方式
    public static String findUser(int id) {
        if (id == 1) return "alice";
        if (id == 2) return "bob";
        return null; // 找不到就返回null
    }

    // 模拟查找用户 - Optional方式
    public static Optional<String> findUserOptional(int id) {
        if (id == 1) return Optional.of("alice");
        if (id == 2) return Optional.of("bob");
        return Optional.empty(); // 找不到就返回空Optional
    }

    public static void main(String[] args) {
        System.out.println("Optional到底是什么？就是个防null的包装盒！");

        traditionalWay();
        optionalWay();

        System.out.println("\n=== Optional的真实用途 ===");
        System.out.println("1. 方法返回值可能为null时，用Optional包装");
        System.out.println("2. 避免调用者忘记检查null");
        System.out.println("3. 链式调用更优雅");

        // 最常见的场景：从Map或数据库查询
        demonstrateCommonUse();

        System.out.println("\n=== 别被那些花里胡哨的方法迷惑 ===");
        System.out.println("核心就这几个方法:");
        System.out.println("- Optional.of(value)        // 包装非null值");
        System.out.println("- Optional.ofNullable(value) // 包装可能null的值");
        System.out.println("- Optional.empty()           // 空值");
        System.out.println("- isPresent()                // 检查是否有值");
        System.out.println("- orElse(defaultValue)       // 有值就返回，没值返回默认值");
        System.out.println("- ifPresent(action)          // 有值就执行操作");

        System.out.println("\n其他那些map、flatMap、filter都是为了链式调用好看点");
        System.out.println("本质还是在做null检查！");
    }

    public static void demonstrateCommonUse() {
        System.out.println("\n=== 最常见使用场景 ===");

        // 场景1: 从配置中获取值
        String dbUrl = getConfig("database.url").orElse("jdbc:h2:mem:testdb");
        System.out.println("数据库URL: " + dbUrl);

        // 场景2: 查找用户
        findUserOptional(999).ifPresent(user ->
                System.out.println("找到用户: " + user)
        );

        // 如果没找到用户，上面的代码不会执行，避免了null检查
        if (!findUserOptional(999).isPresent()) {
            System.out.println("用户999不存在");
        }

        // 场景3: 安全的字符串操作
        String input = null;
        String result = Optional.ofNullable(input)
                .map(String::trim)
                .orElse("输入为空");
        System.out.println("处理结果: " + result);
    }

    // 模拟配置获取
    public static Optional<String> getConfig(String key) {
        if ("database.url".equals(key)) {
            return Optional.of("jdbc:mysql://localhost:3306/mydb");
        }
        return Optional.empty();
    }
}
