package main;

import java.util.HashMap;

public class Language {
    private Long id;
    private String name;
    private String code;
    private static HashMap<String, HashMap<String, String>> locales;

    static {
        try {
            HashMap<String, HashMap<String, String>> locales = new HashMap<>();
            HashMap<String, String> localeRU = new HashMap<>();
            localeRU.put("login", "Вход");
            localeRU.put("about_source", "Об источнике");
            localeRU.put("contact_us", "Свяжитесь с нами:");
            localeRU.put("address", "Республика Казахстан, г. Алматы, ул. Айманова 126, 050005");

            HashMap<String, String> localeEN = new HashMap<>();
            localeEN.put("login", "Log In");
            localeEN.put("about_source", "About");
            localeEN.put("contact_us", "Contact us:");
            localeEN.put("address", "Aymanova st. 126, Almaty, 050005, Kazakhstan");

            locales.put("RU", localeRU);
            locales.put("EN", localeEN);
            Language.setLocales(locales);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static void setLocales(HashMap<String, HashMap<String, String>> locales) {
        Language.locales = locales;
    }

    public static HashMap<String, String> getLocale(String langCode) {
        if (langCode.equalsIgnoreCase("RU")) {
            return locales.get(langCode);
        }
        else if (langCode.equalsIgnoreCase("EN")) {
            return locales.get(langCode);
        }
        else return null;
    }
}
