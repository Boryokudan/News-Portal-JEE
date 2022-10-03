package main;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    public static ArrayList<String> getSources(ArrayList<Publication> publications) {
        ArrayList<String> sources = new ArrayList<>();

        for (Publication publication : publications) {
            String source = publication.getNews().getSource();
            if (!sources.contains(source)) {
                sources.add(source);
            }
        }
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
}

//    public static ArrayList<News> getFirstThree(Language lang) {
//        ArrayList<News> firstThree = null;
//        try{
//            firstThree = new ArrayList<>();
//
//            PreparedStatement statement = connection.prepareStatement(
//                "SELECT pub.id, " +
//                    "       pub.rating, " +
//                    "       pub.news_id, " +
//                    "       nw.source, " +
//                    "       nw.title, " +
//                    "       nw.description, " +
//                    "       nw.content, " +
//                    "       nw.date, " +
//                    "       nw.image_url, " +
//                    "       nw.lang_id, " +
//                    "       lang.lang_name, " +
//                    "       lang.lang_code " +
//                    "FROM t_publications pub " +
//                    "INNER JOIN t_news nw ON nw.id = pub.news_id " +
//                    "INNER JOIN t_languages lang ON lang.id = nw.lang_id " +
//                    "ORDER BY pub.rating DESC, nw.date DESC"
//            );
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Publication publication = new Publication();
//                publication.setId(resultSet.getLong("id"));
//                publication.setRating(resultSet.getDouble("rating"));
//
//                News news = new News();
//                news.setId(resultSet.getLong("news_id"));
//                news.setSource(resultSet.getString("source"));
//                news.setTitle(resultSet.getString("title"));
//                news.setDescription(resultSet.getString("description"));
//                news.setContent(resultSet.getString("content"));
//                news.setDate(resultSet.getString("date"));
//                news.setImageURL(resultSet.getString("image_url"));
//
//                Language language = new Language();
//                language.setId(resultSet.getLong("lang_id"));
//                language.setName(resultSet.getString("lang_name"));
//                language.setCode(resultSet.getString("lang_code"));
//
//                news.setLanguage(language);
//                publication.setNews(news);
//
//                publications.add(publication);
//            }
//            statement.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return firstThree;
//    }