package org;
import java.sql.*;

public class ScholarIntegration {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/scholar";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        // Connect to the database
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        // Call the Scholar API and process the results
        Scholar scholar = new Scholar();
        ScholarQuery query = new ScholarQuery();
        query.setPhrase("java maven integration");
        ScholarResult result = scholar.search(query);
        for (ScholarResult res : result) {
            // Insert the results into the database
            String title = res.getTitle();
            String author = res.getAuthor();
            String publicationDate = res.getPublicationDate();
            String journalConference = res.getJournalConference();
            String summary = res.getSummary();
            int numCitations = res.getNumCitations();
            String sql = "INSERT INTO articles (titulo, autor, fecha_publicacion, revista_conferencia, resumen, numero_citas) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, publicationDate);
            stmt.setString(4, journalConference);
            stmt.setString(5, summary);
            stmt.setInt(6, numCitations);
            stmt.executeUpdate();
        }

        // Close the database connection
        conn.close();
    }
}
