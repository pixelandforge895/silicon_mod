package com.main.silicon_mod.datagen.server;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.registry.ModDamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DamageTypeProvider extends DatapackBuiltinEntriesProvider {

    // ★ レジストリ構築
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DAMAGE_TYPE, DamageTypeProvider::bootstrap);

    public DamageTypeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SiliconMod.MOD_ID));
    }

    public static void bootstrap(BootstrapContext<DamageType> context) {

        context.register(
                ModDamageTypes.SILICON_DIOXIDE,
                new DamageType(
                        "silicon_dioxide", // death message key
                        DamageScaling.ALWAYS,
                        0.1F               // exhaustion
                )
        );
    }
}