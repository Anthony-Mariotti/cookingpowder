package com.amtraxtge.cookingpowder.mixin;

import com.amtraxtge.cookingpowder.utility.CookingPowderLogger;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FurnaceOutputSlot.class)
public class FurnaceOutputSlotMixin {

    @Inject(method = "onCrafted(Lnet/minecraft/item/ItemStack;)V", at = @At("HEAD"))
    private void onCrafted(ItemStack stack, CallbackInfo info) {
        CookingPowderLogger.info("onCrafted g");
    }

    @Inject(method = "onCrafted(Lnet/minecraft/item/ItemStack;I)V", at = @At("HEAD"))
    private void onCrafted(ItemStack stack, int amount, CallbackInfo info) {
        CookingPowderLogger.info("onCrafted amount");
    }

    @Inject(method = "")
    private void setStack(CallbackInfo info) {

    }
}
