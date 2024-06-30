package com.example.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DictionaryQueries {
    private static final String SELECT_POL_BEL = "SELECT word_belarusian FROM Dictionary WHERE word_polish = ?";
    private static final String SELECT_BEL_POL = "SELECT word_polish FROM Dictionary WHERE word_belarusian = ?";

    public String getTranslation(String language, String word) {
        String query = language.equals("polish") ? SELECT_POL_BEL : SELECT_BEL_POL;
        String columnLabel = language.equals("polish") ? "word_belarusian" : "word_polish";

        try (Connection conn = DatabaseConnection.getConnection("polish".equals(language) ? "pol_bel_db" : "bel_pol_db");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(columnLabel);
            } else {
                return "Перевод не найден";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Произошла ошибка при получении перевода";
        }
    }
}