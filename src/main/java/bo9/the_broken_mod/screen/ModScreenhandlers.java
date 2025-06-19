package bo9.the_broken_mod.screen;

import bo9.the_broken_mod.TheBrokenMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenhandlers {
    public static final ScreenHandlerType<Computer_decoder_Screen_Handler> COMPUTER_DECODER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TheBrokenMod.MOD_ID,"computer_decodeing"),
                    new ExtendedScreenHandlerType<>(Computer_decoder_Screen_Handler::new));


    public static void registerScreenHandlers(){
        
    }
}
