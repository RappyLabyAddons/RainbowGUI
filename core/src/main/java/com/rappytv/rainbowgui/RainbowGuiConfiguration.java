package com.rappytv.rainbowgui;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingRequires;
import net.labymod.api.configuration.settings.annotation.SettingSection;

public class RainbowGuiConfiguration extends AddonConfig {

    @SwitchSetting
    private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

    @SliderSetting(min = 2, max = 200)
    private final ConfigProperty<Integer> speed = new ConfigProperty<>(20);

    @SettingSection("prefix")
    @SwitchSetting
    private final ConfigProperty<Boolean> prefixEnabled = new ConfigProperty<>(true);

    @SettingRequires("prefixEnabled")
    @SliderSetting(min = 0, max = 100)
    private final ConfigProperty<Long> prefixDelay = new ConfigProperty<>(0L);

    @SettingSection("brackets")
    @SwitchSetting
    private final ConfigProperty<Boolean> bracketsEnabled = new ConfigProperty<>(true);

    @SettingRequires("bracketsEnabled")
    @SliderSetting(min = 0, max = 100)
    private final ConfigProperty<Long> bracketDelay = new ConfigProperty<>(30L);

    @SettingSection("values")
    @SwitchSetting
    private final ConfigProperty<Boolean> valuesEnabled = new ConfigProperty<>(true);

    @SettingRequires("valuesEnabled")
    @SliderSetting(min = 0, max = 100)
    private final ConfigProperty<Long> valueDelay = new ConfigProperty<>(60L);


    @Override
    public ConfigProperty<Boolean> enabled() {
        return enabled;
    }
    public ConfigProperty<Integer> speed() {
        return speed;
    }
    public ConfigProperty<Boolean> prefixEnabled() {
        return prefixEnabled;
    }
    public ConfigProperty<Long> prefixDelay() {
        return prefixDelay;
    }
    public ConfigProperty<Boolean> bracketsEnabled() {
        return bracketsEnabled;
    }
    public ConfigProperty<Long> bracketDelay() {
        return bracketDelay;
    }
    public ConfigProperty<Boolean> valuesEnabled() {
        return valuesEnabled;
    }
    public ConfigProperty<Long> valueDelay() {
        return valueDelay;
    }
}
