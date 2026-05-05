package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;

import com.main.silicon_mod.fluid.RunFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, SiliconMod.MOD_ID);

    private static ForgeFlowingFluid.Properties PROPERTIES;

    public static final RegistryObject<FlowingFluid> SOURCE =
            FLUIDS.register("silicon_dioxide",
                    () -> new RunFluid.Source(PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING =
            FLUIDS.register("flowing_silicon_dioxide",
                    () -> new RunFluid.Flowing(PROPERTIES));


    // ★staticブロックで後から初期化
    static {
        PROPERTIES = new ForgeFlowingFluid.Properties(
                ModFluidTypes.SILICON_DIOXIDE_TYPE,
                SOURCE,
                FLOWING
        )
                .slopeFindDistance(2)
                .levelDecreasePerBlock(2)
                .tickRate(30)
                .block(ModBlocks.SILICON_DIOXIDE::get)
                .bucket(ModItems.SILICON_DIOXIDE_BUCKET::get);
    }

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}