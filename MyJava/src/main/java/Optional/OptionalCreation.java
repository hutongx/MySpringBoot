package Optional;

import java.util.Optional;

public class OptionalCreation {
    public static void main(String[] args) {
        // 1. 创建空的Optional
        Optional<String> empty = Optional.empty();
        System.out.println("Empty Optional: " + empty);

        // 2. 创建包含非null值的Optional
        Optional<String> nonNull = Optional.of("Hello World");
        System.out.println("Non-null Optional: " + nonNull);

        // 3. 创建可能包含null值的Optional
        String nullableValue = null;
        Optional<String> nullable = Optional.ofNullable(nullableValue);
        System.out.println("Nullable Optional: " + nullable);

        String nonNullValue = "Not null";
        Optional<String> notNull = Optional.ofNullable(nonNullValue);
        System.out.println("Not null Optional: " + notNull);

        // 注意：Optional.of(null) 会抛出NullPointerException
        try {
            Optional<String> willThrow = Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("Optional.of(null) throws NullPointerException");
        }
    }
}
