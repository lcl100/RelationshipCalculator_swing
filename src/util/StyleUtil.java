package util;

import javax.swing.*;
import java.awt.*;

/**
 * 样式方法类
 *
 * @author lck100
 */
public class StyleUtil {
    /**
     * 设置名称按钮的样式（如父、母等按钮）
     *
     * @param buttons 按钮组
     */
    public void setNameButtonStyle(JButton... buttons) {
        for (JButton button : buttons) {
            // 设置背景色
            button.setBackground(new Color(255, 255, 255));
            // 设置前景色
            button.setForeground(new Color(0, 0, 0));
            // 设置字体
            button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            // 设置点击按钮时的边框线
            button.setFocusPainted(false);
            // 设置边界
            button.setBorderPainted(true);
        }
    }

    /**
     * 操作结果：设置“计算”按钮样式
     *
     * @param buttons 计算按钮
     */
    public void setCountButtonStyle(JButton... buttons) {
        for (JButton button : buttons) {
            // 设置前景色
            button.setForeground(new Color(255, 255, 255));
            // 设置字体
            button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
            // 设置点击按钮时的边框线
            button.setFocusPainted(false);
            // 设置边界
            button.setBorderPainted(false);
        }
    }

    /**
     * 操作结果：设置标签样式
     *
     * @param labels 标签组
     */
    public void setLabelStyle(JLabel... labels) {
        for (JLabel label : labels) {
            // 设置字体
            label.setFont(new Font("微软雅黑", Font.PLAIN, 23));
        }
    }

    /**
     * 操作结果：设置文本域样式
     *
     * @param textAreas 文本域组
     */
    public void setTextAreaStyle(JTextArea... textAreas) {
        for (JTextArea textArea : textAreas) {
            // 设置背景色
            textArea.setBackground(new Color(244, 249, 251));
            // 设置字体
            textArea.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            // 设置前景色
            textArea.setForeground(new Color(85, 85, 85));
        }
    }

    /**
     * 操作结果：设置面板样式
     *
     * @param panels 面板组
     */
    public void setPanelStyle(JPanel... panels) {
        for (JPanel panel : panels) {
            // 设置边框
            panel.setBorder(BorderFactory.createLineBorder(new Color(195, 199, 200), 1, true));
            // 设置不透明
            panel.setOpaque(false);
        }
    }

    /**
     * 操作结果：设置窗体样式
     *
     * @param frame 窗体
     */
    public void setFrameStyle(JFrame frame) {
        frame.getContentPane().setBackground(new Color(213, 233, 237));
    }

    /**
     * 操作结果：设置窗体图标标题
     *
     * @param frame         窗体
     * @param titleIconPath 图标路径
     */
    public void setTitleIcon(JFrame frame, String titleIconPath) {
        //Java提供的GUI默认工具类对象
        Toolkit kit = Toolkit.getDefaultToolkit();
        //为指定窗口设置图标标题
        frame.setIconImage(kit.createImage(titleIconPath));
    }
}
