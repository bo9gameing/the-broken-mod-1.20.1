package bo9.the_broken_mod.portals;

import bo9.the_broken_mod.block.ModBlock;
import bo9.the_broken_mod.item.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class ModPortals  {
    public static void registerPortals(){
        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlock.RIFT_BLOCK)
                .lightWithItem(ModItems.CORUPEM_INGIT)
                .destDimID(Identifier.of("the-broken-mod", "halfe_realm"))
                .tintColor(131, 66, 184)
                .registerPortal();
    }
}
