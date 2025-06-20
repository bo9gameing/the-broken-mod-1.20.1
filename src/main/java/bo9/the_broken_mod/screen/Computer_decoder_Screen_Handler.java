package bo9.the_broken_mod.screen;

import bo9.the_broken_mod.block.entity.Computer_Decoder_Entity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class Computer_decoder_Screen_Handler extends ScreenHandler {
    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }


    private final    Inventory inventory;
    private final   PropertyDelegate propertyDelegate;
    public  final   Computer_Decoder_Entity blockEntity;

    public Computer_decoder_Screen_Handler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
            new ArrayPropertyDelegate(2));
    }





    public Computer_decoder_Screen_Handler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity,
                                           PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenhandlers.COMPUTER_DECODER_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 2);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = arrayPropertyDelegate;
        this.blockEntity = ((Computer_Decoder_Entity) blockEntity);

        this.addSlot(new Slot(inventory, 0, 25,33));
        this.addSlot(new Slot(inventory, 1, 116,15));
        this.addSlot(new Slot(inventory, 2, 151,33));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }


    public int getScaledProgress(){
        int conversion = this.propertyDelegate.get(0);
        int maxConversion = this.propertyDelegate.get(1);
        int progressArrowSize = 99;

        return maxConversion != 0 && conversion != 0 ? conversion * progressArrowSize / maxConversion : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if(slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }


}
