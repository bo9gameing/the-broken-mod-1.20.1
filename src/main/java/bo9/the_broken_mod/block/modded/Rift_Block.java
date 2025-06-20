package bo9.the_broken_mod.block.modded;


import bo9.the_broken_mod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;




public class Rift_Block extends Block {
    public static final IntProperty CHARGE = IntProperty.of("charge", 0 , 4);



    public Rift_Block(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CHARGE, 0));

    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if(!world.isClient){
            if (hand == Hand.MAIN_HAND && !isCharge(itemStack) && isCharge(player.getStackInHand(Hand.OFF_HAND))) {
                return ActionResult.PASS;
            } else if (isCharge(itemStack) && canCharge(state)) {
                world.setBlockState(pos, state.with( CHARGE,(Integer)state.get(CHARGE) + 1));
            }
        }

        return ActionResult.SUCCESS;
    }



    private static boolean isCharge(ItemStack stack) {
        return stack.isOf(ModItems.CORUPEM_INGIT);
    }

    private static boolean canCharge(BlockState state) {
        return (Integer)state.get(CHARGE) < 4;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHARGE);

    }
}
