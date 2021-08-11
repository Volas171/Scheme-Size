package mindustry.game;

import arc.*;
import arc.util.*;
import mindustry.mod.*;
import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.input.*;

public class SchemeSize extends Mod{

    public SchemeSize(){
        Events.on(ClientLoadEvent.class, e -> {
            //wait 10 secs, because... idk
            Time.runTask(10f, () -> {
                // Change Schematics
                Vars.schematics = new Schematics512();
                Vars.schematics.loadSync();

                // Change Input
                if(!Vars.mobile){
                    Vars.control.setInput(new DesktopInput512());
                }

                // Add Settings
                var game = Vars.ui.settings.game;
                game.sliderPref("justspace", 0, 0, 0, 0, i -> i + "");
                game.sliderPref("copysize", 512, 32, 512, 32, i -> Core.bundle.format("setting.blocks", i));
                game.sliderPref("breaksize", 512, 32, 512, 32, i -> Core.bundle.format("setting.blocks", i));
                game.checkPref("copyshow", true);
                game.checkPref("breakshow", true);
                game.cells.get(11).visible(false); // Hide justspace

                // Add Logs
                // Log.info(Vars.schematics);
                // Log.info(Vars.control.input);
            });
        });
    }
}