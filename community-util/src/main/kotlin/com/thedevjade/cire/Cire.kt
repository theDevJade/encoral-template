/*
 * Copyright (c) 2023. Made by theDevJade or contributors.
 */

package com.thedevjade.cire

import com.thedevjade.cire.items.EventProcesser
import org.bukkit.plugin.java.JavaPlugin
import org.checkerframework.checker.nullness.qual.NonNull
import org.checkerframework.framework.qual.DefaultQualifier


lateinit var plugin: Cire private set

@DefaultQualifier(NonNull::class)
class Cire : JavaPlugin() {
  override fun onEnable() {
    server.pluginManager.registerEvents(EventProcesser, this)
  }

  override fun onDisable() {}
}
