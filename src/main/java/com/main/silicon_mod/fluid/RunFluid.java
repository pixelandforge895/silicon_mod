package com.main.silicon_mod.fluid;

import com.main.silicon_mod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;


public abstract class RunFluid extends ForgeFlowingFluid {

    protected RunFluid(Properties properties) {
        super(properties);
    }

    public static class Source extends RunFluid {
        public Source(Properties properties) {
            super(properties);
        }

        @Override
        public boolean isSource(net.minecraft.world.level.material.FluidState state) {
            return true;
        }


        @Override
        public int getAmount(net.minecraft.world.level.material.FluidState state) {
            return 8;
        }
    }

    public static class Flowing extends RunFluid {

        public Flowing(Properties properties) {
            super(properties);
        }

        private boolean checkWater(LevelAccessor level, BlockPos pos) {

            for (Direction dir : Direction.values()) {

                if (dir == Direction.DOWN) continue;

                FluidState neighbor = level.getFluidState(pos.relative(dir));

                if (neighbor.is(FluidTags.WATER)) {

                    level.setBlock(pos,
                            ModBlocks.QUARTZ_GLASS.get().defaultBlockState(),
                            3);

                    return true;
                }
            }
            return false;
        }

        @Override
        protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {

            if (checkWater(level, pos)) {
                return;
            }

            super.beforeDestroyingBlock(level, pos, state);
        }

        @Override
        public void tick(Level level, BlockPos pos, FluidState state) {
            super.tick(level, pos, state);

            if (level.isClientSide) return;

            checkWater(level, pos);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }


        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }


}