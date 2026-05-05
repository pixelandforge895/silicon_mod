package com.main.silicon_mod.fluid;

import com.main.silicon_mod.registry.ModDamageTypes;
import com.main.silicon_mod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;

import java.util.function.Supplier;

public class SiliconDioxideBlock extends LiquidBlock {
    public SiliconDioxideBlock(Supplier<? extends FlowingFluid> fluid,
                               Properties properties) {
        super(fluid, properties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);

        if (!level.isClientSide) {
            if (entity.tickCount % 2 == 0) {
                entity.hurt(ModDamageTypes.silicon(level), 4.0F);
                entity.setDeltaMovement(0, 0, 0);
                entity.hurtMarked = true;
            }
        }
    }
    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos,
                                Block block, BlockPos FromPos, boolean isMoving) {

        super.neighborChanged(state, level, pos, block, FromPos, isMoving);

        if (level.isClientSide) return;

        for (Direction dir : Direction.values()) {

            BlockPos offsetPos = pos.relative(dir);
            FluidState neighborFluid = level.getFluidState(offsetPos);

            if (neighborFluid.is(FluidTags.WATER)) {

                level.setBlock(pos,
                        ModBlocks.QUARTZ_GLASS.get().defaultBlockState(),
                        3);

                return;
            }
        }
    }
}
