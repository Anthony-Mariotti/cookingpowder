package com.amtraxtge.cookingpowder.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//@Debug(export = true)
@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {

    @Inject(method = "canAcceptRecipeOutput", at = @At("HEAD"), cancellable = true)
    private static void canAcceptRecipeOutput(
            DynamicRegistryManager registryManager, RecipeEntry<?> recipe, DefaultedList<ItemStack> slots, int count,
            CallbackInfoReturnable<Boolean> cir) {
         ItemStack stack = slots.get(0);
         if (stack.isOf(Items.GUNPOWDER)) {
             cir.setReturnValue(true);
         }
    }

    @Inject(method="tick", at = @At( value = "INVOKE",
            target = "Lnet/minecraft/block/entity/AbstractFurnaceBlockEntity;craftRecipe(Lnet/minecraft/registry/DynamicRegistryManager;Lnet/minecraft/recipe/RecipeEntry;Lnet/minecraft/util/collection/DefaultedList;I)Z"))
    private static void tick(
            World world, BlockPos pos, BlockState state, AbstractFurnaceBlockEntity blockEntity,
            CallbackInfo ci) {
        ItemStack stack = blockEntity.getStack(0);
        if (stack.isOf(Items.GUNPOWDER)) {
            if (!world.isClient) {
                stack.decrement(1);
                world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.0f, World.ExplosionSourceType.BLOCK);
            }
        }
    }
}

