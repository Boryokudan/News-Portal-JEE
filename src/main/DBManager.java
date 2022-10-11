package main;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/bootcamp",
                    "postgres",
                    "postgres"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser(User user) {
        if (user != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO t_users (email, password, full_name) " +
                            "VALUES (?, ?, ?)"
                );
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getFullName());

                statement.executeUpdate();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException();
        }
    }
    public static User getUser(String email) {
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM t_users WHERE email = ?"
            );
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(resultSet.getInt("role"));

                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = null;

        try {
            users = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM t_users"
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(resultSet.getInt("role"));
                users.add(user);

                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Source> getSources() {
        ArrayList<Source> sources = null;

        try {
            sources = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(
                "SELECT src.id, " +
                    "       src.source_name, " +
                    "       src.source_description, " +
                    "       src.source_url, " +
                    "       lang.lang_code " +
                    "FROM t_source_data src " +
                    "INNER JOIN t_languages lang ON src.lang_id = lang.id;"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Source source = new Source();

                source.setId(resultSet.getLong("id"));
                source.setSourceName(resultSet.getString("source_name"));
                source.setSourceDescription(resultSet.getString("source_description"));
                source.setSourceURL(resultSet.getString("source_url"));
                source.setSourceLangCode(resultSet.getString("lang_code"));

                sources.add(source);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sources;
    }

    public static Publication getPublication(Long id) {
        Publication publication = null;
        try {
            publication = new Publication();

            PreparedStatement statement = connection.prepareStatement(
                "SELECT pub.id, " +
                    "       pub.rating, " +
                    "       pub.news_id, " +
                    "       nw.source_id, " +
                    "       nw.title, " +
                    "       nw.description, " +
                    "       nw.content, " +
                    "       nw.date, " +
                    "       nw.image_url, " +
                    "       nw.lang_id, " +
                    "       src.source_name, " +
                    "       src.source_description, " +
                    "       src.source_url, " +
                    "       lang.lang_name, " +
                    "       lang.lang_code, " +
                    "       lang.lang_icon " +
                    "FROM t_publications pub " +
                    "INNER JOIN t_news nw ON nw.id = pub.news_id " +
                    "INNER JOIN t_source_data src ON src.id = nw.source_id " +
                    "INNER JOIN t_languages lang ON lang.id = nw.lang_id " +
                    "WHERE pub.id = ?"
            );
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                publication.setId(resultSet.getLong("id"));
                publication.setRating(resultSet.getDouble("rating"));

                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                news.setTitle(resultSet.getString("title"));
                news.setDescription(resultSet.getString("description"));
                news.setContent(resultSet.getString("content"));
                news.setDate(resultSet.getString("date"));
                news.setImageURL(resultSet.getString("image_url"));

                Source source = new Source();
                source.setId(resultSet.getLong("source_id"));
                source.setSourceName(resultSet.getString("source_name"));
                source.setSourceDescription(resultSet.getString("source_description"));
                source.setSourceURL(resultSet.getString("source_url"));

                Language language = new Language();
                language.setId(resultSet.getLong("lang_id"));
                language.setName(resultSet.getString("lang_name"));
                language.setCode(resultSet.getString("lang_code"));
                language.setIconURL(resultSet.getString("lang_icon"));

                news.setSource(source);
                news.setLanguage(language);
                publication.setNews(news);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publication;
    }


    public static ArrayList<Publication> getPublications() {
        ArrayList<Publication> publications = null;
        try {
            publications = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(
                "SELECT pub.id, " +
                    "       pub.rating, " +
                    "       pub.news_id, " +
                    "       nw.source_id, " +
                    "       nw.title, " +
                    "       nw.description, " +
                    "       nw.content, " +
                    "       nw.date, " +
                    "       nw.image_url, " +
                    "       nw.lang_id, " +
                    "       src.source_name, " +
                    "       src.source_description, " +
                    "       src.source_url, " +
                    "       lang.lang_name, " +
                    "       lang.lang_code, " +
                    "       lang.lang_icon " +
                    "FROM t_publications pub " +
                    "INNER JOIN t_news nw ON nw.id = pub.news_id " +
                    "INNER JOIN t_source_data src ON src.id = nw.source_id " +
                    "INNER JOIN t_languages lang ON lang.id = nw.lang_id " +
                    "ORDER BY pub.id"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setId(resultSet.getLong("id"));
                publication.setRating(resultSet.getDouble("rating"));

                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                news.setTitle(resultSet.getString("title"));
                news.setDescription(resultSet.getString("description"));
                news.setContent(resultSet.getString("content"));
                news.setDate(resultSet.getString("date"));
                news.setImageURL(resultSet.getString("image_url"));

                Source source = new Source();
                source.setId(resultSet.getLong("source_id"));
                source.setSourceName(resultSet.getString("source_name"));
                source.setSourceDescription(resultSet.getString("source_description"));
                source.setSourceURL(resultSet.getString("source_url"));
                source.setSourceLangCode(resultSet.getString("lang_code"));

                Language language = new Language();
                language.setId(resultSet.getLong("lang_id"));
                language.setName(resultSet.getString("lang_name"));
                language.setCode(resultSet.getString("lang_code"));
                language.setIconURL(resultSet.getString("lang_icon"));

                news.setSource(source);
                news.setLanguage(language);
                publication.setNews(news);
                publications.add(publication);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publications;
    }

    public static ArrayList<Language> getLanguages() {
        ArrayList<Language> languages = null;
        try {
            languages = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM t_languages"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Language language = new Language();
                language.setId(resultSet.getLong("id"));
                language.setName(resultSet.getString("lang_name"));
                language.setCode(resultSet.getString("lang_code"));
                language.setIconURL(resultSet.getString("lang_icon"));
                languages.add(language);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }
}