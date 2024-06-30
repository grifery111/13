package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DictionaryModification {
    private static final String INSERT_POL_BEL = "INSERT INTO Dictionary (word_polish, word_belarusian) VALUES (?, ?)";
    private static final String INSERT_BEL_POL = "INSERT INTO Dictionary (word_belarusian, word_polish) VALUES (?, ?)";

    public void addTranslation(String language, String word1, String word2) {
        String query = language.equals("polish") ? INSERT_POL_BEL : INSERT_BEL_POL;

        try (Connection conn = DatabaseConnection.getConnection("polish".equals(language) ? "pol_bel_db" : "bel_pol_db");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, word1);
            stmt.setString(2, word2);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}