//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.02 at 06:23:58 PM NOVT 
//


package org.tomskgislab.vertex.xml.zem.territory.classes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dStreets.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dStreets">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="аллея"/>
 *     &lt;enumeration value="б-р"/>
 *     &lt;enumeration value="въезд"/>
 *     &lt;enumeration value="дор"/>
 *     &lt;enumeration value="жт"/>
 *     &lt;enumeration value="заезд"/>
 *     &lt;enumeration value="кв-л"/>
 *     &lt;enumeration value="км"/>
 *     &lt;enumeration value="кольцо"/>
 *     &lt;enumeration value="линия"/>
 *     &lt;enumeration value="наб"/>
 *     &lt;enumeration value="остров"/>
 *     &lt;enumeration value="парк"/>
 *     &lt;enumeration value="пер"/>
 *     &lt;enumeration value="переезд"/>
 *     &lt;enumeration value="пл"/>
 *     &lt;enumeration value="пл-ка"/>
 *     &lt;enumeration value="проезд"/>
 *     &lt;enumeration value="пр-кт"/>
 *     &lt;enumeration value="просек"/>
 *     &lt;enumeration value="проселок"/>
 *     &lt;enumeration value="проулок"/>
 *     &lt;enumeration value="сад"/>
 *     &lt;enumeration value="сквер"/>
 *     &lt;enumeration value="стр"/>
 *     &lt;enumeration value="тер"/>
 *     &lt;enumeration value="тракт"/>
 *     &lt;enumeration value="туп"/>
 *     &lt;enumeration value="ул"/>
 *     &lt;enumeration value="уч-к"/>
 *     &lt;enumeration value="ш"/>
 *     &lt;enumeration value="аал"/>
 *     &lt;enumeration value="аул"/>
 *     &lt;enumeration value="высел"/>
 *     &lt;enumeration value="городок"/>
 *     &lt;enumeration value="д"/>
 *     &lt;enumeration value="ж/д_будка"/>
 *     &lt;enumeration value="ж/д_казарм"/>
 *     &lt;enumeration value="ж/д_оп"/>
 *     &lt;enumeration value="ж/д_пост"/>
 *     &lt;enumeration value="ж/д_рзд"/>
 *     &lt;enumeration value="ж/д_ст"/>
 *     &lt;enumeration value="казарма"/>
 *     &lt;enumeration value="м"/>
 *     &lt;enumeration value="мкр"/>
 *     &lt;enumeration value="нп"/>
 *     &lt;enumeration value="платф"/>
 *     &lt;enumeration value="п"/>
 *     &lt;enumeration value="п/о"/>
 *     &lt;enumeration value="п/р"/>
 *     &lt;enumeration value="п/ст"/>
 *     &lt;enumeration value="полустанок"/>
 *     &lt;enumeration value="починок"/>
 *     &lt;enumeration value="рзд"/>
 *     &lt;enumeration value="с"/>
 *     &lt;enumeration value="сл"/>
 *     &lt;enumeration value="ст"/>
 *     &lt;enumeration value="х"/>
 *     &lt;enumeration value="ж/д_платф"/>
 *     &lt;enumeration value="арбан"/>
 *     &lt;enumeration value="спуск"/>
 *     &lt;enumeration value="канал"/>
 *     &lt;enumeration value="гск"/>
 *     &lt;enumeration value="снт"/>
 *     &lt;enumeration value="лпх"/>
 *     &lt;enumeration value="проток"/>
 *     &lt;enumeration value="коса"/>
 *     &lt;enumeration value="вал"/>
 *     &lt;enumeration value="ферма"/>
 *     &lt;enumeration value="мост"/>
 *     &lt;enumeration value="ряды"/>
 *     &lt;enumeration value="а/я"/>
 *     &lt;enumeration value="берег"/>
 *     &lt;enumeration value="просека"/>
 *     &lt;enumeration value="бугор"/>
 *     &lt;enumeration value="протока"/>
 *     &lt;enumeration value="зона"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dStreets")
@XmlEnum
public enum DStreets {


    /**
     * Аллея
     * 
     */
    @XmlEnumValue("\u0430\u043b\u043b\u0435\u044f")
    АЛЛЕЯ("\u0430\u043b\u043b\u0435\u044f"),

    /**
     * Бульвар
     * 
     */
    @XmlEnumValue("\u0431-\u0440")
    Б_Р("\u0431-\u0440"),

    /**
     * Въезд
     * 
     */
    @XmlEnumValue("\u0432\u044a\u0435\u0437\u0434")
    ВЪЕЗД("\u0432\u044a\u0435\u0437\u0434"),

    /**
     * Дорога
     * 
     */
    @XmlEnumValue("\u0434\u043e\u0440")
    ДОР("\u0434\u043e\u0440"),

