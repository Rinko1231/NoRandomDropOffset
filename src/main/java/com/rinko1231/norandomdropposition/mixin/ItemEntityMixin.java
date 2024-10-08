package com.rinko1231.norandomdropposition.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    // 在构造函数执行后注入代码，修改随机偏移量
    @Inject(method = "<init>(Lnet/minecraft/world/level/Level;DDDLnet/minecraft/world/item/ItemStack;DDD)V", at = @At("TAIL"))
    private void onConstruct(Level p_149663_, double p_149664_, double p_149665_, double p_149666_, ItemStack p_149667_, double vecX, double vecY, double vecZ, CallbackInfo ci) {
       ItemEntity self = (ItemEntity) (Object) this;
       self.setDeltaMovement(0.0D, 0.2D, 0.0D);
    }
}
