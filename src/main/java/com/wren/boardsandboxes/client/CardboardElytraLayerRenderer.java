package com.wren.boardsandboxes.client;

import com.wren.boardsandboxes.CreateBoardsandBoxes;
import com.wren.boardsandboxes.index.CBBItems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class CardboardElytraLayerRenderer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {

    public CardboardElytraLayerRenderer(RenderLayerParent<T, M> renderer, EntityModelSet modelSet) {
        super(renderer, modelSet);
    }

    private static final ResourceLocation TEXTURE = CreateBoardsandBoxes.asTextureResource("armor/cardboard_elytra");

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
        return TEXTURE;
    }

    @Override
    public boolean shouldRender(ItemStack stack, T entity) {
        return stack.is(CBBItems.CARDBOARD_ELYTRA.get());
    }
}
