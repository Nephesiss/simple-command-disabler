# CommandDisabler

A lightweight Minecraft plugin that blocks specific commands for players, with a clean config and permission-based overrides.

## Features

- Block any command by name (no aliases needed)
- Permission-based bypass (global or per-command)
- Customizable deny message
- Simple configuration and minimal overhead

## Installation

1. Download or build the plugin JAR.
2. Place it in your server's `plugins/` folder.
3. Start the server once to generate the config.
4. Edit `plugins/CommandDisabler/config.yml` and reload or restart.

## Configuration

```yml
blocked-commands:
  - plugins
  - version
  - pl

deny-message: "&cYou cannot use that command."
```

## Permissions

| Permission | Description | Default |
| --- | --- | --- |
| `commanddisabler.bypass` | Bypass all blocked commands | op |
| `commanddisabler.bypass.<command>` | Bypass a specific blocked command | false |

## Build

```bash
mvn package
```

The built JAR will be in `target/`.

## Compatibility

- API: Spigot/Paper 1.13+
- Java: 17+

## License

MIT