    /**
     * Животноводческая точка
     * 
     */
    @XmlEnumValue("\u0436\u0442")
    ЖТ("\u0436\u0442"),

    /**
     * Заезд
     * 
     */
    @XmlEnumValue("\u0437\u0430\u0435\u0437\u0434")
    ЗАЕЗД("\u0437\u0430\u0435\u0437\u0434"),

    /**
     * Квартал
     * 
     */
    @XmlEnumValue("\u043a\u0432-\u043b")
    КВ_Л("\u043a\u0432-\u043b"),

    /**
     * Километр
     * 
     */
    @XmlEnumValue("\u043a\u043c")
    КМ("\u043a\u043c"),

    /**
     * Кольцо
     * 
     */
    @XmlEnumValue("\u043a\u043e\u043b\u044c\u0446\u043e")
    КОЛЬЦО("\u043a\u043e\u043b\u044c\u0446\u043e"),

    /**
     * Линия
     * 
     */
    @XmlEnumValue("\u043b\u0438\u043d\u0438\u044f")
    ЛИНИЯ("\u043b\u0438\u043d\u0438\u044f"),

    /**
     * Набережная
     * 
     */
    @XmlEnumValue("\u043d\u0430\u0431")
    НАБ("\u043d\u0430\u0431"),

    /**
     * Остров
     * 
     */
    @XmlEnumValue("\u043e\u0441\u0442\u0440\u043e\u0432")
    ОСТРОВ("\u043e\u0441\u0442\u0440\u043e\u0432"),

    /**
     * Парк
     * 
     */
    @XmlEnumValue("\u043f\u0430\u0440\u043a")
    ПАРК("\u043f\u0430\u0440\u043a"),

    /**
     * Переулок
     * 
     */
    @XmlEnumValue("\u043f\u0435\u0440")
    ПЕР("\u043f\u0435\u0440"),

    /**
     * Переезд
     * 
     */
    @XmlEnumValue("\u043f\u0435\u0440\u0435\u0435\u0437\u0434")
    ПЕРЕЕЗД("\u043f\u0435\u0440\u0435\u0435\u0437\u0434"),

    /**
     * Площадь
     * 
     */
    @XmlEnumValue("\u043f\u043b")
    ПЛ("\u043f\u043b"),

    /**
     * Площадка
     * 
     */
    @XmlEnumValue("\u043f\u043b-\u043a\u0430")
    ПЛ_КА("\u043f\u043b-\u043a\u0430"),

    /**
     * Проезд
     * 
     */
    @XmlEnumValue("\u043f\u0440\u043e\u0435\u0437\u0434")
    ПРОЕЗД("\u043f\u0440\u043e\u0435\u0437\u0434"),

    /**
     * Проспект
     * 
     */
    @XmlEnumValue("\u043f\u0440-\u043a\u0442")
    ПР_КТ("\u043f\u0440-\u043a\u0442"),

    /**
     * Просек
     * 
     */
    @XmlEnumValue("\u043f\u0440\u043e\u0441\u0435\u043a")
    ПРОСЕК("\u043f\u0440\u043e\u0441\u0435\u043a"),

    /**
     * Проселок
     * 
     */
    @XmlEnumValue("\u043f\u0440\u043e\u0441\u0435\u043b\u043e\u043a")
    ПРОСЕЛОК("\u043f\u0440\u043e\u0441\u0435\u043b\u043e\u043a"),

    /**
     * Проулок
     * 
     */
    @XmlEnumValue("\u043f\u0440\u043e\u0443\u043b\u043e\u043a")
    ПРОУЛОК("\u043f\u0440\u043e\u0443\u043b\u043e\u043a"),

    /**
     * Сад
     * 
     */
    @XmlEnumValue("\u0441\u0430\u0434")
    САД("\u0441\u0430\u0434"),

    /**
     * Сквер
     * 
     */
    @XmlEnumValue("\u0441\u043a\u0432\u0435\u0440")
    СКВЕР("\u0441\u043a\u0432\u0435\u0440"),

    /**
     * Строение
     * 
     */
    @XmlEnumValue("\u0441\u0442\u0440")
    СТР("\u0441\u0442\u0440"),

    /**
     * Территория
     * 
     */
    @XmlEnumValue("\u0442\u0435\u0440")
    ТЕР("\u0442\u0435\u0440"),

    /**
     * Тракт
     * 
     */
    @XmlEnumValue("\u0442\u0440\u0430\u043a\u0442")
    ТРАКТ("\u0442\u0440\u0430\u043a\u0442"),

    /**
     * Тупик
     * 
     */
    @XmlEnumValue("\u0442\u0443\u043f")
    ТУП("\u0442\u0443\u043f"),

