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
        localeRU.put("admin_panel", "MyAdmin");
        localeRU.put("dont_have_account", "Нет аккаунта? Тогда ");
        localeRU.put("then_reg", "регистрируйся"); // ?????????????????????????????????
        localeRU.put("login", "Вход");
        localeRU.put("sign_up", "Регистрация");
        localeRU.put("logout", "Выход");
        localeRU.put("read_more", "Подробнее");
        localeRU.put("name", "Имя:");
        localeRU.put("enter_name", "Введите имя:");
        localeRU.put("email", "Электронная почта:");
        localeRU.put("enter_email", "Введите адрес почты:");
        localeRU.put("password", "Пароль:");
        localeRU.put("enter_password", "Введите пароль:");
        localeRU.put("re_password", "Повторите пароль:");
        localeRU.put("user_role", "Тип учетной записи: ");
        localeRU.put("email_error", " уже <strong>используется!</strong>");
        localeRU.put("login_error", "Неверный <strong>почтовый адрес</strong> или <strong>пароль</strong>. Попробуйте снова!");
        localeRU.put("greeting", "Добро пожаловать, ");
        localeRU.put("about_source", "Об источнике");
        localeRU.put("contact_us", "Свяжитесь с нами:");
        localeRU.put("address", "Республика Казахстан, г. Алматы, ул. Айманова 126, 050005");


        HashMap<String, String> localeEN = new HashMap<>();
        localeEN.put("home", "Home");
        localeEN.put("admin_panel", "MyAdmin");
        localeEN.put("dont_have_account", "Don't have an account?");
        localeEN.put("login", "Log In");
        localeEN.put("sign_up", "Sign Up");
        localeEN.put("logout", "Log Out");
        localeEN.put("read_more", "Read more");
        localeEN.put("name", "Name:");
        localeEN.put("enter_name", "Enter your name:");
        localeEN.put("email", "Email:");
        localeEN.put("enter_email", "Enter your email:");
        localeEN.put("password", "Password:");
        localeEN.put("enter_password", "Enter your password:");
        localeEN.put("re_password", "Repeat your password:");
        localeEN.put("email_error", " is <strong>already</strong> in use!");
        localeEN.put("user_role", "Account type: ");
        localeEN.put("login_error", "Invalid <strong>email</strong> or <strong>password</strong>. Try again!");
        localeEN.put("greeting", "Welcome, ");
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
