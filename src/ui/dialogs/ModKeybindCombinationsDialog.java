package mindustry.ui.dialogs;

import static arc.Core.*;

public class ModKeybindCombinationsDialog extends BaseDialog{

	public String main;

	public ModContentSelectDialog(){
		super("keycomb.name");
		addCloseButton();

		main = bundle.get("keycomb.main");

		// bad code, but I`m too lazy
		template("@keycomb.view_comb", "keybind.block_info.name");
		template("@keycomb.teleport", "keybind.select.name");
		template("@keycomb.self_dest", "keybind.respawn.name");
		template("@keycomb.spawn_unit", "keybind.change_unit.name");
	}

	private void template(String name, String comb){
		String sec = bundle.get("keybind.block_info.name");
		cont.add(name, Color.white).left().padRight(20).padLeft(8);
		cont.add(main + " + " + sec, Pal.accent).left().minWidth(90).padRight(20);
		cont.row();
	}
}