    /**
     * Улица
     * 
     */
    @XmlEnumValue("\u0443\u043b")
    УЛ("\u0443\u043b"),

    /**
     * Участок
     * 
     */
    @XmlEnumValue("\u0443\u0447-\u043a")
    УЧ_К("\u0443\u0447-\u043a"),

    /**
     * Шоссе
     * 
     */
    @XmlEnumValue("\u0448")
    Ш("\u0448"),

    /**
     * Аал
     * 
     */
    @XmlEnumValue("\u0430\u0430\u043b")
    ААЛ("\u0430\u0430\u043b"),

    /**
     * Аул
     * 
     */
    @XmlEnumValue("\u0430\u0443\u043b")
    АУЛ("\u0430\u0443\u043b"),

    /**
     * Выселки(ок)
     * 
     */
    @XmlEnumValue("\u0432\u044b\u0441\u0435\u043b")
    ВЫСЕЛ("\u0432\u044b\u0441\u0435\u043b"),

    /**
     * Городок
     * 
     */
    @XmlEnumValue("\u0433\u043e\u0440\u043e\u0434\u043e\u043a")
    ГОРОДОК("\u0433\u043e\u0440\u043e\u0434\u043e\u043a"),

    /**
     * Деревня
     * 
     */
    @XmlEnumValue("\u0434")
    Д("\u0434"),

    /**
     * Железнодорожная будка
     * 
     */
    @XmlEnumValue("\u0436/\u0434_\u0431\u0443\u0434\u043a\u0430")
    Ж_Д_БУДКА("\u0436/\u0434_\u0431\u0443\u0434\u043a\u0430"),

    /**
     * Железнодорожная казарма
     * 
     */
    @XmlEnumValue("\u0436/\u0434_\u043a\u0430\u0437\u0430\u0440\u043c")
    Ж_Д_КАЗАРМ("\u0436/\u0434_\u043a\u0430\u0437\u0430\u0440\u043c"),

    /**
     * ж/д остановочный (обгонный) пункт
     * 
     */
    @XmlEnumValue("\u0436/\u0434_\u043e\u043f")
    Ж_Д_ОП("\u0436/\u0434_\u043e\u043f"),

    /**
     * Железнодорожный пост
     * 
     */
    @XmlEnumValue("\u0436/\u0434_\u043f\u043e\u0441\u0442")
    Ж_Д_ПОСТ("\u0436/\u0434_\u043f\u043e\u0441\u0442"),

    /**
     * Железнодорожный разъезд
     * 
     */
    @XmlEnumValue("\u0436/\u0434_\u0440\u0437\u0434")
    Ж_Д_РЗД("\u0436/\u0434_\u0440\u0437\u0434"),

    /**
     * Железнодорожная станция
     * 
     */
    @XmlEnumValue("\u0436/\u0434_\u0441\u0442")
    Ж_Д_СТ("\u0436/\u0434_\u0441\u0442"),

    /**
     * Казарма
     * 
     */
    @XmlEnumValue("\u043a\u0430\u0437\u0430\u0440\u043c\u0430")
    КАЗАРМА("\u043a\u0430\u0437\u0430\u0440\u043c\u0430"),

    /**
     * Местечко
     * 
     */
    @XmlEnumValue("\u043c")
    М("\u043c"),

    /**
     * Микрорайон
     * 
     */
    @XmlEnumValue("\u043c\u043a\u0440")
    МКР("\u043c\u043a\u0440"),

    /**
     * Населенный пункт
     * 
     */
    @XmlEnumValue("\u043d\u043f")
    НП("\u043d\u043f"),

    /**
     * Платформа
     * 
     */
    @XmlEnumValue("\u043f\u043b\u0430\u0442\u0444")
    ПЛАТФ("\u043f\u043b\u0430\u0442\u0444"),

    /**
     * Поселок
     * 
     */
    @XmlEnumValue("\u043f")
    П("\u043f"),

    /**
     * Почтовое отделение
     * 
     */
    @XmlEnumValue("\u043f/\u043e")
    П_О("\u043f/\u043e"),

    /**
     * Планировочный район
     * 
     */
    @XmlEnumValue("\u043f/\u0440")
    П_Р("\u043f/\u0440"),

    /**
     * Поселок и(при) станция(и)
     * 
     */
    @XmlEnumValue("\u043f/\u0441\u0442")
    П_СТ("\u043f/\u0441\u0442"),

    /**
     * Полустанок
     * 
     */
    @XmlEnumValue("\u043f\u043e\u043b\u0443\u0441\u0442\u0430\u043d\u043e\u043a")
    ПОЛУСТАНОК("\u043f\u043e\u043b\u0443\u0441\u0442\u0430\u043d\u043e\u043a"),

