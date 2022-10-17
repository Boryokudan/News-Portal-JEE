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
        localeRU.put("have_account", "Есть аккаунт?");
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
        localeRU.put("edit", "Изменить");
        localeRU.put("cancel", "Отмена");
        localeRU.put("access_denied", "Отказано в доступе. У вас нет допуска к данной странице!");
        localeRU.put("404", "Страница, которую вы ищете не найдена или содержание страницы не соответствует выбранному языку!");
        localeRU.put("null_fields", "Заполните все поля!");
        localeRU.put("email_error", " уже <strong>используется!</strong>");
        localeRU.put("passwords_error", "Пароли не совпадают!");
        localeRU.put("login_error", "Неверный <strong>почтовый адрес</strong> или <strong>пароль</strong>. Попробуйте снова!");
        localeRU.put("greeting", "Добро пожаловать, ");
        localeRU.put("about_source", "Об источнике");
        localeRU.put("contact_us", "Свяжитесь с нами:");
        localeRU.put("address", "Республика Казахстан, г. Алматы, ул. Айманова 126, 050005");

        localeRU.put("admin_pane", "Панель Админа");
        localeRU.put("publications", "Публикации");
        localeRU.put("news", "Новости");
        localeRU.put("languages", "Языки");
        localeRU.put("add", "Добавить");
        localeRU.put("add_publication", "Добавить публикацию");
        localeRU.put("close", "Закрыть");
        localeRU.put("search", "Поиск");
        localeRU.put("id", "ID");
        localeRU.put("source", "Источник");
        localeRU.put("title", "Заголовок");
        localeRU.put("description", "Описание");
        localeRU.put("content", "Содержание");
        localeRU.put("date", "Дата");
        localeRU.put("language", "Язык");
        localeRU.put("language_name", "Название языка");
        localeRU.put("language_code", "Сокращенное название");
        localeRU.put("language_icon", "Иконка");
        localeRU.put("image_url", "Ссылка на изображение");
        localeRU.put("rating", "Рейтинг");
        localeRU.put("details", "Подробнее");
        localeRU.put("delete", "Удалить");


        HashMap<String, String> localeEN = new HashMap<>();
        localeEN.put("home", "Home");
        localeEN.put("admin_panel", "MyAdmin");
        localeEN.put("dont_have_account", "Don't have an account?");
        localeEN.put("have_account", "Have an account?");
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
        localeEN.put("access_denied", "Access denied. You have no rights to see the content of this page.");
        localeEN.put("404", "Page you are looking for is not found or language of the content does not match your current language!");
        localeEN.put("null_fields", "Fill in all the fields!");
        localeEN.put("email_error", " is <strong>already</strong> in use!");
        localeEN.put("passwords_error", "Passwords do not match!");
        localeEN.put("user_role", "Account type: ");
        localeEN.put("edit", "Edit");
        localeEN.put("cancel", "Cancel");
        localeEN.put("login_error", "Invalid <strong>email</strong> or <strong>password</strong>. Try again!");
        localeEN.put("greeting", "Welcome, ");
        localeEN.put("about_source", "About");
        localeEN.put("contact_us", "Contact us:");
        localeEN.put("address", "Aymanova st. 126, Almaty, 050005, Kazakhstan");

        localeEN.put("admin_pane", "Admin Panel");
        localeEN.put("publications", "Publications");
        localeEN.put("news", "News");
        localeEN.put("languages", "Languages");
        localeEN.put("add", "Add");
        localeEN.put("add_publication", "Add a publication");
        localeEN.put("close", "Close");
        localeEN.put("search", "Search");
        localeEN.put("id", "ID");
        localeEN.put("source", "Source");
        localeEN.put("title", "Title");
        localeEN.put("description", "Description");
        localeEN.put("content", "Content");
        localeEN.put("date", "Date");
        localeEN.put("language", "Language");
        localeEN.put("language_name", "Language Name");
        localeEN.put("language_code", "Code");
        localeEN.put("language_icon", "Icon");
        localeEN.put("image_url", "Image URL");
        localeEN.put("rating", "Rating");
        localeEN.put("details", "Details");
        localeEN.put("delete", "Delete");

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
