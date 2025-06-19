package bo9.the_broken_mod.block.entity;

import bo9.the_broken_mod.item.ModItems;
import bo9.the_broken_mod.screen.Computer_decoder_Screen_Handler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Computer_Decoder_Entity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory{

    private final DefaultedList<ItemStack> invetorY = DefaultedList.ofSize(64,ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT_1 = 1;
    private static final int OUTPUT_SLOT_2 = 2;


    protected final PropertyDelegate propertyDelegate;

    private int progress = 0;
    private int maxprogress = 72;


    public Computer_Decoder_Entity( BlockPos pos, BlockState state) {
        super(ModBlockEntitionBlock.COMPUTER_DECODER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> Computer_Decoder_Entity.this.progress;
                    case 1 -> Computer_Decoder_Entity.this.maxprogress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> Computer_Decoder_Entity.this.progress = value;
                    case 1 -> Computer_Decoder_Entity.this.maxprogress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }



    @Override
    public DefaultedList<ItemStack> getItems() {
        return invetorY;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
    buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("computer_decoder.be");
    }


    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, invetorY);
        nbt.putInt("computer_decoder_entity.conversion", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, invetorY);
        progress = nbt.getInt("computer_decoder_entity.conversion");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new Computer_decoder_Screen_Handler(syncId, playerInventory,this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if(world.isClient()) {
            return;
        }

        if(isOutputSlotEmptyOrReceable()) {
            if(this.hasRecipe()){
                this.increaseCraftProgress();
                markDirty(world, pos, state);


                if(hasCraftingFinish()){
                    this.craftingItem();
                    this.resetProgress();

                }
            }else{
                this.resetProgress();
            }
        }else{
            this.resetProgress();
            markDirty(world,pos,state);
        }



    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftingItem() {
        this.removeStack(INPUT_SLOT, 1);
        ItemStack result1 = new ItemStack(ModItems.CORUPEM_NUGET);
        ItemStack result2 = new ItemStack(Items.RAW_COPPER);

        this.setStack(OUTPUT_SLOT_1, new ItemStack(result1.getItem(), getStack(OUTPUT_SLOT_1).getCount() + result1.getCount()));
        this.setStack(OUTPUT_SLOT_2, new ItemStack(result2.getItem(), getStack(OUTPUT_SLOT_2).getCount() + result2.getCount()));

    }

    private boolean hasCraftingFinish() {
return progress >= maxprogress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        ItemStack result1 = new ItemStack(ModItems.CORUPEM_NUGET);
        ItemStack result2 = new ItemStack(Items.RAW_COPPER);
        boolean hasInput = getStack(INPUT_SLOT).getItem() == ModItems.RAW_COPPER_INFESTED;

        return hasInput && canInsertAmountIntoOutputSlot(result1,result2) && canInsertItemIntoOutputSlot(result1.getItem(), result2.getItem());
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result1, ItemStack result2) {
        return this.getStack(OUTPUT_SLOT_1).getCount() + result1.getCount() > getStack(OUTPUT_SLOT_1).getMaxCount() &&
                this.getStack(OUTPUT_SLOT_2).getCount() + result2.getCount() > getStack(OUTPUT_SLOT_2).getMaxCount();
    }

    private boolean canInsertItemIntoOutputSlot(Item item1, Item item2) {
        return  this.getStack(OUTPUT_SLOT_1).getItem() == item1 || this.getStack(OUTPUT_SLOT_1).isEmpty() &&
                this.getStack(OUTPUT_SLOT_2).getItem() == item2 || this.getStack(OUTPUT_SLOT_2).isEmpty();
    }



    private boolean isOutputSlotEmptyOrReceable() {
        return  this.getStack(OUTPUT_SLOT_1).isEmpty() || this.getStack(OUTPUT_SLOT_1).getCount() < this.getStack(OUTPUT_SLOT_1).getMaxCount() &&
                this.getStack(OUTPUT_SLOT_2).isEmpty() || this.getStack(OUTPUT_SLOT_2).getCount() < this.getStack(OUTPUT_SLOT_2).getMaxCount();
    }
}
