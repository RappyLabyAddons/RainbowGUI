package com.rappytv.rainbowgui;

import com.rappytv.rainbowgui.listener.GameTickListener;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class RainbowGuiAddon extends LabyAddon<RainbowGuiConfiguration> {

    @Override
    protected void enable() {
        registerSettingCategory();
        registerListener(new GameTickListener(this));
    }

    @Override
    protected Class<? extends RainbowGuiConfiguration> configurationClass() {
        return RainbowGuiConfiguration.class;
    }
}
