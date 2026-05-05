package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

public class ModFluidTypes {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, SiliconMod.MOD_ID);

    public static final RegistryObject<FluidType> SILICON_DIOXIDE_TYPE =
            FLUID_TYPES.register("silicon_dioxide_type", () ->
                    new FluidType(FluidType.Properties.create()
                            .density(2100)     // 重さ
                            .viscosity(10000)   // 粘性（ドロドロ）
                            .temperature(2000) // 高温
                            .lightLevel(15)    // 発光
                    ) {

                        @Override
                        public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                            consumer.accept(new IClientFluidTypeExtensions() {

                                @Override
                                public ResourceLocation getStillTexture() {
                                    return ResourceLocation.fromNamespaceAndPath(SiliconMod.MOD_ID, "block/silicon_dioxide");
                                }

                                @Override
                                public ResourceLocation getFlowingTexture() {
                                    return ResourceLocation.fromNamespaceAndPath(SiliconMod.MOD_ID, "block/silicon_dioxide");
                                }
                            });
                        }
                    });


    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}