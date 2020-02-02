package ru.spbstu.amd.javaed.pipeline;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;

/**
 * Represents entity that provides data via {@link DataAccessor}.
 */
public interface Producer {

    /**
     * @param acceptableOutputDataTypes Types, that produces will produce.
     * @return Data accessor for data with chosen type.
     */
    @NotNull DataAccessor getDataAccessor(@NotNull Set<Class<?>> acceptableOutputDataTypes);

    /**
     * Represents data accessor, such a pipe, consumer can get data from.
     */
    interface DataAccessor {

        /**
         * @return Data or empty if data is not still ready (try to get later).
         */
        @NotNull Optional<Object> get();

        /**
         * @return Has input stream ended.
         */
        boolean isEnd();
    }
}
