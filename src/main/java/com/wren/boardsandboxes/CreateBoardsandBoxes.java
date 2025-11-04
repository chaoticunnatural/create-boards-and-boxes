package com.wren.boardsandboxes;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.wren.boardsandboxes.index.CBBCreativeTabs;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(CreateBoardsandBoxes.MODID)
public class CreateBoardsandBoxes {

    public static final String MODID = "boardsandboxes";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID)
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public CreateBoardsandBoxes(IEventBus modEventBus, ModContainer modContainer) {

        REGISTRATE.registerEventListeners(modEventBus);

        CBBCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("boxing up common setup");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("server is starting, making boxes");
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}
