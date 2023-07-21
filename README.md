# Chest generator

_Русское README доступно по ссылке https://github.com/Prikalel/Chest-Generator/blob/1.12/README_ru.md._

Simple minecraft mod for spawning chests in your world with items you defined in JSON files.

Original [repo](https://github.com/KidsDontPlay/Chest-Generator) is by [KidsDontPlay](https://legacy.curseforge.com/members/KidsDontPlay/projects).

It's quite simple. Fill a chest with desired items and right click it while you are sneaking and in creative mode.

A file will be created in your config folder.

## List of changes

- [x] Fixed [bug](https://github.com/KidsDontPlay/Chest-Generator/issues/1) when not creating files on windows.
- [x] Port to 1.12
- [x] Better spawn algorithm (remove infinitive loop). Make chests to spawn more fat from each other. The world generating is now a little faster.
- [x] More logging and configurations.
- [x] Use of KD-trees (see this repo for source [code](https://github.com/heineman/algorithms-nutshell-2ed/tree/master)): now you can set the minimal allowed distance between chests.

## How to use?

Create new empty minecraft world with creative mod. Place a chest and fill it with items you want it to have.

Right-click on the chest while sneaking and in your config folder (specially in location `config/Chest Generator`) the json file will be created.

These files are used to determine which chests to spawn and where.

## File description

<details>
<summary>File example</summary>

```json
 "items": [
        {
            "modID": "minecraft",
            "name": "iron_sword",
            "minMeta": 0,
            "maxMeta": 0,
            "minSize": 1,
            "maxSize": 1,
            "chance": 90,
            "enchantments": [
                {
                    "id": 16,
                    "strength": 1
                },
                {
                    "id": 21,
                    "strength": 3
                }
            ]
        },
        {
            "modID": "minecraft",
            "name": "speckled_melon",
            "minMeta": 0,
            "maxMeta": 0,
            "minSize": 4,
            "maxSize": 8,
            "chance": 70
        },
        {
            "modID": "minecraft",
            "name": "emerald",
            "minMeta": 0,
            "maxMeta": 0,
            "minSize": 2,
            "maxSize": 4,
            "chance": 10
        },
        {
            "modID": "minecraft",
            "name": "coal",
            "minMeta": 0,
            "maxMeta": 1,
            "minSize": 32,
            "maxSize": 64,
            "chance": 100
        },
        {
            "modID": "minecraft",
            "name": "gold_ingot",
            "minMeta": 0,
            "maxMeta": 0,
            "minSize": 4,
            "maxSize": 16,
            "chance": 40
        },
        {
            "modID": "minecraft",
            "name": "stained_glass",
            "minMeta": 0,
            "maxMeta": 15,
            "minSize": 2,
            "maxSize": 60,
            "chance": 80
        },
        {
            "modID": "minecraft",
            "name": "baked_potato",
            "minMeta": 0,
            "maxMeta": 0,
            "minSize": 1,
            "maxSize": 32,
            "chance": 100
        }
    ],
    "biomes": [
        "desert",
        "jungle",
        "taiga"
    ],
    "light": true,
    "chance": 75,
    "minY": 32,
    "maxY": 128
}
```
</details>

- items: the list of items
  - modID: the mod ID, for vanilla items it is "minecraft"
  - name: name of the item (F3+H will help you to find the names)
  - minMeta: minimum metadata of the item
  - maxMeta: maximum metadata of the item (e.g. for a random wool you set min to 0 and max to 15)
  - minSize: minimum size of the stack
  - maxSize: maximum size of the stack
  - chance: chance that the item appears (0-100)
  - enchantments: enchantments of the item
- biomes: valid biomes: "anywhere", "overworld", "nether", "end" and the normal biom names like "minecraft:savanna" or "minecraft:forest".
- light: if true, torches will spawn around the chest
- chance: chance that the chest spawns (0-100)
- minY: minimum level
- maxY: maximum level

I recommend to manually set minY to 50 and maxY to 100-150.

## Special thanks

To _KidsDontPlay_ for sharing his mod source code.

To the user _heinemann_ for the opportunity to use the implementation of KD-trees in java quickly and simply.

## GitHub Information

### Repo
[![GitHub forks](https://img.shields.io/github/forks/Prikalel/Chest-Generator.svg?style=social&label=Fork)](https://github.com/Prikalel/Chest-Generator)
[![GitHub stars](https://img.shields.io/github/stars/Prikalel/Chest-Generator.svg?style=social&label=Stars)](https://github.com/Prikalel/Chest-Generator)
[![GitHub stars](https://img.shields.io/github/watchers/Prikalel/Chest-Generator.svg?style=social&label=Watch)](https://github.com/Prikalel/Chest-Generator)
[![GitHub stars](https://img.shields.io/github/followers/Prikalel.svg?style=social&label=Follow)](https://github.com/Prikalel)
### Issues
[![GitHub issues](https://img.shields.io/github/issues/Prikalel/Chest-Generator.svg?colorB=green)]()
[![GitHub closed issues](https://img.shields.io/github/issues-closed/Prikalel/Chest-Generator.svg?colorB=ff5900)]()
### Pull Requests
[![GitHub pull requests](https://img.shields.io/github/issues-pr/Prikalel/Chest-Generator.svg?colorB=green)]()
[![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/Prikalel/Chest-Generator.svg?colorB=ff5900)]()
### Additional
[![GitHub contributors](https://img.shields.io/github/contributors/Prikalel/Chest-Generator.svg)]()
[![GitHub commit activity the past week, 4 weeks, year](https://img.shields.io/github/commit-activity/y/Prikalel/Chest-Generator.svg)]()

## Licence

[![license](https://img.shields.io/github/license/Prikalel/Chest-Generator.svg)](./LICENSE.txt)