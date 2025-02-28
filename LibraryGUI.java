import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class LibraryGUI extends JFrame {
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private JTextField titleField, authorField, isbnField;

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table Setup
        tableModel = new DefaultTableModel(new String[]{"ID", "Title", "Author", "ISBN", "Available"}, 0);
        bookTable = new JTable(tableModel);
        add(new JScrollPane(bookTable), BorderLayout.CENTER);

        // Input Fields & Buttons
        JPanel panel = new JPanel(new GridLayout(2, 4));

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        panel.add(isbnField);

        JButton addButton = new JButton("Add Book");
        panel.add(addButton);

        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener((ActionEvent e) -> addBook());

        refreshTable();
        setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String isbn = isbnField.getText().trim();

        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (BookDAO.addBook(title, author, isbn)) {
            JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add book. ISBN might already exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        List<Book> books = BookDAO.getAllBooks();
        for (Book book : books) {
            tableModel.addRow(new Object[]{book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.isAvailable() ? "Yes" : "No"});
        }
    }

    public static void main(String[] args) {
        DatabaseHelper.createTables();
        SwingUtilities.invokeLater(LibraryGUI::new);
    }
}
