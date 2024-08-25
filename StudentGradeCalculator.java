import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame implements ActionListener {
    private JTextField subject1Field, subject2Field, subject3Field, subject4Field, subject5Field;
    private JLabel resultLabel;
    private JButton calculateButton, resetButton;

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(45, 45, 45)); // Dark background color
        setLayout(new GridLayout(8, 2, 10, 10));

        // Subject Labels and Text Fields
        addLabelAndField("Subject 1:", subject1Field = new JTextField());
        addLabelAndField("Subject 2:", subject2Field = new JTextField());
        addLabelAndField("Subject 3:", subject3Field = new JTextField());
        addLabelAndField("Subject 4:", subject4Field = new JTextField());
        addLabelAndField("Subject 5:", subject5Field = new JTextField());

        // Calculate Button
        calculateButton = new JButton("Calculate Grade");
        calculateButton.addActionListener(this);
        calculateButton.setBackground(new Color(60, 60, 60)); // Dark button background
        calculateButton.setForeground(Color.WHITE);
        add(calculateButton);

        // Reset Button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetFields());
        resetButton.setBackground(new Color(60, 60, 60)); // Dark button background
        resetButton.setForeground(Color.WHITE);
        add(resetButton);

        // Result Label
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setForeground(Color.WHITE);
        add(resultLabel);

        setVisible(true);
    }

    private void addLabelAndField(String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText, SwingConstants.RIGHT);
        label.setForeground(Color.WHITE);
        textField.setBackground(new Color(30, 30, 30)); // Dark input field
        textField.setForeground(Color.WHITE);
        add(label);
        add(textField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int subject1 = Integer.parseInt(subject1Field.getText());
            int subject2 = Integer.parseInt(subject2Field.getText());
            int subject3 = Integer.parseInt(subject3Field.getText());
            int subject4 = Integer.parseInt(subject4Field.getText());
            int subject5 = Integer.parseInt(subject5Field.getText());

            int total = subject1 + subject2 + subject3 + subject4 + subject5;
            double average = total / 5.0;
            String grade = calculateGrade(average);

            resultLabel.setText("Result: Total = " + total + ", Average = " + average + ", Grade = " + grade);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    private String calculateGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    private void resetFields() {
        subject1Field.setText("");
        subject2Field.setText("");
        subject3Field.setText("");
        subject4Field.setText("");
        subject5Field.setText("");
        resultLabel.setText("Result: ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGradeCalculator::new);
    }
}
