package com.rappytv.rainbowgui.core;

import com.rappytv.rainbowgui.core.listener.GameTickListener;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.configuration.settings.Setting;
import net.labymod.api.configuration.settings.SettingHandler;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class RainbowGuiAddon extends LabyAddon<RainbowGuiConfiguration> {

  private static int settingsInitialized = 0;

  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.registerListener(new GameTickListener(this));
  }

  @Override
  protected Class<? extends RainbowGuiConfiguration> configurationClass() {
    return RainbowGuiConfiguration.class;
  }

  public static boolean areSettingsInitialized() {
    return settingsInitialized >= 3;
  }

  public static class SettingCountHandler implements SettingHandler {

    @Override
    public void created(Setting setting) {

    }

    @Override
    public void initialized(Setting setting) {
      settingsInitialized++;
    }
  }
}
