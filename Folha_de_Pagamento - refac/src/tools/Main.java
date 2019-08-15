/**!
 * @className tools.Main.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package tools;

import prjpatterns.Menu;
import prjpatterns.Singleton;

public class Main {

    public static void main(String[] args)
    {
        Menu myMenu = Singleton.getMyMenu();
        myMenu.instanceOfMenu();
    }
}
