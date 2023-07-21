# Chest generator

Простой мод для майнкрафта для спавна сундуков в вашем мире с предметами, которые вы определили в JSON-файлах.

Оригинальный [репозиторий](https://github.com/KidsDontPlay/Chest-Generator) создан пользователем [KidsDontPlay](https://legacy.curseforge.com/members/KidsDontPlay/projects).

Довольно простой мод. Заполните сундук предметами и кликните по нему ПКМ во время приседания в креативе.

Файл с настройками сундука будет создан в вашем файле конфигурации.

## Список изменений

- [x] Исправлен [баг](https://github.com/KidsDontPlay/Chest-Generator/issues/1), когда файлы не создавались на Windows.
- [x] Мод портирован для 1.12
- [x] Улучшенный алгоритм спавна (удалён бесконечный цикл). Сундуки спавнятся на большем расстоянии друг от друга. Генерация мира немного быстрее.
- [x] Логирование и конфигурация.
- [x] Использование KD-деревьев (см. [вот этот репозиторий](https://github.com/heineman/algorithms-nutshell-2ed/tree/master)): теперь можно задать минимальную допустимую дистанцию между 2мя сундуками.

## Как использовать?

Создайте пустой мир в майнкрафте, при генерации выберете creative. Поставьте сундук и наполните его предметами, которые вы хотите, чтобы в нём спавнились.

Кликните по нему ПКМ во время приседа (ctrl если вы не меняли назначения клавиш) и в папке конфигурации (`config/Chest Generator`) будет создан json-файл, описывающий сундук.

Эти json-файлы используются для того, чтобы наполнять сгенерированные сундуки.

## Описание файла

<details>
<summary>Пример</summary>

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

- items: список предметов
  - modID: идентификатор мода, для ванильки это "minecraft"
  - name: имя предмета (F3+H чтобы посмотреть идентификаторы прямо в инвентаре)
  - minMeta: минимальная метадата для предмета
  - maxMeta: максимальная метадата для предмета (например, для случайной шерсти минимальное надо поставить 0 и максимальное 15)
  - minSize: минимальнок кол-во для спавна в стаке
  - maxSize: максимальное кол-во предметов в ячейке сундука
  - chance: шанс того, что предмет появится в сундуке (0-100)
  - enchantments: зачарования (улучшения) предмета
- biomes: валидные биомы: "anywhere", "overworld", "nether", "end", а также более специфичные по типу "minecraft:savanna" или "minecraft:forest".
- light: установите в true, если хотите, чтобы вместе с сундуком рядом спавнились факела (удобно искать ночью)
- chance: шанс сундука, чтобы заспавниться (0-100, по дефолту 10)
- minY: минимальная высота
- maxY: максимальная высота

Рекомендуется вручную открыть созданный файл и донастроить его: например, установить minY 50 и maxY 100-150.

## Благодарности

Пользователю _KidsDontPlay_ за предоставление кода своего мода.

Пользователю _heineman_ за возможность использовать реализацию KD-деревьев в java быстро и просто.

## Информация GitHub

### Репозиторий
[![GitHub forks](https://img.shields.io/github/forks/Prikalel/Chest-Generator.svg?style=social&label=Fork)](https://github.com/Prikalel/Chest-Generator)
[![GitHub stars](https://img.shields.io/github/stars/Prikalel/Chest-Generator.svg?style=social&label=Stars)](https://github.com/Prikalel/Chest-Generator)
[![GitHub stars](https://img.shields.io/github/watchers/Prikalel/Chest-Generator.svg?style=social&label=Watch)](https://github.com/Prikalel/Chest-Generator)
[![GitHub stars](https://img.shields.io/github/followers/Prikalel.svg?style=social&label=Follow)](https://github.com/Prikalel)
### Ишью
[![GitHub issues](https://img.shields.io/github/issues/Prikalel/Chest-Generator.svg?colorB=green)]()
[![GitHub closed issues](https://img.shields.io/github/issues-closed/Prikalel/Chest-Generator.svg?colorB=ff5900)]()
### Пр-ы
[![GitHub pull requests](https://img.shields.io/github/issues-pr/Prikalel/Chest-Generator.svg?colorB=green)]()
[![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/Prikalel/Chest-Generator.svg?colorB=ff5900)]()
### Дополнительно
[![GitHub contributors](https://img.shields.io/github/contributors/Prikalel/Chest-Generator.svg)]()
[![GitHub commit activity the past week, 4 weeks, year](https://img.shields.io/github/commit-activity/y/Prikalel/Chest-Generator.svg)]()

## Лицензия

[![license](https://img.shields.io/github/license/Prikalel/Chest-Generator.svg)](./LICENSE.txt)