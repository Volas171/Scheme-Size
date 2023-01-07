package scheme.tools;

import arc.Events;
import arc.struct.Queue;
import arc.util.Ratekeeper;
import arc.util.Timer;
import mindustry.game.EventType.*;
import mindustry.gen.Call;

/** Prevents ddos ban. */
public class MessageQueue {

    public static Queue<String> messages = new Queue<>();
    public static Ratekeeper dropRate = new Ratekeeper();

    public static void load() {
        Events.run(WorldLoadEvent.class, messages::clear);

        Timer.schedule(() -> {
            if (messages.isEmpty()) return;
            Call.sendChatMessage(messages.removeFirst());
        }, 0f, .1f);
    }

    public static void send(String message) {
        messages.add(message);
    }

    public static boolean drop() {
        return dropRate.allow(1000L, 40);
    }
}
