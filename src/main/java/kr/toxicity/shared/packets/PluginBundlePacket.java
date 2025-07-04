package kr.toxicity.shared.packets;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Bundle packet for custom plugin.
 * @param <T> packet type
 */
public interface PluginBundlePacket<T> extends Iterable<T> {

    /**
     * Gets vendor name
     * @return vendor
     */
    @NotNull String vendor();

    /**
     * Creates a bundle packet from some iterable object
     * @param vendor vendor
     * @param iterable iterable
     * @return packets
     * @param <T> packets
     */
    static <T> @NotNull PluginBundlePacket<T> of(@NotNull String vendor, @NotNull Iterable<T> iterable) {
        return new PluginBundlePacket<>() {
            @Override
            public @NotNull String vendor() {
                return vendor;
            }

            @Override
            public @NotNull Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }
}
