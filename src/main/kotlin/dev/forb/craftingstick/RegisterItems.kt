package dev.forb.craftingstick

import dev.forb.craftingstick.item.CraftingTableOnStick
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object RegisterItems {
    private val GROUP: ItemGroup = FabricItemGroupBuilder
        .create(Identifier(MOD_ID, "crafting_stick"))
        .icon { ItemStack(OAK_CRAFTING_TABLE_ON_STICK) }
        .build()

    private val craftingStickSettings = FabricItemSettings().group(GROUP).maxCount(1).maxDamage(128)
    private val OAK_CRAFTING_TABLE_ON_STICK         = CraftingTableOnStick(craftingStickSettings)
    private val BIRCH_CRAFTING_TABLE_ON_STICK       = CraftingTableOnStick(craftingStickSettings)
    private val SPRUCE_CRAFTING_TABLE_ON_STICK      = CraftingTableOnStick(craftingStickSettings)
    private val JUNGLE_CRAFTING_TABLE_ON_STICK      = CraftingTableOnStick(craftingStickSettings)
    private val ACACIA_CRAFTING_TABLE_ON_STICK      = CraftingTableOnStick(craftingStickSettings)
    private val DARK_OAK_CRAFTING_TABLE_ON_STICK    = CraftingTableOnStick(craftingStickSettings)
    private val CRIMSON_CRAFTING_TABLE_ON_STICK     = CraftingTableOnStick(craftingStickSettings.fireproof())
    private val WARPED_CRAFTING_TABLE_ON_STICK      = CraftingTableOnStick(craftingStickSettings.fireproof())

    fun register() {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "oak_crafting_stick"), OAK_CRAFTING_TABLE_ON_STICK)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "birch_crafting_stick"), BIRCH_CRAFTING_TABLE_ON_STICK)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "spruce_crafting_stick"), SPRUCE_CRAFTING_TABLE_ON_STICK)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "jungle_crafting_stick"), JUNGLE_CRAFTING_TABLE_ON_STICK)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "acacia_crafting_stick"), ACACIA_CRAFTING_TABLE_ON_STICK)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "dark_oak_crafting_stick"), DARK_OAK_CRAFTING_TABLE_ON_STICK)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "crimson_crafting_stick"), CRIMSON_CRAFTING_TABLE_ON_STICK)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "warped_crafting_stick"), WARPED_CRAFTING_TABLE_ON_STICK)
    }

}
