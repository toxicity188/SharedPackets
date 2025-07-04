package kr.toxicity.shared.packets;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Bundle packet for custom plugin.
 * @param <T> packet type
 */
public interface PluginBundlePacket<T> extends Iterable<T>, Keyed {

    /**
     * Creates a bundle packet from some iterable object
     * @param vendor vendor
     * @param iterable iterable
     * @return packets
     * @param <T> packets
     */
    static <T> @NotNull PluginBundlePacket<T> of(@NotNull Key vendor, @NotNull Iterable<T> iterable) {
        return new PluginBundlePacket<>() {
            @Override
            public @NotNull Key key() {
                return vendor;
            }

            @Override
            public @NotNull Iterator<T> iterator() {
                return iterable.iterator();
            }
        };
    }
}
