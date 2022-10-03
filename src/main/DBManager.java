package main;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

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
                languages.add(language);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    public static Set<String> getSources() {
        ArrayList<Publication> publications = DBManager.getPublications();
        Set<String> sources = new TreeSet<>();
        publications.stream().filter(publication -> sources.add(publication.getNews().getSource())).collect(Collectors.toList());
        return sources;
    }

    public static ArrayList<Publication> getPublications() {
        ArrayList<Publication> publications = null;
        try {
            publications = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT pub.id, " +
                            "       pub.rating, " +
                            "       pub.news_id, " +
                            "       nw.source, " +
                            "       nw.title, " +
                            "       nw.description, " +
                            "       nw.content, " +
                            "       nw.date, " +
                            "       nw.image_url, " +
                            "       nw.lang_id, " +
                            "       lang.lang_name, " +
                            "       lang.lang_code " +
                            "FROM t_publications pub " +
                            "INNER JOIN t_news nw ON nw.id = pub.news_id " +
                            "INNER JOIN t_languages lang ON lang.id = nw.lang_id " +
                            "ORDER BY pub.rating DESC, nw.date DESC"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Publication publication = new Publication();
                publication.setId(resultSet.getLong("id"));
                publication.setRating(resultSet.getDouble("rating"));

                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                news.setSource(resultSet.getString("source"));
                news.setTitle(resultSet.getString("title"));
                news.setDescription(resultSet.getString("description"));
                news.setContent(resultSet.getString("content"));
                news.setDate(resultSet.getString("date"));
                news.setImageURL(resultSet.getString("image_url"));

                Language language = new Language();
                language.setId(resultSet.getLong("lang_id"));
                language.setName(resultSet.getString("lang_name"));
                language.setCode(resultSet.getString("lang_code"));

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

    public static Publication getPublication(Long id) {
        Publication publication = null;
        try {
            publication = new Publication();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT pub.id, " +
                            "       pub.rating, " +
                            "       pub.news_id, " +
                            "       nw.source, " +
                            "       nw.title, " +
                            "       nw.description, " +
                            "       nw.content, " +
                            "       nw.date, " +
                            "       nw.image_url, " +
                            "       nw.lang_id, " +
                            "       lang.lang_name, " +
                            "       lang.lang_code " +
                            "FROM t_publications pub " +
                            "INNER JOIN t_news nw ON nw.id = pub.news_id " +
                            "INNER JOIN t_languages lang ON lang.id = nw.lang_id " +
                            "WHERE pub.id = ?"
            );
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                publication.setId(resultSet.getLong("id"));
                publication.setRating(resultSet.getDouble("rating"));

                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                news.setSource(resultSet.getString("source"));
                news.setTitle(resultSet.getString("title"));
                news.setDescription(resultSet.getString("description"));
                news.setContent(resultSet.getString("content"));
                news.setDate(resultSet.getString("date"));
                news.setImageURL(resultSet.getString("image_url"));

                Language language = new Language();
                language.setId(resultSet.getLong("lang_id"));
                language.setName(resultSet.getString("lang_name"));
                language.setCode(resultSet.getString("lang_code"));

                news.setLanguage(language);
                publication.setNews(news);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publication;
    }

    public static String getSourceDescription(String sourceName) {
        String sourceDescription = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT source_description " +
                        "FROM t_source_descriptions " +
                        "WHERE source_name = ?"
            );
            statement.setString(1, sourceName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sourceDescription = resultSet.getString("source_description");
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourceDescription;
    }
}