    /**
     * Починок
     * 
     */
    @XmlEnumValue("\u043f\u043e\u0447\u0438\u043d\u043e\u043a")
    ПОЧИНОК("\u043f\u043e\u0447\u0438\u043d\u043e\u043a"),

    /**
     * Разъезд
     * 
     */
    @XmlEnumValue("\u0440\u0437\u0434")
    РЗД("\u0440\u0437\u0434"),

    /**
     * Село
     * 
     */
    @XmlEnumValue("\u0441")
    С("\u0441"),

    /**
     * Слобода
     * 
     */
    @XmlEnumValue("\u0441\u043b")
    СЛ("\u0441\u043b"),

    /**
     * Станция
     * 
     */
    @XmlEnumValue("\u0441\u0442")
    СТ("\u0441\u0442"),

    /**
     * Хутор
     * 
     */
    @XmlEnumValue("\u0445")
    Х("\u0445"),

    /**
     * Железнодорожная платформа
     * 
     */
    @XmlEnumValue("\u0436/\u0434_\u043f\u043b\u0430\u0442\u0444")
    Ж_Д_ПЛАТФ("\u0436/\u0434_\u043f\u043b\u0430\u0442\u0444"),

    /**
     * Арбан
     * 
     */
    @XmlEnumValue("\u0430\u0440\u0431\u0430\u043d")
    АРБАН("\u0430\u0440\u0431\u0430\u043d"),

    /**
     * Спуск
     * 
     */
    @XmlEnumValue("\u0441\u043f\u0443\u0441\u043a")
    СПУСК("\u0441\u043f\u0443\u0441\u043a"),

    /**
     * Канал
     * 
     */
    @XmlEnumValue("\u043a\u0430\u043d\u0430\u043b")
    КАНАЛ("\u043a\u0430\u043d\u0430\u043b"),

    /**
     * Гаражно-строительный кооператив
     * 
     */
    @XmlEnumValue("\u0433\u0441\u043a")
    ГСК("\u0433\u0441\u043a"),

    /**
     * Садовое некоммерческое товарищество
     * 
     */
    @XmlEnumValue("\u0441\u043d\u0442")
    СНТ("\u0441\u043d\u0442"),

    /**
     * Леспромхоз
     * 
     */
    @XmlEnumValue("\u043b\u043f\u0445")
    ЛПХ("\u043b\u043f\u0445"),

    /**
     * Проток
     * 
     */
    @XmlEnumValue("\u043f\u0440\u043e\u0442\u043e\u043a")
    ПРОТОК("\u043f\u0440\u043e\u0442\u043e\u043a"),

    /**
     * Коса
     * 
     */
    @XmlEnumValue("\u043a\u043e\u0441\u0430")
    КОСА("\u043a\u043e\u0441\u0430"),

    /**
     * Вал
     * 
     */
    @XmlEnumValue("\u0432\u0430\u043b")
    ВАЛ("\u0432\u0430\u043b"),

    /**
     * Ферма
     * 
     */
    @XmlEnumValue("\u0444\u0435\u0440\u043c\u0430")
    ФЕРМА("\u0444\u0435\u0440\u043c\u0430"),

    /**
     * Мост
     * 
     */
    @XmlEnumValue("\u043c\u043e\u0441\u0442")
    МОСТ("\u043c\u043e\u0441\u0442"),

    /**
     * Ряды
     * 
     */
    @XmlEnumValue("\u0440\u044f\u0434\u044b")
    РЯДЫ("\u0440\u044f\u0434\u044b"),

    /**
     * Абонентский ящик
     * 
     */
    @XmlEnumValue("\u0430/\u044f")
    А_Я("\u0430/\u044f"),

    /**
     * Берег
     * 
     */
    @XmlEnumValue("\u0431\u0435\u0440\u0435\u0433")
    БЕРЕГ("\u0431\u0435\u0440\u0435\u0433"),

    /**
     * Просека
     * 
     */
    @XmlEnumValue("\u043f\u0440\u043e\u0441\u0435\u043a\u0430")
    ПРОСЕКА("\u043f\u0440\u043e\u0441\u0435\u043a\u0430"),

    /**
     * Бугор
     * 
     */
    @XmlEnumValue("\u0431\u0443\u0433\u043e\u0440")
    БУГОР("\u0431\u0443\u0433\u043e\u0440"),

    /**
     * Протока
     * 
     */
    @XmlEnumValue("\u043f\u0440\u043e\u0442\u043e\u043a\u0430")
    ПРОТОКА("\u043f\u0440\u043e\u0442\u043e\u043a\u0430"),

    /**
     * Зона
     * 
     */
    @XmlEnumValue("\u0437\u043e\u043d\u0430")
    ЗОНА("\u0437\u043e\u043d\u0430");
    private final String value;

    DStreets(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DStreets fromValue(String v) {
        for (DStreets c: DStreets.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
