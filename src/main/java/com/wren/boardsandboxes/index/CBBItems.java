package com.wren.boardsandboxes.index;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.wren.boardsandboxes.CreateBoardsandBoxes;
import com.wren.boardsandboxes.content.equipment.elytra.CardboardElytraItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;

public class CBBItems {
    private static final CreateRegistrate REGISTRATE = CreateBoardsandBoxes.registrate();

    static {
        REGISTRATE.setCreativeTab(CBBCreativeTabs.MAIN_TAB);
    }

    public static final ItemEntry<CardboardElytraItem> CARDBOARD_ELYTRA =
            REGISTRATE.item("cardboard_elytra", CardboardElytraItem::new)
                    .burnTime(1000)
                    .properties(p -> p
                            .stacksTo(1)
                            .durability(92))
                    .register();

    public static void register() {}
}
