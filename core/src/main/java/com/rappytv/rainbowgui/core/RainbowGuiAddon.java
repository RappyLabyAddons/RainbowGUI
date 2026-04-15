package com.rappytv.rainbowgui.core;

import com.rappytv.rainbowgui.core.listener.GameTickListener;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class RainbowGuiAddon extends LabyAddon<RainbowGuiConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.registerListener(new GameTickListener(this));
  }

  @Override
  protected Class<? extends RainbowGuiConfiguration> configurationClass() {
    return RainbowGuiConfiguration.class;
  }
}
