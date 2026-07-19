package dev.flomik.delightfulcreators.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class DCServerConfig {

    public static final ModConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        SERVER = new Server(builder);
        SERVER_SPEC = builder.build();
    }

    public static class Server {

        public final ModConfigSpec.BooleanValue mechanicalCutterBasinProcessing;

        Server(ModConfigSpec.Builder builder) {
            builder.push("mechanicalCutter");

            mechanicalCutterBasinProcessing = builder
                    .comment(
                            "Whether the Mechanical Cutter also processes items placed in a Basin two blocks",
                            "below it, the same way Create's own Mechanical Press does. Disable this to keep",
                            "the Cutter limited to belt/depot and world item processing only.")
                    .define("basinProcessing", true);

            builder.pop();
        }
    }
}
