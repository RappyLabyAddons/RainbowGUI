package com.rappytv.rainbowgui.core;

import com.rappytv.rainbowgui.core.RainbowGuiAddon.SettingCountHandler;
import net.labymod.api.Laby;
import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.Exclude;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;
import net.labymod.api.configuration.settings.annotation.SettingSection;
import net.labymod.api.util.Color;

public class RainbowGuiConfiguration extends AddonConfig {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true).addChangeListener(value -> {
    this.onLabelToggle(value);
    this.onBracketToggle(value);
    this.onValueToggle(value);
  });

  @SliderSetting(min = 2, max = 200)
  private final ConfigProperty<Integer> speed = new ConfigProperty<>(20);

  @SettingSection("prefix")
  @SwitchSetting
  private final ConfigProperty<Boolean> labelEnabled = new ConfigProperty<>(false)
      .withHandler(new SettingCountHandler())
      .addChangeListener(this::onLabelToggle);

  @SettingRequires("labelEnabled")
  @SliderSetting(min = 0, max = 100)
  private final ConfigProperty<Long> labelDelay = new ConfigProperty<>(0L);

  @SettingSection("brackets")
  @SwitchSetting
  private final ConfigProperty<Boolean> bracketsEnabled = new ConfigProperty<>(false)
      .withHandler(new SettingCountHandler())
      .addChangeListener(this::onBracketToggle);

  @SettingRequires("bracketsEnabled")
  @SliderSetting(min = 0, max = 100)
  private final ConfigProperty<Long> bracketDelay = new ConfigProperty<>(30L);

  @SettingSection("values")
  @SwitchSetting
  private final ConfigProperty<Boolean> valuesEnabled = new ConfigProperty<>(false)
      .withHandler(new SettingCountHandler())
      .addChangeListener(this::onValueToggle);

  @SettingRequires("valuesEnabled")
  @SliderSetting(min = 0, max = 100)
  private final ConfigProperty<Long> valueDelay = new ConfigProperty<>(60L);

  @Exclude
  private Color previousLabelColor = Color.BLACK;

  @Exclude
  private Color previousBracketColor = Color.BLACK;

  @Exclude
  private Color previousValueColor = Color.BLACK;

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Integer> speed() {
    return this.speed;
  }

  public ConfigProperty<Boolean> labelEnabled() {
    return this.labelEnabled;
  }

  public ConfigProperty<Long> labelDelay() {
    return this.labelDelay;
  }

  public ConfigProperty<Boolean> bracketsEnabled() {
    return this.bracketsEnabled;
  }

  public ConfigProperty<Long> bracketDelay() {
    return this.bracketDelay;
  }

  public ConfigProperty<Boolean> valuesEnabled() {
    return this.valuesEnabled;
  }

  public ConfigProperty<Long> valueDelay() {
    return this.valueDelay;
  }

  private void onLabelToggle(boolean value) {
    if(!RainbowGuiAddon.areSettingsInitialized()) {
      return;
    }
    if(value) {
      this.previousLabelColor = Laby.references()
          .hudWidgetRegistry()
          .globalHudWidgetConfig()
          .labelColor()
          .get();
    } else {
      Laby.references()
          .hudWidgetRegistry()
          .globalHudWidgetConfig()
          .labelColor()
          .set(this.previousLabelColor);
    }
  }

  private void onBracketToggle(boolean value) {
    if(!RainbowGuiAddon.areSettingsInitialized()) {
      return;
    }
    if(value) {
      this.previousBracketColor = Laby.references()
          .hudWidgetRegistry()
          .globalHudWidgetConfig()
          .bracketColor()
          .get();
    } else {
      Laby.references()
          .hudWidgetRegistry()
          .globalHudWidgetConfig()
          .bracketColor()
          .set(this.previousBracketColor);
    }
  }

  private void onValueToggle(boolean value) {
    if(!RainbowGuiAddon.areSettingsInitialized()) {
      return;
    }
    if(value) {
      this.previousValueColor = Laby.references()
          .hudWidgetRegistry()
          .globalHudWidgetConfig()
          .valueColor()
          .get();
    } else {
      Laby.references()
          .hudWidgetRegistry()
          .globalHudWidgetConfig()
          .valueColor()
          .set(this.previousValueColor);
    }
  }
}
