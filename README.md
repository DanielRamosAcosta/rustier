# rustier

![Build](https://github.com/DanielRamosAcosta/rustier/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/15415.svg)](https://plugins.jetbrains.com/plugin/15415)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/15415.svg)](https://plugins.jetbrains.com/plugin/15415)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [x] [Publish a plugin manually](https://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/publishing_plugin.html) for the first time.
- [x] Set the Plugin ID in the above README badges.
- [x] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [x] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This plugin adds support for `rustfmt` (https://github.com/rust-lang/rustfmt), an opinionated code formatter.

To use it:

* Configure the `rustfmt` binary path in the plugin settings (default ~/.cargo/bin/rustfmt)
* Select the code or file you want to format using `rustfmt`
* Use the "Reformat with rustfmt" action (Alt-Shift-Cmd-P on macOS or Alt-Shift-Ctrl-P on Windows and Linux) or find it using the "Find Action" popup (Cmd/Ctrl-Shift-A)

To run rustfmt on save, tick the "Run on save for files" option in Preferences/Settings | Languages \& Frameworks | Rust | Rustier.
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "rustier"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/DanielRamosAcosta/rustier/releases/latest) and install it manually using
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
