package net.flomik.delightfulcreators.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DCServerConfig {

    public static final ForgeConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        SERVER = new Server(builder);
        SERVER_SPEC = builder.build();
    }

    public static class Server {

        public final ForgeConfigSpec.BooleanValue mechanicalCutterBasinProcessing;

        Server(ForgeConfigSpec.Builder builder) {
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
