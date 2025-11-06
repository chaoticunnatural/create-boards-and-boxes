package com.wren.boardsandboxes.content.equipment.elytra;

import com.simibubi.create.AllItems;
import com.wren.boardsandboxes.CreateBoardsandBoxes;
import com.wren.boardsandboxes.index.CBBItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.phys.Vec3;

public class CardboardElytraItem extends ElytraItem {

    public CardboardElytraItem(Properties properties) {
        super(properties);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(AllItems.CARDBOARD);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return super.canElytraFly(stack, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!(entity instanceof Player player)) return;
        if (level.isClientSide()) return;
        ItemStack chestSlot = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!chestSlot.is(CBBItems.CARDBOARD_ELYTRA.get())) return;
        if (player.isInWaterOrRain()) {
            player.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
        } else if (player.isFallFlying()) {
            Vec3 flightVec = player.getDeltaMovement();
            double flightSpeed = Math.sqrt((flightVec.x * flightVec.x) + (flightVec.y * flightVec.y) + (flightVec.z * flightVec.z));
            CreateBoardsandBoxes.LOGGER.info("Logging player flight speed as {}", flightSpeed);
        }
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                    stack.hurtAndBreak(1, entity, EquipmentSlot.CHEST);
                }

                entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }

        return true;
    }
}
