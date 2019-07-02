import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class GUI extends JFrame {
    public GUI(){
        JLabel labelSumCred = new JLabel("Сумма кредита") ;
        JTextField textFieldSumCred = new JTextField() ;
        JCheckBox caseCheckBox = new JCheckBox("Стандартные интервалы") ;
        JCheckBox wrapCheckBox = new JCheckBox("Wrap Around") ;
        JCheckBox wholeCheckBox = new JCheckBox("Whole Words") ;
        JCheckBox backCheckBox = new JCheckBox("Search Backwards") ;
        JButton findButton = new JButton("Расчитать!") ;
        JButton cancelButton = new JButton("Закрыть") ;

        caseCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        wrapCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        wholeCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        backCheckBox.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        GroupLayout layout = new GroupLayout(getContentPane()) ;
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true) ;
        layout.setAutoCreateContainerGaps(true) ;

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(labelSumCred)
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(textFieldSumCred)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(caseCheckBox)
                                        .addComponent(wholeCheckBox))
                                .addGroup(layout.createParallelGroup(LEADING)
                                        .addComponent(wrapCheckBox)
                                        .addComponent(backCheckBox))))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addComponent(findButton)
                        .addComponent(cancelButton))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, findButton, cancelButton);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                        .addComponent(labelSumCred)
                        .addComponent(textFieldSumCred)
                        .addComponent(findButton))
                .addGroup(layout.createParallelGroup(LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(caseCheckBox)
                                        .addComponent(wrapCheckBox))
                                .addGroup(layout.createParallelGroup(BASELINE)
                                        .addComponent(wholeCheckBox)
                                        .addComponent(backCheckBox)))
                        .addComponent(cancelButton))
        );

        setTitle("Расчет параметров кредита");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

//    public static void main(String[] args){
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                   UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//                }catch(Exception ex){
//                    ex.printStackTrace();
//                }
//                new GUI().setVisible(true);
//            }
//        });
//    }
}
