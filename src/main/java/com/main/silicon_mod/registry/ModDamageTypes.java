package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> SILICON_DIOXIDE =
            ResourceKey.create(
                    Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath(SiliconMod.MOD_ID, "silicon_dioxide")
            );

    public static DamageSource silicon(Level level) {
        Holder<DamageType> holder =
                level.registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(SILICON_DIOXIDE);

        return new DamageSource(holder);
    }
}
