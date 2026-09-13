package com.example.moscowmetro

import com.example.moscowmetro.model.Line
import com.example.moscowmetro.model.Station

object MetroRepository {
    val yellowLineA = Line("8A", "Солнцевская", "#FFC700", false)
    val turquoiseLine = Line("11", "Большая кольцевая", "#00AFAA", true)
    val greenLine_D = Line("D4", "Калужско-Нижегородский диаметр", "2DBE2C", false)

    val stationsList: List<Station> = listOf(
        // ЖЕЛТАЯ ВЕТКА
        Station(1, "Деловой центр", yellowLineA, 1),
        Station(2, "Парк Победы", yellowLineA, 2),
        Station(3, "Минская", yellowLineA, 3),
        Station(4, "Ломоносовский проспект", yellowLineA, 4),
        Station(5, "Раменки", yellowLineA, 5),
        Station(6, "Мичуринский проспект", yellowLineA, 6),
        Station(7, "Озёрная", yellowLineA, 7),
        Station(8, "Говорово", yellowLineA, 8),
        Station(9, "Солнцево", yellowLineA, 9),
        Station(10, "Боровское шоссе", yellowLineA, 10),
        Station(11, "Новопеределкино", yellowLineA, 11),
        Station(12, "Рассказовка", yellowLineA, 12 ),
        Station(13, "Пыхтино", yellowLineA, 13),
        Station(14, "Аэропорт Внуково", yellowLineA, 14),


        // БИРЮЗОВАЯ ВЕТКА
        Station(15, "Каховская", turquoiseLine, 1),
        Station(16, "Варшавская", turquoiseLine, 2),
        Station(17, "Каширская", turquoiseLine, 3),
        Station(18, "Кленовый бульвар", turquoiseLine, 4),
        Station(19, "Нагатинский Затон", turquoiseLine, 5),
        Station(20, "Печатники", turquoiseLine, 6),
        Station(21, "Текстильщики", turquoiseLine, 7),
        Station(22, "Нижегородская", turquoiseLine, 8),
        Station(23, "Авиамоторная", turquoiseLine, 9),
        Station(24, "Лефортово", turquoiseLine, 10),
        Station(25, "Электрозаводская", turquoiseLine, 11),
        Station(26, "Сокольники", turquoiseLine, 12 ),
        Station(27, "Рижская", turquoiseLine, 13),
        Station(28, "Марьина Роща", turquoiseLine, 14),
        Station(29, "Савёловская", turquoiseLine, 15),
        Station(30, "Петровский парк", turquoiseLine, 16),
        Station(31, "ЦСКА", turquoiseLine, 17),
        Station(32, "Хорошёвская", turquoiseLine, 18),
        Station(33, "Народное Ополчение", turquoiseLine, 19),
        Station(34, "Мнёвники", turquoiseLine, 20),
        Station(35, "Терехово", turquoiseLine, 21),
        Station(36, "Кунцевская", turquoiseLine, 22),
        Station(37, "Давыдково", turquoiseLine, 23),
        Station(38, "Аминьевская", turquoiseLine, 24),
        Station(39, "Мичуринский проспект", turquoiseLine, 25),
        Station(40, "Проспект Вернадского", turquoiseLine, 26),
        Station(41, "Новаторская", turquoiseLine, 27),
        Station(42, "Воронцовская", turquoiseLine, 28),
        Station(43, "Зюзино", turquoiseLine, 29),

        // ЗЕЛЕНАЯ ВЕТКА(D)

        Station(44, "Апрелевка", greenLine_D, 1),
        Station(44, "Апрелевка", greenLine_D, 1),
        Station(45, "Победа", greenLine_D, 2),
        Station(46, "Крёкшино", greenLine_D, 3),
        Station(47, "Санино", greenLine_D, 4),
        Station(48, "Кокошкино", greenLine_D, 5),
        Station(49, "Толстопальцево", greenLine_D, 6),
        Station(50, "Лесной Городок", greenLine_D, 7),
        Station(51, "Внуково", greenLine_D, 8),
        Station(52, "Мичуринец", greenLine_D, 9),
        Station(53, "Переделкино", greenLine_D, 10),
        Station(54, "Солнечная", greenLine_D, 11),
        Station(55, "Мещерская", greenLine_D, 12),
        Station(56, "Очаково", greenLine_D, 13),
        Station(57, "Аминьевская", greenLine_D, 14),
        Station(58, "Матвеевская", greenLine_D, 15),
        Station(59, "Минская", greenLine_D, 16),
        Station(60, "Поклонная", greenLine_D, 17),
        Station(61, "Кутузовская", greenLine_D, 18),
        Station(62, "Москва-Сити", greenLine_D, 19),
        Station(63, "Беговая", greenLine_D, 20),
        Station(64, "Белорусская", greenLine_D, 21),
        Station(65, "Савёловская", greenLine_D, 22),
        Station(66, "Марьина Роща", greenLine_D, 23),
        Station(67, "Рижская", greenLine_D, 24),
        Station(68, "Площадь трёх вокзалов", greenLine_D, 25),
        Station(69, "Курская", greenLine_D, 26),
        Station(70, "Серп и Молот", greenLine_D, 27),
        Station(71, "Нижегородская", greenLine_D, 28),
        Station(72, "Чухлинка", greenLine_D, 29),
        Station(73, "Кусково", greenLine_D, 30),
        Station(74, "Новогиреево", greenLine_D, 31),
        Station(75, "Реутов", greenLine_D, 32),
        Station(76, "Никольское", greenLine_D, 33),
        Station(77, "Салтыковская", greenLine_D, 34),
        Station(78, "Кучино", greenLine_D, 35),
        Station(79, "Ольгино", greenLine_D, 36),
        Station(80, "Железнодорожная", greenLine_D, 37),
        )
}