package indi.easy.utils.lang;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Condition<T, R> {

    private final T t;
    private final Function<T, Boolean> function;
    private final R r;

    private Condition(T t, Function<T, Boolean> function) {
        this.t = t;
        this.function = function;
        this.r = null;
    }

    private Condition() {
        throw new IllegalArgumentException("错误的构造请求");
    }

    public static <T, R> Condition<T, R> of(T t, Function<T, Boolean> function) {

        Objects.requireNonNull(function);
        return new Condition<>(t, function);
    }

    public void handle(Consumer<T> consumer) {
        if (function.apply(t)) {
            consumer.accept(t);
        }
    }

    public void handle(Consumer<T> consumerTrue, Consumer<T> consumerFalse) {
        if (function.apply(t)) {
            consumerTrue.accept(t);
        } else {
            consumerFalse.accept(t);
        }
    }

    public R get(Function<T, R> trFunction) {

        if (function.apply(t)) {
            return trFunction.apply(t);
        }
        return r;
    }
}