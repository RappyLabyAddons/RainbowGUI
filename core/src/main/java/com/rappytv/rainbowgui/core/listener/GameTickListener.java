package com.rappytv.rainbowgui.core.listener;

import com.rappytv.rainbowgui.core.RainbowGuiAddon;
import net.labymod.api.Laby;
import net.labymod.api.event.Phase;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import net.labymod.api.util.Color;

public class GameTickListener {

  private final RainbowGuiAddon addon;
  private long rainbowTime;

  public GameTickListener(RainbowGuiAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onTick(GameTickEvent event) {
    if (event.phase() != Phase.POST) {
      return;
    }
    this.rainbowTime += this.addon.configuration().speed().get();
    if (this.addon.configuration().prefixEnabled().get()) {
      Laby.references().hudWidgetRegistry().globalHudWidgetConfig().labelColor().set(
          this.getRainbowColor(
              this.rainbowTime + this.addon.configuration().prefixDelay().get() * 10L
          )
      );
    }
    if (this.addon.configuration().bracketsEnabled().get()) {
      Laby.references().hudWidgetRegistry().globalHudWidgetConfig().bracketColor().set(
          this.getRainbowColor(
              this.rainbowTime + this.addon.configuration().bracketDelay().get() * 10L
          )
      );
    }
    if (this.addon.configuration().valuesEnabled().get()) {
      Laby.references().hudWidgetRegistry().globalHudWidgetConfig().valueColor().set(
          this.getRainbowColor(
              this.rainbowTime + this.addon.configuration().valueDelay().get() * 10L
          )
      );
    }
  }

  private Color getRainbowColor(long timeShift) {
    return Color.of(java.awt.Color.HSBtoRGB(
        (float) (timeShift % 1000L) / 1000.0F,
        0.8F,
        0.8F
    ));
  }
}
