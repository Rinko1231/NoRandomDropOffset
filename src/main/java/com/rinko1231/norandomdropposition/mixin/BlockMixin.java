package com.rinko1231.norandomdropposition.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "popResource(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/item/ItemStack;)V",
            at = @At("HEAD"), cancellable = true)
    private static void injectPopResource(Level p_49841_, BlockPos p_49842_, ItemStack p_49843_, CallbackInfo ci) {
        double fixedX = p_49842_.getX() + 0.5D;
        double fixedY = p_49842_.getY() + 0.5D;
        double fixedZ = p_49842_.getZ() + 0.5D;

        ItemEntity itemEntity = new ItemEntity(p_49841_, fixedX, fixedY, fixedZ, p_49843_);

        // 设置物品的速度为零
        itemEntity.setDeltaMovement(0, 0, 0);

        // 将物品实体加入世界中
        if (!p_49841_.isClientSide && !p_49843_.isEmpty() && p_49841_.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && !p_49841_.restoringBlockSnapshots) {
            itemEntity.setDefaultPickUpDelay();
            p_49841_.addFreshEntity(itemEntity);
        }


        ci.cancel();
    }
}