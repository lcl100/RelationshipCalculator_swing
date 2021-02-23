package view;

import map.NameProperty;
import map.RelationshipMap;
import util.StyleUtil;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    private JPanel relationPanel, nameButtonPanel, countButtonPanel, resultPanel;
    private JLabel relationLabel, resultLabel;
    private JTextArea inputRelationTextArea, outputResultTextArea;
    private JButton fatherButton, motherButton, husbandButton, wifeButton, sonButton, daughterButton, bigBrotherButton, smallBrotherButton, bigSisterButton, smallSisterButton, countButton, undoButton, clearButton;
    private int count = 0;
    private UndoManager undoManager;

    public Frame() {
        setTitle("亲属关系称谓计算查询");
        setBounds(200, 200, 750, 700);
        setLayout(new GridLayout(4, 1));

        relationPanel = new JPanel();
        relationPanel.setLayout(new BorderLayout());
        relationPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        relationLabel = new JLabel("关系：");
        inputRelationTextArea = new JTextArea(5, 20);
        relationPanel.add(relationLabel, BorderLayout.NORTH);
        relationPanel.add(inputRelationTextArea, BorderLayout.CENTER);
        add(relationPanel);

        nameButtonPanel = new JPanel();
        nameButtonPanel.setLayout(new FlowLayout());
        nameButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        fatherButton = new JButton("父");
        motherButton = new JButton("母");
        husbandButton = new JButton("夫");
        wifeButton = new JButton("妻");
        sonButton = new JButton("子");
        daughterButton = new JButton("女");
        bigBrotherButton = new JButton("兄");
        smallBrotherButton = new JButton("弟");
        bigSisterButton = new JButton("姐");
        smallSisterButton = new JButton("妹");
        nameButtonPanel.add(fatherButton);
        nameButtonPanel.add(motherButton);
        nameButtonPanel.add(husbandButton);
        nameButtonPanel.add(wifeButton);
        nameButtonPanel.add(sonButton);
        nameButtonPanel.add(daughterButton);
        nameButtonPanel.add(bigBrotherButton);
        nameButtonPanel.add(smallBrotherButton);
        nameButtonPanel.add(bigSisterButton);
        nameButtonPanel.add(smallSisterButton);
        add(nameButtonPanel);

        fatherButton.addActionListener(this);
        motherButton.addActionListener(this);
        husbandButton.addActionListener(this);
        wifeButton.addActionListener(this);
        sonButton.addActionListener(this);
        daughterButton.addActionListener(this);
        bigBrotherButton.addActionListener(this);
        smallBrotherButton.addActionListener(this);
        bigSisterButton.addActionListener(this);
        smallSisterButton.addActionListener(this);

        countButtonPanel = null;
        countButtonPanel = new JPanel();
        countButtonPanel.setLayout(new FlowLayout());
        countButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        countButton = new JButton("计算");
        undoButton = new JButton("回退");
        clearButton = new JButton("清空");
        countButtonPanel.add(countButton);
        countButtonPanel.add(undoButton);
        countButtonPanel.add(clearButton);
        add(countButtonPanel);

        undoManager = new UndoManager();
        inputRelationTextArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        // “计算”按钮事件
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = new NameProperty().convertTextAreaToString(inputRelationTextArea);
                outputResultTextArea.setText(new RelationshipMap().getRelationShipValueByMap(key));
            }
        });

        // “回退”按钮事件
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoManager.undo();
            }
        });

        // ”清空“按钮事件
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputRelationTextArea.setText("");
                outputResultTextArea.setText("");
            }
        });


        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        resultLabel = new JLabel("计算结果：");
        outputResultTextArea = new JTextArea(5, 20);
        outputResultTextArea.setEditable(false);
        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(outputResultTextArea, BorderLayout.CENTER);
        add(resultPanel);

        // 设置样式
        setStyle();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断文本域是否为空，如果是则将累计的按钮点击次数清零，重新计数
        if (inputRelationTextArea.getText().trim().equals(null) || inputRelationTextArea.getText().equals("")) {
            count = 0;
        }
        // 判断事件源是哪一个按钮，并为其设置响应操作
        if (e.getSource() == fatherButton) {
            setText(fatherButton);
        } else if (e.getSource() == motherButton) {
            setText(motherButton);
        } else if (e.getSource() == husbandButton) {
            setText(husbandButton);
        } else if (e.getSource() == wifeButton) {
            setText(wifeButton);
        } else if (e.getSource() == sonButton) {
            setText(sonButton);
        } else if (e.getSource() == daughterButton) {
            setText(daughterButton);
        } else if (e.getSource() == bigBrotherButton) {
            setText(bigBrotherButton);
        } else if (e.getSource() == smallBrotherButton) {
            setText(smallBrotherButton);
        } else if (e.getSource() == bigSisterButton) {
            setText(bigSisterButton);
        } else if (e.getSource() == smallSisterButton) {
            setText(smallSisterButton);
        }
    }

    /**
     * 将按钮名添加到文本域显示亲戚关系并根据判断其添加“的”前缀
     *
     * @param nameButton 按钮
     */
    private void setText(JButton nameButton) {
        String name;
        // 判断按钮的被点击次数是否为0
        if (count == 0) {
            // 如果是0，表示是第一次点击按钮，故不为其添加“的”前缀（即关系之间的分隔标志）
            name = new NameProperty().getNameByButton(nameButton);
        } else {
            // 如果不是0，则表示是第二次或者第N此点击按钮，因此需要为其添加“的”前缀作为亲戚关系之间的分隔
            name = "的" + new NameProperty().getNameByButton(nameButton);
        }
        // 按钮次数统计加一
        count++;
        // 将关系字符串显示到文本域中
        inputRelationTextArea.append(name);
    }

    /**
     * 为整个界面添加样式
     */
    private void setStyle() {
        StyleUtil style = new StyleUtil();
        // 设置名称按钮的样式
        style.setNameButtonStyle(fatherButton, motherButton, husbandButton, wifeButton, sonButton, daughterButton, bigBrotherButton, smallBrotherButton, bigSisterButton, smallSisterButton);
        // 设置计算按钮的样式
        style.setCountButtonStyle(countButton, undoButton, clearButton);
        countButton.setBackground(new Color(66, 139, 202));
        undoButton.setBackground(new Color(92, 184, 92));
        clearButton.setBackground(new Color(217, 83, 79));
        // 设置标签的样式
        style.setLabelStyle(relationLabel, resultLabel);
        // 设置文本域的样式
        style.setTextAreaStyle(inputRelationTextArea, outputResultTextArea);
        // 设置面板的样式
        style.setPanelStyle(relationPanel, nameButtonPanel, countButtonPanel, resultPanel);
        // 设置窗体的样式
        style.setFrameStyle(this);
        // 设置图片
        style.setTitleIcon(this, "images/qinshu.png");
    }
}
