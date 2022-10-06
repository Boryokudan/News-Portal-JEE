package main;

import java.util.HashMap;

public class Language {
    private Long id;
    private String name;
    private String code;
    private String iconURL;
    private static HashMap<String, HashMap<String, String>> locales;

    static {
        HashMap<String, HashMap<String, String>> locales = new HashMap<>();
        HashMap<String, String> localeRU = new HashMap<>();
        localeRU.put("home", "Главная");
        localeRU.put("login", "Вход");
        localeRU.put("email", "Электронная почта:");
        localeRU.put("password", "Пароль:");
        localeRU.put("login_error", "Неверный <strong>почтовый адрес</strong> или <strong>пароль</strong>. Попробуйте снова!");
        localeRU.put("about_source", "Об источнике");
        localeRU.put("contact_us", "Свяжитесь с нами:");
        localeRU.put("address", "Республика Казахстан, г. Алматы, ул. Айманова 126, 050005");


        HashMap<String, String> localeEN = new HashMap<>();
        localeEN.put("home", "Home");
        localeEN.put("login", "Log In");
        localeEN.put("email", "Email:");
        localeEN.put("password", "Password:");
        localeEN.put("login_error", "Invalid <strong>email</strong> or <strong>password</strong>. Try again!");
        localeEN.put("about_source", "About");
        localeEN.put("contact_us", "Contact us:");
        localeEN.put("address", "Aymanova st. 126, Almaty, 050005, Kazakhstan");

        locales.put("ru", localeRU);
        locales.put("en", localeEN);
        Language.setLocales(locales);
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

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public static void setLocales(HashMap<String, HashMap<String, String>> locales) {
        Language.locales = locales;
    }

    public static HashMap<String, HashMap<String, String>> getLocales() {
        return Language.locales;
    }
    public static HashMap<String, String> getLocale(String langCode) {
        if (langCode.equalsIgnoreCase("ru")) {
            return locales.get(langCode);
        }
        else if (langCode.equalsIgnoreCase("en")) {
            return locales.get(langCode);
        }
        else return null;
    }
}
