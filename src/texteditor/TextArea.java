package texteditor;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.GroupLayout.*;


public class TextArea extends JFrame implements DocumentListener {

    private JLabel jLabel1 = new JLabel("Enter your text here");
    private JTextArea textArea;
    private JScrollPane areaScrollPane;
    private GroupLayout layout;
    private String userText;

    public TextArea() {
        super("Enter Your Text");
        initComponents();
        textArea.getDocument().addDocumentListener(this);
    }

    private void initComponents() {
        buildTextArea();
        buildLayout();
        setUserText();
    }
    private void buildTextArea(){
        textArea = new JTextArea();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setFont(new Font("font", Font.ROMAN_BASELINE, 16));
    }
    private void buildLayout(){
        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        SequentialGroup h1 = layout.createSequentialGroup();
        ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        h2.addComponent(areaScrollPane, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE);
        h2.addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE);
        h1.addContainerGap();
        h1.addGroup(h2);
        h1.addContainerGap();
        hGroup.addGroup(Alignment.TRAILING,h1);
        layout.setHorizontalGroup(hGroup);
        ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        SequentialGroup v1 = layout.createSequentialGroup();
        v1.addContainerGap();
        v1.addComponent(jLabel1);
        v1.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
        v1.addComponent(areaScrollPane, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE);
        v1.addContainerGap();
        vGroup.addGroup(v1);
        layout.setVerticalGroup(vGroup);
        pack();
    }
    public void setUserText(){
       this.userText = textArea.getText();
    }

    public String getUserText() {
        return userText;
    }


    /**
     * Gives notification that there was an insert into the document.  The
     * range given by the DocumentEvent bounds the freshly inserted region.
     *
     * @param e the document event
     */
    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    /**
     * Gives notification that a portion of the document has been
     * removed.  The range is given in terms of what the view last
     * saw (that is, before updating sticky positions).
     *
     * @param e the document event
     */
    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    /**
     * Gives notification that an attribute or set of attributes changed.
     *
     * @param e the document event
     */
    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
