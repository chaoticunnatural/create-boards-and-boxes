package com.wren.boardsandboxes;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = CreateBoardsandBoxes.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CreateBoardsandBoxes.MODID, value = Dist.CLIENT)
public class CreateBoardsandBoxesClient {
    public CreateBoardsandBoxesClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        CreateBoardsandBoxes.LOGGER.info("putting your client instance in a box muahahaha");
        CreateBoardsandBoxes.LOGGER.info("successfully put {} in a box muahahaha", Minecraft.getInstance().getUser().getName());
    }
}
