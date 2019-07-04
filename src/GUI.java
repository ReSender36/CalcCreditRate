import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class GUI extends JFrame implements ActionListener {
    JTextField textFieldSumCred ;
    JTextField textFieldPersYearFee ;
    JTextField textFieldCreditPeriod ;

    JButton calcButton ;
    JButton closeButton ;

    JCheckBox chbStdIntervals ;

    public GUI(){
        JLabel labelSumCred = new JLabel("Сумма кредита") ;
        textFieldSumCred = new JTextField() ;
        JLabel labelPersYearFee = new JLabel("Процентная ставка") ;
        textFieldPersYearFee = new JTextField() ;
        JLabel labelCreditPeriod = new JLabel("Срок кредита") ;
        textFieldCreditPeriod = new JTextField() ;

        chbStdIntervals = new JCheckBox("Стандартные интервалы") ;
        chbStdIntervals.addActionListener(this);
        JCheckBox wrapCheckBox = new JCheckBox("Wrap Around") ;
        JCheckBox wholeCheckBox = new JCheckBox("Whole Words") ;
        JCheckBox backCheckBox = new JCheckBox("Search Backwards") ;

        calcButton = new JButton("Расчитать!") ;
        calcButton.addActionListener(this);
        closeButton = new JButton("Закрыть") ;
        closeButton.addActionListener(this);

        chbStdIntervals.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        wrapCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        wholeCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        backCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        GroupLayout layout = new GroupLayout(getContentPane()) ;
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true) ;
        layout.setAutoCreateContainerGaps(true) ;

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(LEADING)
               .addComponent(labelSumCred)
               .addComponent(labelPersYearFee)));

        layout.linkSize(SwingConstants.HORIZONTAL, calcButton, closeButton);

        layout.setVerticalGroup(layout.createSequentialGroup());

/*        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(labelSumCred)
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldSumCred)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                       .addComponent(chbStdIntervals)
                                       .addComponent(wholeCheckBox)
                                                                               )
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(wrapCheckBox)
                                        .addComponent(backCheckBox)
                                )))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(calcButton)
                        .addComponent(closeButton))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, calcButton, closeButton);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelSumCred)
                        .addComponent(textFieldSumCred)
                        .addComponent(calcButton))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(chbStdIntervals)
                                       .addComponent(wrapCheckBox)
                                       )
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(wholeCheckBox)
                                        .addComponent(backCheckBox)
                                ))
                        .addComponent(closeButton))
        );
*/
        setTitle("Расчет параметров кредита");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeButton) {
            System.exit(0);
        } else if (calcButton == e.getSource()) {
            String str = textFieldSumCred.getText();
            int iStr = Integer.parseInt(str);
            System.out.println(iStr);
        } else if (chbStdIntervals == e.getSource()){
            if (chbStdIntervals.isSelected())
                textFieldCreditPeriod.setVisible(false);
            else
                textFieldCreditPeriod.setVisible(true);
        }
//        CalcCreditRate ccr = new CalcCreditRate(iStr) ;
//        textFieldSumCred.setText("325");
    }
}
