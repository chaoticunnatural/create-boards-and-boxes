package com.wren.boardsandboxes.index;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.wren.boardsandboxes.CreateBoardsandBoxes;

public class CBBBlocks {
    private static final CreateRegistrate REGISTRATE = CreateBoardsandBoxes.registrate();

    static {
        REGISTRATE.setCreativeTab(CBBCreativeTabs.MAIN_TAB);
    }
}
