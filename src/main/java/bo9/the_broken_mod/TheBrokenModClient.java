package bo9.the_broken_mod;

import bo9.the_broken_mod.screen.Computer_decoder_Screen;
import bo9.the_broken_mod.screen.ModScreenhandlers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class TheBrokenModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenhandlers.COMPUTER_DECODER_SCREEN_HANDLER, Computer_decoder_Screen::new);
    }
}
