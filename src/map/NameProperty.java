package map;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class NameProperty {
    Map<String, String> map = null;

    /**
     * 操作结果：根据传入的按钮获得其称呼
     *
     * @param button
     * @return
     */
    public String getNameByButton(JButton button) {
        map = new HashMap<String, String>();
        map.put("父", "爸爸");
        map.put("母", "妈妈");
        map.put("夫", "老公");
        map.put("妻", "老婆");
        map.put("子", "儿子");
        map.put("女", "女儿");
        map.put("兄", "哥哥");
        map.put("弟", "弟弟");
        map.put("姐", "姐姐");
        map.put("妹", "妹妹");

        String buttonName = button.getText();
        String returnName = map.get(buttonName);
        return returnName;
    }

    /**
     * 操作结果：将文本域获得的内容转换成Map的一种映射
     *
     * @param textArea
     * @return
     */
    public String convertTextAreaToString(JTextArea textArea) {
        String[] names = {"的", "爸爸", "妈妈", "老公", "老婆", "儿子", "女儿", "哥哥", "弟弟", "姐姐", "妹妹"};
        String[] simpleNames = {",", "f", "m", "h", "w", "s", "d", "bb", "sb", "bs", "ss"};
        String resultContent = textArea.getText();
        for (int i = 0; i < names.length; i++) {
            resultContent = resultContent.replace(names[i], simpleNames[i]);
        }
        return resultContent;
    }

}
