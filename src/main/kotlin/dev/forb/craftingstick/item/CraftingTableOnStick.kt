package dev.forb.craftingstick.item

import dev.forb.craftingstick.mixin.CraftingTableContainerMixin
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.screen.CraftingScreenHandler
import net.minecraft.screen.ScreenHandlerListener
import net.minecraft.screen.SimpleNamedScreenHandlerFactory
import net.minecraft.screen.slot.SlotActionType
import net.minecraft.text.TranslatableText
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

@Suppress("CAST_NEVER_SUCCEEDS")
class CraftingTableOnStick(settings: Settings) : Item(settings) {

    override fun canMine(state: BlockState?, world: World?, pos: BlockPos?, miner: PlayerEntity?) = false
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {

        if(!world.isClient) {
            user.openHandledScreen(SimpleNamedScreenHandlerFactory({ i, playerInventory, _ ->
                object: CraftingScreenHandler(i, playerInventory)  {

                    override fun onContentChanged(inventory: Inventory) {
                        updateResult(this, world, (this as CraftingTableContainerMixin).player, (this as CraftingTableContainerMixin).input, (this as CraftingTableContainerMixin).result)
                    }

                    override fun close(player: PlayerEntity?) {
                        super.close(player)
                        dropInventory(player, (this as CraftingTableContainerMixin).input)
                    }
                }
            }, TranslatableText("screen.crafting_stick.crafting_table_on_stick")))
        }

        return TypedActionResult.success(user.getStackInHand(hand), false)
    }

}
