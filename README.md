<div align="center">

# SimpleCommandDisabler

**The ultimate lightweight solution for server command security.**

![Version](https://img.shields.io/badge/version-1.0-blue?style=for-the-badge)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21%2B-green?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Paper%20%2F%20Spigot-orange?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-red?style=for-the-badge)

<p align="center">
  <img src="https://cdn.discordapp.com/attachments/1442937974244507739/1464661209654493366/scd.png?ex=6976478c&is=6974f60c&hm=23f212c7e74154b452a443edf7df255b86278323ffc17dd4d1a69d9c5ee1c847&" width="600" alt="Logo">
</p>

</div>

---

## 📋 Overview

**SimpleCommandDisabler** is a zero-bloat plugin designed to give server administrators complete control over which commands players can execute. Whether you want to hide your plugin list (e.g., `/plugins`, `/pl`) or block potential exploits, this plugin handles it seamlessly.

## ✨ Key Features

-   🔒 **Absolute Blocking**: Prevents commands from even being processed by other plugins.
-   ⚡ **Ultra Lightweight**: Zero impact on server TPS (Ticks Per Second).
-   🎨 **Rich Message Support**: Full support for legacy color codes (`&c`, `&l`, etc.) in denial messages.
-   🛡️ **Smart Bypass System**: Integrated permission system for admins and staff.
-   🔧 **Case Insensitive**:Intelligent matching engine catches `/PL`, `/pl`, and `/Pl` instantly.

## 📦 Installation Guide

Getting started is as easy as 1-2-3:

1.  **Download** the latest `.jar` file from the [Releases](#) tab.
2.  **Drop** the file into your server's `plugins` folder.
3.  **Restart** your server to generate the configuration files.

> **Note**: This plugin is optimized for Minecraft **1.21** and newer versions running on Spigot, Paper, or Purpur.

## ⚙️ Configuration (`config.yml`)

Customize the plugin to your exact needs. The configuration is generated automatically:

```yaml
# --------------------------------------------------------
#              SimpleCommandDisabler Config
# --------------------------------------------------------

# List of commands you want to block.
# You can enter them with or without the leading '/'
# The check is case-insensitive.
blocked-commands:
  - plugins
  - version
  - pl
  - about
  - ?

# The message displayed to players when they try to use a blocked command.
# Supports color codes (e.g., &c for red, &l for bold).
blocked-message: "&c&l✘ &7I'm sorry, but you cannot use this command!"
```

## 🛡️ Permissions

Manage who bypasses the restrictions with a single node.

| Permission Node | Description | Recommended For |
| :--- | :--- | :--- |
| `commanddisabler.bypass` | Grants full access to all blocked commands. | **Admins, Operators** |

## ❓ FAQ

**Q: Does this block console commands?**
A: No, this plugin only listens to player commands to ensure your console remains fully functional.

**Q: Can I block aliases?**
A: Yes! Simply add all aliases (e.g., `pl`, `plugins`) to the list in `config.yml`.

**Q: Does it support Hex colors?**
A: Currently supports standard Bukkit color codes (`&`).

## 🤝 Support & Contribution

Found a bug? Have a suggestion?
-   🐛 **Report Issues**: Open a ticket in the Issues tab.
-   ⭐ **Show Support**: If you like this plugin, please star the repository!

---
<div align="center">
  <sub>Made with ❤️ by Nephesiss</sub>
</div>
