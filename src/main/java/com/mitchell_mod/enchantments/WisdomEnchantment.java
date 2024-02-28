package com.mitchell_mod.enchantments;

import com.mojang.datafixers.util.Either;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class WisdomEnchantment extends Enchantment {
    public WisdomEnchantment() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 10 * level;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    public float getAttackDamage(int level, EntityGroup group) {
        assert MinecraftClient.getInstance().player != null;
        int damageMultiplier = MinecraftClient.getInstance().player.experienceLevel;

        int experienceLevel = Math.min(damageMultiplier, 50);

        return Math.max(0, level) * experienceLevel * 0.03f;
    }
}
