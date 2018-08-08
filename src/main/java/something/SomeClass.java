package something;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class SomeClass {

    public static @NotNull List<Object> foo(@NotNull Thing someThing) {

        final @NotNull List<Object> ret = new ArrayList<>();

        someThing.forEachSupplier(thing -> {
            if (thing.get()) {
                return null;
            }

            ret.add(none());

            return null;
        });

        return ret;
    }

    private static final @NotNull Object NONE = new Object();
    private static @NotNull Object none() { return NONE; }

    class Thing {
        void forEachSupplier(Function<Supplier<Boolean>,?> s) { }
    }
}
