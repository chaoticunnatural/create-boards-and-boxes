package com.wren.boardsandboxes;

import com.wren.boardsandboxes.client.CardboardElytraLayerRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import java.util.List;

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

    @SubscribeEvent
    public static void addLayers(EntityRenderersEvent.AddLayers event) {
        for (String skin : List.of("default", "slim")) {
            PlayerRenderer renderer = event.getSkin(PlayerSkin.Model.byName(skin));
            if (renderer != null) {
                renderer.addLayer(new CardboardElytraLayerRenderer<>(renderer, event.getEntityModels()));
            }
        }
    }
}
